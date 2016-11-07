package zz.itcast.ecserver.po;

/**
 * 帮助列表的po类
 * @author wangx
 *
 */
public class Help {
	// id title version state
	private int id;
	private String title;
	private int version;
	private int state;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Help [id=" + id + ", title=" + title + ", version=" + version + ", state=" + state + "]";
	}

}
