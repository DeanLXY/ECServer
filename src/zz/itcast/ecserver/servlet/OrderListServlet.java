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

import zz.itcast.ecserver.dao.IOrderDao;
import zz.itcast.ecserver.dao.IProductDao;
import zz.itcast.ecserver.po.OrderInfo;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 获取订单列表
 * 
 * @author wangx
 *
 */
@WebServlet("/orderlist")
public class OrderListServlet extends BaseServlet {
//	1/2/3 
//	1=>本月订单 
//	2=>上个月订单
//	3=>已取消订单
	
	
	private static final String USER_ID = "userId";
	private static final String PAGE_NUM = "pageNum";
	private static final String PAGE = "page";
	private static final String TYPE = "type";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String typeStr = req.getParameter(TYPE);
		String pageStr = req.getParameter(PAGE);
		String pageNumStr = req.getParameter(PAGE_NUM);
		String userIdStr = req.getParameter(USER_ID);
		
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "I Need Known who you are, userId=?");
		if (b) {
			return;
		}
		b = DefaultUtils.checkNull(resp, typeStr, "I Need Known which type is, type=?");
		if (b) {
			return;
		}
		int user_id = DefaultUtils.checkNull(userIdStr, 0);
		int type = DefaultUtils.checkNull(typeStr, 1);
		int page = DefaultUtils.checkNull(pageStr, 0);
		int pageNum = DefaultUtils.checkNull(pageNumStr, 10);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IOrderDao orderDao = sqlSession.getMapper(IOrderDao.class);
		List<OrderInfo> orderList = orderDao.getOrderListByUserId(user_id,type);
		sqlSession.close();
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("response", "orderlist");
		data.put("orderList", orderList);
		CommonUtil.renderJson(resp, data);
	}
}
