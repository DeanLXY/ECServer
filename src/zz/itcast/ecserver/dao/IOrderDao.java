package zz.itcast.ecserver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zz.itcast.ecserver.po.OrderInfo;

/**
 * 订单列表dao接口
 * 
 * @author wangx
 *
 */
public interface IOrderDao {
	/**
	 * 根据用户id获取订单列表信息
	 * 
	 * @param user_id
	 * @param type
	 * @return
	 */
	List<OrderInfo> getOrderListByUserId(int user_id, int type);

	/**
	 * 提交结算信息
	 * 
	 * @param user_id
	 * @param product_list
	 * @param orderInfo
	 */
	void submitOrderInfoWhichUser(@Param("user_id") int user_id, @Param("product_list") String product_list,
			@Param("orderInfo") OrderInfo orderInfo);

	
	/**
	 * 根据支付类型 获取 支付类型
	 * @param paymentType
	 * @return
	 */
	String getPaymentTypeStrByPaymentType(int paymentType);
}
