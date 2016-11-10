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

import zz.itcast.ecserver.dao.ISearchRecommendDao;
import zz.itcast.ecserver.utils.CommonUtil;

/**
 * 热门搜索
 * @author wangx
 *
 */
@WebServlet("/search/recommend")
public class SearchRecommendServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ISearchRecommendDao recommendDao = sqlSession.getMapper(ISearchRecommendDao.class);
		List<String> recommendList = recommendDao.getSearchRecommendList();
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "searchrecommend");
		data.put("searchKeywords", recommendList);
		
		CommonUtil.renderJson(resp, data);
	}
}
