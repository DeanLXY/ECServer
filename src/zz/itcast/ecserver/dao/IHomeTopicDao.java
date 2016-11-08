package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.HomeTopic;

/**
 * 首页轮转大图的 dao接口
 * @author wangx
 *
 */
public interface IHomeTopicDao {

	
	/**
	 * 获取topic列表
	 * @return
	 */
	List<HomeTopic> getHomeTopicList();
}
