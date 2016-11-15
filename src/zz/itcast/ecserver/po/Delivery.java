package zz.itcast.ecserver.po;

/**
 * 送货时间
 * 
 * @author wangx
 *
 */
public class Delivery {

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
		return "Delivery [type=" + type + ", des=" + des + "]";
	}

}
