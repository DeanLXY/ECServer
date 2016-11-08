package zz.itcast.ecserver.dao;

import java.util.List;

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
	
	/**
	 * 获取商品列表
	 * @param cid 分类id
	 * @param page
	 * @param pageNum
	 * @param order sales销量升序,price 价格升序
	 * @return
	 */
	List<Product> getProductList(int cid,int page,int pageNum,String order);
}
