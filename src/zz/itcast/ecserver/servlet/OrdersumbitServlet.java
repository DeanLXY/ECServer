package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.IOrderDao;
import zz.itcast.ecserver.dao.IProductDao;
import zz.itcast.ecserver.po.OrderInfo;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 结算订单servlet
 * 
 * @author wangx
 *
 */
@WebServlet("/ordersumbit")
public class OrdersumbitServlet extends BaseServlet {
	private static final String INVOICE_CONTENT = "invoiceContent";
	private static final String INVOICE_TITLE = "invoiceTitle";
	private static final String INVOICE_TYPE = "invoiceType";
	private static final String DELIVERY_TYPE = "deliveryType";
	private static final String PAYMENT_TYPE = "paymentType";
	private static final String ADDRESS_ID = "addressId";
	private static final String USER_ID = "userId";
	private static final String SKU = "sku";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String skuStr = req.getParameter(SKU);
		String userIdStr = req.getParameter(USER_ID);
		String addressIdStr = req.getParameter(ADDRESS_ID);
		String paymentTypeStr = req.getParameter(PAYMENT_TYPE);
		String deliveryTypeStr = req.getParameter(DELIVERY_TYPE);
		String invoiceTypeStr = req.getParameter(INVOICE_TYPE);
		String invoiceTitleStr = req.getParameter(INVOICE_TITLE);
		String invoiceContentStr = req.getParameter(INVOICE_CONTENT);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "I need Know who you are, userId=?");
		if (b) {
			return;
		}
		b = DefaultUtils.checkNull(resp, skuStr, "sku值没有,你要购买什么商品");
		if (b) {
			return;
		}

		int user_id = DefaultUtils.checkNull(userIdStr, 1);
		int addressId = DefaultUtils.checkNull(addressIdStr, 1);
		int paymentType = DefaultUtils.checkNull(paymentTypeStr, 1);
		int deliveryType = DefaultUtils.checkNull(deliveryTypeStr, 2);
		int invoiceType = DefaultUtils.checkNull(invoiceTypeStr,1);
		String invoiceTitle = DefaultUtils.checkNull(invoiceTitleStr,"个人");
		String invoiceContent = DefaultUtils.checkNull(invoiceContentStr,"图书");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		IOrderDao orderDao = sqlSession.getMapper(IOrderDao.class);
		// sku 3:3:1,3|5:2:2
		String[] skus = skuStr.split("\\|");
		if (skus.length == 0) {
			DefaultUtils.defalutError(resp, "不存在的商品");
			return;
		}
		int totalCount = 0;
		float totalPrice = 0f;
		for (int i = 0; i < skus.length; i++) {
			String[] sku = skus[i].split(":");
			if (sku.length < 2) {
				DefaultUtils.defalutError(resp, "sku传递错误");
				return;
			}
			// 根据商品id 查看商品是否存在
			String product_id = sku[0];
			String product_num = sku[1];
			Product product = productDao.getProductById(product_id);
			if (product == null) {
				DefaultUtils.defalutError(resp, "不存在的商品,商品id = " + product_id);
				return;
			}
			int productNum = DefaultUtils.checkNull(product_num, 0);
			totalCount += productNum;
			totalPrice += productNum*product.getPrice();
		}

		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setAddressId(addressId);
		orderInfo.setPayment_type(paymentType);
		orderInfo.setDelivery_type(deliveryType);
		orderInfo.setInvoice_type(invoiceType);
		orderInfo.setInvoiceTitle(invoiceTitle);
		orderInfo.setInvoiceContent(invoiceContent);
		orderInfo.setPrice(totalPrice);
		orderInfo.setTime(System.currentTimeMillis()+"");
		orderDao.submitOrderInfoWhichUser(user_id, skuStr, orderInfo);
		sqlSession.commit();
		String paymentTypeStrByPaymentType = orderDao.getPaymentTypeStrByPaymentType(paymentType);
		
		
		sqlSession.close();
		
		
		Map<String, Object> data = new HashMap<String,Object>();
		
		Map<String, Object> orderInfoMap = new HashMap<String,Object>();
		orderInfoMap.put("price", totalPrice);
		orderInfoMap.put("paymentType", paymentTypeStrByPaymentType);
		
		data.put("response", "ordersumbit");
		data.put("orderInfo", orderInfoMap);
		
		CommonUtil.renderJson(resp, data);
	}
}
