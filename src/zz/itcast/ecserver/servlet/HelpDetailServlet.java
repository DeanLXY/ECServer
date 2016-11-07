package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IHelpDetailDao;
import zz.itcast.ecserver.po.HelpDetail;
import zz.itcast.ecserver.utils.CommonUtil;

/**
 * 帮助详情的servlet
 */
@WebServlet("/help_detail")
public class HelpDetailServlet extends BaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取从客户端发送的请求参数
		String idStr = request.getParameter("id");
		int id = 0;
		if (idStr != null) {
			id = Integer.parseInt(idStr);
		}
		
		//   dao 查询数据库
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IHelpDetailDao detailDao = sqlSession.getMapper(IHelpDetailDao.class);
		List<HelpDetail> detailList = detailDao.getHelpDetailList(id);
		/*{
			"response": "help_detail ",  
			"help ":[
					{
					 "title":"怎么购买？",          //title
					 "content":" content "		 //帮助内容
					},
					{
					 "title":"怎么配送？",  //title
					 "content":" content "	   //帮助内容	 
					},
				]//内容
			}*/
		
		Map<String , Object> data = new HashMap<String,Object>();
		data.put("help", detailList);
		data.put("response", "help_detail");
		CommonUtil.renderJson(response, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
