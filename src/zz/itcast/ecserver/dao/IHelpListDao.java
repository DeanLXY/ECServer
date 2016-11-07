package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.Help;

/**
 * 帮助列表的 dao 接口
 * 
 * @author wangx
 *
 */
public interface IHelpListDao {
	/**
	 * 获取帮助列表信息
	 * 
	 * @param version
	 * @return
	 */
	List<Help> getHelpList(int version);
	
	
	/**
	 * 获取最大的version
	 * @return
	 */
	int getLastVersion();
}
