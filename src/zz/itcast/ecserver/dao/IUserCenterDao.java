package zz.itcast.ecserver.dao;

import zz.itcast.ecserver.po.UserCenterInfo;

/**
 * 账户中心的dao接口
 * @author wangx
 *
 */
public interface IUserCenterDao {

	/**
	 * 根据用户 id 获取 用户 中心信息
	 * @param userid
	 * @return
	 */
	UserCenterInfo getUserCenterInfo(int userid);
}
