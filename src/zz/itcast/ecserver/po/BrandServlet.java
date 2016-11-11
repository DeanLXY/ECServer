package zz.itcast.ecserver.po;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IBrandDao;
import zz.itcast.ecserver.servlet.BaseServlet;
import zz.itcast.ecserver.utils.CommonUtil;

/**
 * 推荐品牌servlet
 * @author wangx
 *
 */
@WebServlet("/brand")
public class BrandServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IBrandDao brandDao = sqlSession.getMapper(IBrandDao.class);
		List<String> brandKeys = brandDao.getBrandKeys();
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response","brand");
		for (String key : brandKeys) {
			List<Brand> brandList = brandDao.getBrandListByKey(key);
			data.put("key",key);
			data.put("value",brandList);
		}
		sqlSession.close();
		CommonUtil.renderJson(resp, data);
		
	}
}
