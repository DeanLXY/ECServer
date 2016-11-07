package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.UserInfo;

/**
 * 注册的dao接口
 * @author wangx
 *
 */
public interface IUserRegisterDao {

	/**
	 * 注册新的用户
	 * @param username
	 * @param password
	 * @return  返回插入用户的id
	 */
	int registerNewUser(String username,String password);

	/**
	 * 根据用户名 获取用户id
	 * @param username
	 * @return
	 */
	int getUserIdByUserName(String username);
	
	/**
	 * 查询是否有相同的用户名
	 * @param username
	 * @return
	 */
	List<UserInfo> getUsersByUserName(String username);
}
