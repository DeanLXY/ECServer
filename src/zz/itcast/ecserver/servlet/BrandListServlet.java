package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IProductDao;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 品牌列表
 * @author wangx
 *
 */
@WebServlet("/brand/plist")
public class BrandListServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		String orderbyStr = req.getParameter("orderby");
		String pageStr = req.getParameter("page");
		String pageNumStr = req.getParameter("pageNum");
		boolean b = DefaultUtils.checkNull(resp, idStr, "品牌id不存在获取有误");
		if (b) {
			return;
		}
		
		int id = DefaultUtils.checkNull(idStr, 0);
		String orderBy = DefaultUtils.checkNull(orderbyStr, "sales desc");
		int page = DefaultUtils.checkNull(pageStr, 0);
		int pageNum = DefaultUtils.checkNull(pageNumStr, 20);
		
		page = page * pageNum;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		List<Product> productList = productDao.getProductListById(id,page,pageNum,orderBy);
		int productListCount = productDao.getProductListCountById(id);
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response", "brandProductlist");
		data.put("productList",productList);
		data.put("listCount",productListCount);
		CommonUtil.renderJson(resp, data);
	}
}
