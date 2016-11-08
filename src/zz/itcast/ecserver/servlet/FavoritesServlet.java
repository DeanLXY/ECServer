package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IFavoritesDao;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 收藏夹
 * 
 * @author wangx
 *
 */
@WebServlet("/favorites")
public class FavoritesServlet extends BaseServlet {
	private final String PAGE = "page";
	private final String PAGENUM = "pageNum";
	private final String USERID = "userId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageStr = req.getParameter(PAGE);
		String pageNumStr = req.getParameter(PAGENUM);
		String userIdStr = req.getParameter(USERID);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "传递的userId不能为空");
		if (b) {
			return;
		}
		int userid = DefaultUtils.checkNull(userIdStr, 0);
		int page = DefaultUtils.checkNull(pageStr, 0);
		int pageNum = DefaultUtils.checkNull(pageNumStr, 20);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IFavoritesDao favoritesDao = sqlSession.getMapper(IFavoritesDao.class);
		List<Product> favoritesList = favoritesDao.getFavoritesList(userid, page, pageNum);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "favorites");
		data.put("productList", favoritesList);
		data.put("listCount", favoritesList.size());
		
		CommonUtil.renderJson(resp, data);
		
		
		
	}
}
