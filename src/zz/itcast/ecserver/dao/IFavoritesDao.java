package zz.itcast.ecserver.dao;

import java.util.List;

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
}
