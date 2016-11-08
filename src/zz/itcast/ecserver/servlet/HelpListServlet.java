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

import zz.itcast.ecserver.dao.IHelpListDao;
import zz.itcast.ecserver.po.Help;
import zz.itcast.ecserver.utils.CommonUtil;

/**
 * 帮助中心的servlet
 * 
 * @author wangx
 *
 */
//  http://ip:port/ecserverz19/help.action  servlet 3 以上  tomcat 7以上本版
@WebServlet(value = {"/help","/help.action"})
public class HelpListServlet extends BaseServlet {

	/**
	 * 收到get请求后响应
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request 请求对象,可以获取从客户端传递过来的参数
		// response 响应对象 将数据返回到客户端

		// 1. 获取来自客户端的参数 数据
		String versionStr = request.getParameter("version");
		int version = 0;
		if (versionStr != null) {
			version = Integer.parseInt(versionStr);// 将string 转换为 int
		}
		// 2. 通过mybatis 查询数据
		
		// 4. 获取SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 5. 执行CRUD操作
		IHelpListDao helpListDao = sqlSession.getMapper(IHelpListDao.class);
		List<Help> helpList = helpListDao.getHelpList(version);
		// 获取最大version
		int lastVersion = helpListDao.getLastVersion();
		// 6. 输出
		System.out.println(helpList);
		// 7释放资源
		sqlSession.close();
		// 3. 将 查询到的数据 编码为 json格式
		/*
		 * {
		 * 
		 * helpList:[ { id: 1, title:"购物指南" }, { id: 2, title:"售后服务" }, { id: 3,
		 * title:"配送方式" }
		 * 
		 * ]
		 */

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("helpList", helpList);
		data.put("response", "help");
		// version 服务器 中 帮助列表中的最大的ersion值
		data.put("version", lastVersion);

		// 4. 将json数据返回到客户端
		// CommonUtil.renderJson(response, data);

		// 添加过滤  要什么  写什么
		CommonUtil.renderJsonWithFilter(response, data, new SimplePropertyPreFilter(Help.class,"id", "title"));

	}

	/**
	 * 收到post请求后响应
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		response.getWriter().append("Served at:  Post>>>>> ").append(request.getContextPath());

	}

}
