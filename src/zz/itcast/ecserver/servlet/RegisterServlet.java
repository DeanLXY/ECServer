package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IUserRegisterDao;
import zz.itcast.ecserver.po.UserInfo;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 注册的接口
 * 
 * @author wangx
 *
 */
@WebServlet("/register")
public class RegisterServlet extends BaseServlet {
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 获取 用户名 密码信息
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			DefaultUtils.defalutError(response, "传递的username或者password为空");
			return;
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IUserRegisterDao registerDao = sqlSession.getMapper(IUserRegisterDao.class);
		// 帐号相同 不允许创建
		List<UserInfo> userList = registerDao.getUsersByUserName(username);
		if (userList.size() >0) {
			DefaultUtils.defalutError(response, "该用户已注册");
			return;
			
		}
		
		int effectCount = registerDao.registerNewUser(username, password);
		sqlSession.commit();
		if (effectCount == -1) {
			DefaultUtils.defalutError(response, "注册新用户失败");
			return;
		}
		int userId = registerDao.getUserIdByUserName(username);
		
		sqlSession.close();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response","register");
		Map<String ,Integer> userIdMap = new HashMap<String,Integer>();
		userIdMap.put("userId", userId);
		data.put("userInfo",userIdMap);
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
