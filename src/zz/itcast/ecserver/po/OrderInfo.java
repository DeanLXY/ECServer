package zz.itcast.ecserver.po;

/**
 * 订单信息
 * 
 * @author wangx
 *
 */
public class OrderInfo {
	private int id;
	private String orderId;
	private int addressId;
	private int delivery_type;
	private String deliveryType;
	private int payment_type;
	private String paymentType;
	private int invoice_type;
	private String invoiceType;
	private String invoiceTitle;
	private String invoiceContent;
	// 订单显示状态
	private int status;
	private String time;
	private float price;
	// 订单标识，1=>可删除可修改 2=>不可修改 3=>已完成
	private int flag =1;

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

	public int getDelivery_type() {
		return delivery_type;
	}

	public void setDelivery_type(int delivery_type) {
		this.delivery_type = delivery_type;
	}

	public int getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}

	public int getInvoice_type() {
		return invoice_type;
	}

	public void setInvoice_type(int invoice_type) {
		this.invoice_type = invoice_type;
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
		return "OrderInfo [id=" + id + ", orderId=" + orderId + ", addressId=" + addressId + ", delivery_type="
				+ delivery_type + ", deliveryType=" + deliveryType + ", payment_type=" + payment_type + ", paymentType="
				+ paymentType + ", invoice_type=" + invoice_type + ", invoiceType=" + invoiceType + ", invoiceTitle="
				+ invoiceTitle + ", invoiceContent=" + invoiceContent + ", status=" + status + ", time=" + time
				+ ", price=" + price + ", flag=" + flag + "]";
	}
}
