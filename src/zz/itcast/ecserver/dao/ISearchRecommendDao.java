package zz.itcast.ecserver.dao;

import java.util.List;

/**
 * 热门搜索
 * @author wangx
 *
 */
public interface ISearchRecommendDao {

	/**
	 * 获取热门关键字
	 * @return
	 */
	List<String> getSearchRecommendList();
	
}
