package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IFavoritesDao;
import zz.itcast.ecserver.dao.IProductDao;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 添加收藏
 * 
 * @author wangx
 *
 */
@WebServlet("/addfavorites")
public class AddfavoritesServlet extends BaseServlet {
	private final String USERID = "userId";
	private final String PRODUCTID = "productId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter(USERID);
		String productIdStr = req.getParameter(PRODUCTID);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "需要传递userId不能为空");
		if (b) {
			return;
		}

		int userId = DefaultUtils.checkNull(userIdStr, 0);
		int productId = DefaultUtils.checkNull(productIdStr, 0);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		Product product = productDao.getProductById(productId);
		if (product == null) {
			DefaultUtils.defalutError(resp, "商品信息不存在,请确认后重新收藏");
			return;
		}

		System.out.println("查询详细商品信息>>>" + product);
		IFavoritesDao favoritesDao = sqlSession.getMapper(IFavoritesDao.class);
		//重复收藏处理
		Product favoritesProduct = favoritesDao.getFavoritesById(userId,productId);
		if (favoritesProduct != null) {
			DefaultUtils.defalutError(resp, "商品已收藏");
			return;
		}
		
		
		favoritesDao.addNewFavorites(userId, product);
		sqlSession.commit();

		sqlSession.close();

		// 添加商品成功
		Map<String, String> data = new HashMap<String, String>();
		data.put("response", "addfavorites");
		CommonUtil.renderJson(resp, data);

	}
}
