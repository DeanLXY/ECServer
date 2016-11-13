package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.AddressArea;

/**
 * 地址列表的dao接口
 * @author wangx
 *
 */
public interface IAddressAreaDao {

	/**
	 * 根据parent id 获取 地址列表  parent_id=0 获取省级列表
	 * @param parent_id
	 * @return
	 */
	List<AddressArea> getAddressAreaListByParentId(int parent_id);
}
