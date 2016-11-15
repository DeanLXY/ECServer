package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.Delivery;
import zz.itcast.ecserver.po.Payment;

/**
 * 添加
 * @author wangx
 *
 */
public interface ICheckOutDao {

	/**
	 * 获取支付方式列表
	 * @return
	 */
	List<Payment> getPaymentList();
	
	
	/**
	 * 获取送货时间列表
	 * @return
	 */
	List<Delivery> getDeliveryList();
}
