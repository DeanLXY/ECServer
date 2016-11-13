package zz.itcast.ecserver.po;

/**
 * 三级列表 po
 * 
 * @author wangx
 *
 */
public class AddressArea {
	// "id":"1", //地区ID
	// "parentId": 0, //父id
	// "value":"北京"
	private int id;
	private int parentId;
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AddressArea [id=" + id + ", parentId=" + parentId + ", value=" + value + "]";
	}

}
