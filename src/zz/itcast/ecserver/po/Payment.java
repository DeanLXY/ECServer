package zz.itcast.ecserver.po;

/**
 * 支付方式
 * 
 * @author wangx
 *
 */
public class Payment {

	private int type;
	private String des;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "Payment [type=" + type + ", des=" + des + "]";
	}

}
