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

import zz.itcast.ecserver.dao.IHomeTopicDao;
import zz.itcast.ecserver.po.HomeTopic;
import zz.itcast.ecserver.utils.CommonUtil;

/**
 * 首页轮转大图
 * @author wangx
 *
 */
@WebServlet("/home")
public class HomeTopicServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IHomeTopicDao homeTopicDao = sqlSession.getMapper(IHomeTopicDao.class);
		List<HomeTopic> homeTopicList = homeTopicDao.getHomeTopicList();
		sqlSession.close();
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("response", "home");
		data.put("homeTopic", homeTopicList);
		
		CommonUtil.renderJson(resp, data);
	}
}
