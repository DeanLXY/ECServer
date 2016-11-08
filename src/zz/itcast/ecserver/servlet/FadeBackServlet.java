package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IFadeBackDao;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 反馈信息
 * 
 * @author wangx
 *
 */
@WebServlet("/fadeback")
public class FadeBackServlet extends BaseServlet {

	private static final String USERID = "userId";
	private static final String CONTENT = "content";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String useridStr = req.getParameter(USERID);
		String contentStr = req.getParameter(CONTENT);
		boolean b = DefaultUtils.checkNull(resp, useridStr, "需要传递的userId不能为空");
		if (b) {
			return;
		}

		b = DefaultUtils.checkNull(resp, contentStr, "提交的意见不能为空");
		if (b) {
			return;
		}
		int userId = DefaultUtils.checkNull(useridStr, 0);
		String content = DefaultUtils.checkNull(contentStr, "五星好评");

		SqlSession sqlSession = sqlSessionFactory.openSession();
		IFadeBackDao fadeBackDao = sqlSession.getMapper(IFadeBackDao.class);
		fadeBackDao.addNewFadeBack(userId, content);
		sqlSession.commit();
		sqlSession.close();
		Map<String, String> data = new HashMap<String, String>();
		data.put("response", "fadeback");
		CommonUtil.renderJson(resp, data);
	}
}
