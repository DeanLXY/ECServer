package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.Product;

/**
 * 根据关键字搜索的 dao 接口
 * 
 * @author wangx
 *
 */
public interface ISearchDao {

	/**
	 * 根据关键字搜索 商品列表
	 * @param keyword
	 * @return
	 */
	List<Product> getSearchResultByKey(String keyword,String orderby);
}
