package zz.itcast.ecserver.po;

/**
 * 首页轮转大图
 * 
 * @author wangx
 *
 */
public class HomeTopic {
	private int id;
	private String title;
	private String pic;
	private String link;

	@Override
	public String toString() {
		return "HomeTopic [id=" + id + ", title=" + title + ", pic=" + pic + ", link=" + link + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
