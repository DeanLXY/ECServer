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

import zz.itcast.ecserver.dao.IAddressAreaDao;
import zz.itcast.ecserver.po.AddressArea;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 三级列表servlet
 * @author wangx
 *
 */
@WebServlet("/addressarea")
public class AddressAreaServlet extends BaseServlet {

	private static final String ID = "id";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter(ID);
		int parentId = DefaultUtils.checkNull(idStr, 0);
		// 根据parent_id 获取 地址
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IAddressAreaDao addressAreaDao = sqlSession.getMapper(IAddressAreaDao.class);
		List<AddressArea> listByParentId = addressAreaDao.getAddressAreaListByParentId(parentId);
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response","addressArea");
		data.put("areaList",listByParentId);
		CommonUtil.renderJson(resp, data);
	}
}
