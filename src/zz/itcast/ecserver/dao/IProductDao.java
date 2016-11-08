package zz.itcast.ecserver.dao;

import zz.itcast.ecserver.po.Product;

/**
 * 商品的 dao
 * @author wangx
 *
 */
public interface IProductDao {
	/**
	 * 根据商品id  获取商品信息
	 * @param productId
	 * @return
	 */
	Product getProductById(int productId);
}
