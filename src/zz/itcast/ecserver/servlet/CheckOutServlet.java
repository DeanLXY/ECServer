package zz.itcast.ecserver.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import zz.itcast.ecserver.dao.ICheckOutDao;
import zz.itcast.ecserver.dao.IProductDao;
import zz.itcast.ecserver.po.Delivery;
import zz.itcast.ecserver.po.Payment;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 结算中心 servlet
 * 
 * @author wangx
 *
 */
@WebServlet("/checkout")
public class CheckOutServlet extends BaseServlet {
	private static final String USER_ID = "userId";
	private static final String SKU = "sku";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String skuStr = req.getParameter(SKU);
		String userIdStr = req.getParameter(USER_ID);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "I need Know who you are, userId=?");
		if (b) {
			return;
		}
		b = DefaultUtils.checkNull(resp, skuStr, "sku值没有,你要购买什么商品");
		if (b) {
			return;
		}

		SqlSession sqlSession = sqlSessionFactory.openSession();
		IProductDao productDao = sqlSession.getMapper(IProductDao.class);
		// sku 3:3:1,3|5:2:2
		String[] skus = skuStr.split("\\|");
		if (skus.length == 0) {
			DefaultUtils.defalutError(resp, "不存在的商品");
			return;

		}
		// 添加商品信息
		ICheckOutDao checkOutDao = sqlSession.getMapper(ICheckOutDao.class);
		List<Product> productList = new ArrayList<Product>();
		Map<String, Object> checkoutAddupData = new HashMap<String, Object>();
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

			productList.add(product);
			// int user_id = DefaultUtils.checkNull(userIdStr, 1);
			int productNum = DefaultUtils.checkNull(product_num, 0);
			totalCount += productNum;
			totalPrice += productNum*product.getPrice();

		}
		checkoutAddupData.put("totalCount", totalCount);
		checkoutAddupData.put("totalPrice", totalPrice);
		checkoutAddupData.put("totalPoint", totalPrice);
		checkoutAddupData.put("freight", 0);
		List<Payment> paymentList = checkOutDao.getPaymentList();
		List<Delivery> deliveryList = checkOutDao.getDeliveryList();

		sqlSession.close();

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "checkout");
		data.put("paymentList", paymentList);
		data.put("deliveryList", deliveryList);
		data.put("productList", productList);
		data.put("checkoutAddup", checkoutAddupData);
		CommonUtil.renderJson(resp, data);
	}
}
