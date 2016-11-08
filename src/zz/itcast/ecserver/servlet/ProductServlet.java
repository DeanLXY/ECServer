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
 * 商品列表servlet
 * 
 * @author wangx
 *
 */
@WebServlet("/productlist")
public class ProductServlet extends BaseServlet {

	private static final String ORDERBY = "orderby";
	private static final String PAGE_NUM = "pageNum";
	private static final String PAGE = "page";
	private static final String CID = "cid";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cidStr = req.getParameter(CID);
		String pageStr = req.getParameter(PAGE);
		String pageNumStr = req.getParameter(PAGE_NUM);
		String orderbyStr = req.getParameter(ORDERBY);
		boolean b = DefaultUtils.checkNull(resp, cidStr, "分类 cid不能为空");
		if (b)
			return;
		int cid = DefaultUtils.checkNull(cidStr, 0);
		int page = DefaultUtils.checkNull(pageStr, 0);
		int pageNum = DefaultUtils.checkNull(pageNumStr, 10);
		String orderby = DefaultUtils.checkNull(orderbyStr, "sales");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		List<Product> productList = productDao.getProductList(cid, page, pageNum, orderby);
		sqlSession.close();
		
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("response", "category_productlist");
		data.put("listCount", productList.size());
		data.put("productlist", productList);
		CommonUtil.renderJson(resp, data);
		
	}
}
