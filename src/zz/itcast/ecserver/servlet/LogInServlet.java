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

import zz.itcast.ecserver.dao.IUserLoginDao;
import zz.itcast.ecserver.po.UserInfo;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

@WebServlet("/login")
public class LogInServlet extends BaseServlet {
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 获取 用户名  密码信息
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			DefaultUtils.defalutError(response, "传递的username或者password为空");
			return;
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IUserLoginDao loginDao = sqlSession.getMapper(IUserLoginDao.class);
		UserInfo userInfo = loginDao.login(username, password);
		if (userInfo == null) {
			DefaultUtils.defalutError(response, "帐号或者密码错误");
			return;
		}
		System.out.println(userInfo);
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response", "login");
		data.put("userInfo", userInfo);
		CommonUtil.renderJson(response, data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
