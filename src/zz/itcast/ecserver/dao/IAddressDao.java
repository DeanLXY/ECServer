package zz.itcast.ecserver.dao;

import java.util.List;

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
	
	
	/**
	 * 根据用户id获取 地址列表
	 * @param user_id
	 * @return
	 */
	List<AddressInfo> getAddressInfoListByUserId(int user_id);
	
	/**
	 * 根据 地址id删除 (state = 0)  0表示无效 1表示有效
	 * @param address_id
	 */
	void deleteAddressInfoByUserIdAndAddressId(int address_id);
}
