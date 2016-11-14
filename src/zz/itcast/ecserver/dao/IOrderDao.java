package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.OrderInfo;

/**
 * 订单列表dao接口
 * @author wangx
 *
 */
public interface IOrderDao {
	/**
	 * 根据用户id获取订单列表信息
	 * @param user_id
	 * @param type 
	 * @return
	 */
	List<OrderInfo> getOrderListByUserId(int user_id, int type);
}
