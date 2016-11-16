package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.CartItem;
import zz.itcast.ecserver.po.Product;

/**
 * 购物车dao接口
 * @author wangx
 *
 */
public interface IShoppingCartDao {

	/**
	 * 添加商品 到购物车
	 * @param user_id 用户id
	 * @param product_id 商品id
	 */
	void addNewProduct2Cart(int user_id,String product_id);
	
	
	/**
	 * 根据 用户id获取  都在购物车添加了哪些商品
	 * @param user_id
	 * @return
	 */
	List<CartItem> getProductCountFromCartByUserId(int user_id);
	
	/**
	 * 根据用户id 获取 购物车 数据  其他信息    获取商品后自己拼接
	 * @param user_id
	 * @return
	 */
	Product getProductFromCartByProductId(String product_id);
	
	
	/**
	 * 根据商品id 删除购物车商品
	 * @param product_id
	 */
	void deleteProductFromShoppingcartByProductId(String product_id);
}
