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

import zz.itcast.ecserver.dao.IShoppingCartDao;
import zz.itcast.ecserver.po.CartItem;
import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.utils.CommonUtil;
import zz.itcast.ecserver.utils.DefaultUtils;

/**
 * 购物车的servlet
 * 
 * @author wangx
 *
 */
@WebServlet("/cart")
public class ShoppingCartServlet extends BaseServlet {

	private static final String USER_ID = "userId";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter(USER_ID);
		boolean b = DefaultUtils.checkNull(resp, userIdStr, "userId 不能为空");
		if (b) {
			return;
		}

		int userId = DefaultUtils.checkNull(userIdStr, 1);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IShoppingCartDao shoppingCartDao = sqlSession.getMapper(IShoppingCartDao.class);
		List<CartItem> cartItems = shoppingCartDao.getProductCountFromCartByUserId(userId);
		System.out.println(cartItems);
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> cartData = new HashMap<String, Object>();
		List<Map<String, Object>> productList = new ArrayList<Map<String, Object>>();
		cartData.put("cartItemList", productList);

		Product product = null;
		data.put("response", "cart");
		data.put("cart", cartData);
		// "totalCount":"3", //商品数量总计
		// "totalPrice":"230", //商品金额总计
		// "totalPoint":"230" //商品积分总计

		int totalCount = 0;
		float totalPrice = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			totalCount +=cartItem.getCount();
			product = shoppingCartDao.getProductFromCartByProductId(cartItem.getProductId());
			if (product == null) {
				DefaultUtils.defalutError(resp, "商品不存在,检查后重试");
				return;
			}
			totalPrice += product.getPrice()* cartItem.getCount();
			Map<String, Object> productData = new HashMap<String, Object>();
			productList.add(productData);
			productData.put("product", product);
			productData.put("prodNum", cartItem.getCount());
		}
		
		data.put("totalCount", totalCount);
		data.put("totalPrice", totalPrice);
		data.put("totalPoint", 0);
		sqlSession.close();

		CommonUtil.renderJson(resp, data);

	}
}
