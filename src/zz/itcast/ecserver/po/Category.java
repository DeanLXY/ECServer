package zz.itcast.ecserver.po;

/**
 * 分类信息
 * 
 * @author wangx
 *
 */
public class Category {

	private int id;
	private String name;
	private int parentId;
	private String pic;
	private String tag;
	private boolean isLeafNode;

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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isLeafNode() {
		return isLeafNode;
	}

	public void setLeafNode(boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentId=" + parentId + ", pic=" + pic + ", tag=" + tag
				+ ", isLeafNode=" + isLeafNode + "]";
	}

}
