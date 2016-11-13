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

import zz.itcast.ecserver.dao.IAddressDao;
import zz.itcast.ecserver.po.AddressInfo;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 获取用户商品列表信息 根据用户id 获取
 * @author wangx
 *
 */
@WebServlet("/addresslist")
public class AddressListServlet extends BaseServlet {

	private static final String USER_ID = "userId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter(USER_ID);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "I need Know who you are, userId=?");
		if (b) {
			return;
		}
		
		int userId = DefaultUtils.checkNull(userIdStr, 0);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IAddressDao addressDao = sqlSession.getMapper(IAddressDao.class);
		List<AddressInfo> addressList = addressDao.getAddressInfoListByUserId(userId);
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response", "addresslist");
		data.put("addresslist", addressList);
		
		CommonUtil.renderJson(resp, data);
	}
}
