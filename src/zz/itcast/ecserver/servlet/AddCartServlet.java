package zz.itcast.ecserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IProductDao;
import zz.itcast.ecserver.dao.IShoppingCartDao;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 添加到购物车 servlet
 * @author wangx
 *
 */
@WebServlet("/cart/add")
public class AddCartServlet extends BaseServlet {

	private static final String SKU = "sku";
	private static final String USER_ID = "userId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter(USER_ID);
		String skuStr = req.getParameter(SKU);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "userId不能为空,否则不知道你是谁");
		if (b) {
			return;
		}
		b = DefaultUtils.checkNull(resp, skuStr, "sku值没有,你要购买什么商品");
		if (b) {
			return;
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		// sku  3:3:1,3|5:2:2
		String[] skus = skuStr.split("\\|");
		if (skus.length == 0) {
			DefaultUtils.defalutError(resp, "不存在的商品");
			return;
			
		}
		
		for (int i = 0; i < skus.length; i++) {
			String[] sku = skus[i].split(":");
			if (sku.length < 2) {
				DefaultUtils.defalutError(resp, "sku传递错误");
				return;
			}
			
			// 根据商品id 查看商品是否存在
			String product_id = sku[0];
			String product_num = sku[1];
			Product product = productDao.getProductById(product_id);
			if (product == null) {
				DefaultUtils.defalutError(resp, "不存在的商品,商品id = "+product_id);
				return;
			}
			
			int user_id = DefaultUtils.checkNull(userIdStr, 1);
			
			//添加商品信息
			IShoppingCartDao shoppingCartDao = sqlSession.getMapper(IShoppingCartDao.class);
			
			int productNum = DefaultUtils.checkNull(product_num, 0);
			for (int j = 0; j < productNum; j++) {
				shoppingCartDao.addNewProduct2Cart(user_id, product_id);
				sqlSession.commit();
			}
			
			
			
		}
		sqlSession.close();
	}
}
