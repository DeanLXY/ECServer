package zz.itcast.ecserver.po;

/**
 * 帮助详情的po类
 * @author wangx
 *
 */
public class HelpDetail {
	// "title":"怎么购买？", //title
	// "content":" content " //帮助内容
	private String title;
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "HelpDetail [title=" + title + ", content=" + content + "]";
	}

}
