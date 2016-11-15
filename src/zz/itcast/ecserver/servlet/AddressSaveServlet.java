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
import zz.itcast.ecserver.po.AddressInfo;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 地址新增
 * @author wangx
 *
 */
@WebServlet("/addresssave")
public class AddressSaveServlet extends BaseServlet {

	private static final String USER_ID = "userId";
	private static final String ZIP_CODE = "zipCode";
	private static final String ADDRESS_DETAIL = "addressDetail";
	private static final String AREA = "area";
	private static final String CITY = "city";
	private static final String PROVINCE = "province";
	private static final String PHONE_NUMBER = "phoneNumber";
	private static final String NAME = "name";
	private static final String ID = "id";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter(USER_ID);
		String idStr = req.getParameter(ID);
		String nameStr = req.getParameter(NAME);
		String phoneNumberStr = req.getParameter(PHONE_NUMBER);
		String provinceStr = req.getParameter(PROVINCE);
		String cityStr = req.getParameter(CITY);
		String areaStr = req.getParameter(AREA);
		String fixedtelStr = req.getParameter("fixedtel");
		String addressDetailStr = req.getParameter(ADDRESS_DETAIL);
		String zipCodeStr = req.getParameter(ZIP_CODE);
		
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "I Need know who you are,  userId=?");
		if (b) {
			return;
		}
		
		int id = DefaultUtils.checkNull(idStr, -1);
		if (id != -1) {
			System.out.println("当前用户 修改地址");
			return;
		}
		
		
		int user_id = DefaultUtils.checkNull(userIdStr, 0);
		String name = DefaultUtils.checkNull(nameStr, "<unknown>");
		String phoneNumber = DefaultUtils.checkNull(phoneNumberStr, "<unknown>");
		String province= DefaultUtils.checkNull(provinceStr, "<unknown>");
		String city = DefaultUtils.checkNull(cityStr, "<unknown>");
		String area = DefaultUtils.checkNull(areaStr, "<unknown>");
		String fixedtel = DefaultUtils.checkNull(fixedtelStr, "<unknown>");
		String addressDetail = DefaultUtils.checkNull(addressDetailStr, "<unknown>");
		String zipCode = DefaultUtils.checkNull(zipCodeStr, "<unknown>");
		//新增地址  均为  默认地址   将其他默认地址 设置 非默认
		
		
		AddressInfo addressInfo = new AddressInfo(id, name, phoneNumber, fixedtel, province, city, area, addressDetail, zipCode, true);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IAddressDao addressDao = sqlSession.getMapper(IAddressDao.class);
		addressDao.setAllAddressNotDefault(user_id);
		addressDao.addNewAddressInfo(user_id, addressInfo);
		sqlSession.commit();
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "addresssave");
		CommonUtil.renderJson(resp, data);
		
		
	}
}
