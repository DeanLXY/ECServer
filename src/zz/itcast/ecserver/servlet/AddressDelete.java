package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IAddressDao;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 删除地址管理
 * 
 * @author wangx
 *
 */
@WebServlet("/addressdelete")
public class AddressDelete extends BaseServlet {

	private static final String ID = "id";
	private static final String USER_ID = "userId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter(USER_ID);
		String idStr = req.getParameter(ID);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "I Need known who you are, userId=?");
		if (b)
			return;
		b = DefaultUtils.checkNull(resp, idStr, "I Need known what address woule you delete, id=?");
		if (b)
			return;

		int address_id = DefaultUtils.checkNull(idStr, 0);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IAddressDao addressDao = sqlSession.getMapper(IAddressDao.class);
		addressDao.deleteAddressInfoByUserIdAndAddressId(address_id);
		sqlSession.commit();
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response", "addressdelete");
		CommonUtil.renderJson(resp, data);
		
	}
}
