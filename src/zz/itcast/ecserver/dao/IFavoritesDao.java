package zz.itcast.ecserver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zz.itcast.ecserver.po.Product;

/***
 * 收藏的 dao接口
 * @author wangx
 *
 */
public interface IFavoritesDao {

	/**
	 * 获取用户收藏列表
	 * @param userid
	 * @param page
	 * @param pageNum
	 * @return
	 */
	List<Product> getFavoritesList(int userid,int page,int pageNum);
	
	
	/**
	 * 添加新的收藏
	 * @param product
	 * @return
	 */
	int addNewFavorites(@Param("userid")int userid ,@Param("product") Product product);
	
	
	/**
	 * 根据id查询是否已经收藏
	 * @param id
	 * @param productId 
	 * @return
	 */
	Product getFavoritesById(int userid, int productId);
}
