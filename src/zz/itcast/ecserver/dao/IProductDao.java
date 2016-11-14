package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.Product;
import zz.itcast.ecserver.po.ProductPic;

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
	Product getProductById(String productId);
	
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
	 * 根据品牌id获取商品列表
	 * @param brandId
	 * @param orderBy 
	 * @param pageNum 
	 * @param page 
	 * @return
	 */
	List<Product> getProductListById(int brandId, int page, int pageNum, String orderBy);	
	
	/**
	 * 查询当前品牌中 有多少商品
	 * @param brandId
	 * @return
	 */
	int getProductListCountById(int brandId);
	
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
	/**
	 * 增加商品图片
	 */
	void insertNewProductDetailImgs(String product_id,String alt,String url);
	/**
	 * 增加商品大图
	 * @param product_id
	 * @param alt
	 * @param url
	 */
	void insertNewProductDetailBigImgs(String product_id,String alt,String url);

	/**
	 * 根据商品id获取商品图片
	 * @param product_id
	 * @return
	 */
	List<ProductPic> getProductImgsById(String product_id);
	
	/**
	 * 根据商品id获取商品大图
	 * @param product_id
	 * @return
	 */
	List<ProductPic> getProductBigImgsById(String product_id);
	/**
	 * 根据商品id获取商品描述信息
	 * @param product_id
	 * @return
	 */
	String getProductContentById(String product_id);
	
	
}
