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
	
	/**
	 * 获取新品上家列表
	 * @param cid
	 * @param page
	 * @param pageNum
	 * @param order
	 * @return
	 */
	List<Product> getProductNewList(int page,int pageNum,String order,long systemtime);
	
	
	/**
	 * 根据分类获取 商品数量
	 * @param cid
	 * @return
	 */
	int getProductCount(int cid);
	
	/**
	 * 获取上架新品数量
	 * @return
	 */
	int getProductNewCount(long systemtime);
	
	/**
	 * 加入新的商品 测试用
	 * @param product
	 */
	void insertNewProduct(Product product);
	
	/**
	 * 添加新上架商品
	 */
	void insertNewProductNews(Product product);
}
