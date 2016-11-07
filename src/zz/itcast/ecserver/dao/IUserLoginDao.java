package zz.itcast.ecserver.dao;

import zz.itcast.ecserver.po.UserInfo;

/**
 * 用户登录的 dao 类
 * @author wangx
 *
 */
public interface IUserLoginDao {

	/***
	 * 登录 返回 用户详细信息
	 * @param username
	 * @param password
	 * @return
	 */
	UserInfo login(String username,String password);
}
