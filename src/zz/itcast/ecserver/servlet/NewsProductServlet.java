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
 * 新品商品列表servlet
 * 
 * @author wangx
 *
 */
@WebServlet("/newproduct")
public class NewsProductServlet extends BaseServlet {

	private static final String ORDERBY = "orderby";
	private static final String PAGE_NUM = "pageNum";
	private static final String PAGE = "page";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageStr = req.getParameter(PAGE);
		String pageNumStr = req.getParameter(PAGE_NUM);
		String orderbyStr = req.getParameter(ORDERBY);
		int page = DefaultUtils.checkNull(pageStr, 0);
		int pageNum = DefaultUtils.checkNull(pageNumStr, 10);
		String orderby = DefaultUtils.checkNull(orderbyStr, "sales desc");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		
		page = page * pageNum;
		List<Product> productList = productDao.getProductNewList(page, pageNum, orderby,System.currentTimeMillis());
		
		int productNewCount = productDao.getProductNewCount(System.currentTimeMillis());
		sqlSession.close();
		
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("response", "newProduct");
		data.put("listCount", productNewCount);
		data.put("productlist", productList);
		CommonUtil.renderJson(resp, data);
		
	}
}
