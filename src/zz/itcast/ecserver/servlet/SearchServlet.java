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

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import zz.itcast.ecserver.dao.ISearchDao;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 搜索 servlet
 * @author wangx
 *
 */
@WebServlet("/search")
public class SearchServlet extends BaseServlet {

	private static final String ORDERBY = "orderby";
	private static final String KEYWORD = "keyword";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keywordStr = req.getParameter(KEYWORD);
		String orderbyStr = req.getParameter(ORDERBY);
		
		keywordStr = DefaultUtils.checkNull(keywordStr, "");
		keywordStr = "%"+keywordStr+"%";
		orderbyStr = DefaultUtils.checkNull(orderbyStr, "sales desc");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ISearchDao searchDao = sqlSession.getMapper(ISearchDao.class);
		List<Product> productList = searchDao.getSearchResultByKey(keywordStr, orderbyStr);
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response", "search");
		data.put("listCount", productList.size());
		data.put("productList", productList);
		
//		CommonUtil.renderJson(resp, data);
		CommonUtil.renderJsonWithFilter(resp, data, new SimplePropertyPreFilter(Product.class,"id","name","pic","price","marketprice","commentcount","sales"));
		
	}
}
