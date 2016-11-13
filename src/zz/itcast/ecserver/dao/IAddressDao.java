package zz.itcast.ecserver.dao;

import org.apache.ibatis.annotations.Param;

import zz.itcast.ecserver.po.AddressInfo;

/**
 * 对个人地址进行管理
 * 
 * @author wangx
 *
 */
public interface IAddressDao {

	/**
	 * 将所有的
	 * @param user_id地址设置为 非默认  (目的是  新增 地址 默认是默认地址)
	 */
	void setAllAddressNotDefault(int user_id);
	/**
	 * 新增地址信息
	 * 
	 * @param user_id
	 * @param addressInfo
	 */
	void addNewAddressInfo(@Param("userid") int user_id, @Param("address") AddressInfo addressInfo);
}
