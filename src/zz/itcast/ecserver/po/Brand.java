package zz.itcast.ecserver.po;

/**
 * 品牌
 * 
 * @author wangx
 *
 */
public class Brand {
	private int id;
	private String name;
	private String pic;
	private String href;
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", pic=" + pic + ", href=" + href + "]";
	}

}
