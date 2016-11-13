package zz.itcast.ecserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String addressDetailStr = req.getParameter(ADDRESS_DETAIL);
		String zipCodeStr = req.getParameter(ZIP_CODE);
		
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "I Need know who you are,  userId=?");
		if (b) {
			return;
		}
		
	}
}
