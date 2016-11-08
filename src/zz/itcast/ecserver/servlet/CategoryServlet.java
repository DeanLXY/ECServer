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

import zz.itcast.ecserver.dao.ICategoryDao;
import zz.itcast.ecserver.po.Category;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 分类
 * 
 * @author wangx
 *
 */
@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
	private static final String VERSION = "version";
	private static final String PARENT_ID = "parentId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parentIdStr = req.getParameter(PARENT_ID);
		String versionStr = req.getParameter(VERSION);
		
		int parentId = DefaultUtils.checkNull(parentIdStr, 0);
		int version = DefaultUtils.checkNull(versionStr, 0);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ICategoryDao categoryDao = sqlSession.getMapper(ICategoryDao.class);
		List<Category> categoryList = categoryDao.getCategoryList(parentId, version);
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response", "category");
		data.put("version", version);
		data.put("category", categoryList);
		
		CommonUtil.renderJson(resp, data);
	}

}
