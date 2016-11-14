package zz.itcast.ecserver.po;

/**
 * 订单信息
 * @author wangx
 *
 */
public class OrderInfo {
	private int id;
	private String orderId;
	private int addressId;
	private String deliveryType;
	private String paymentType;
	private String invoiceType;
	private String invoiceTitle;
	private String invoiceContent;
	// 订单显示状态
	private int status;
	private String time;
	private float price;
	// 订单标识，1=>可删除可修改 2=>不可修改 3=>已完成
	private int flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", orderId=" + orderId + ", addressId=" + addressId + ", deliveryType="
				+ deliveryType + ", paymentType=" + paymentType + ", invoiceType=" + invoiceType + ", invoiceTitle="
				+ invoiceTitle + ", invoiceContent=" + invoiceContent + ", status=" + status + ", time=" + time
				+ ", price=" + price + ", flag=" + flag + "]";
	}

}
