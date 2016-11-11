package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * 商品详情servlet
 * @author wangx
 *
 */
@WebServlet("/product")
public class ProductDetailServlet extends BaseServlet {

	private static final String P_ID = "pId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pIdStr = req.getParameter(P_ID);
		boolean b = DefaultUtils.checkNull(resp, pIdStr, "商品 pId不能为空");
		if (b) {
			return;
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		Product product = productDao.getProductById(pIdStr);
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String, Object>();
		List<Object> dataObj = new ArrayList<Object>();
		dataObj.add(product);
		data.put("response", "product");
		data.put("product", dataObj);
		CommonUtil.renderJson(resp, data);
		
	}
}
