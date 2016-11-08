package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IUserCenterDao;
import zz.itcast.ecserver.po.UserCenterInfo;
import zz.itcast.ecserver.utils.CommonUtil;

/**
 * 用户中心的 servlet
 * 
 * @author wangx
 *
 */
@WebServlet("/userinfo")
public class UserCenterServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String useridStr = req.getParameter("userId");
		int userId = 0;
		if (!StringUtils.isEmpty(useridStr)) {
			userId = Integer.parseInt(useridStr);
		}

		SqlSession sqlSession = sqlSessionFactory.openSession();
		IUserCenterDao centerDao = sqlSession.getMapper(IUserCenterDao.class);
		UserCenterInfo userCenterInfo = centerDao.getUserCenterInfo(userId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "userInfo");
		data.put("userInfo", userCenterInfo);
		CommonUtil.renderJson(resp, data);

	}
}
