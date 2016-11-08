package zz.itcast.ecserver.po;

/**
 * 商品信息 {@link 收藏}
 * 
 * @author wangx
 *
 */
public class Product {
	private int id;
	private String name;
	private String pic;
	private float price;
	private float marketprice;
	private int commentcount;
	private boolean isgift;

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(float marketprice) {
		this.marketprice = marketprice;
	}

	public int getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}

	public boolean isIsgift() {
		return isgift;
	}

	public void setIsgift(boolean isgift) {
		this.isgift = isgift;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", pic=" + pic + ", price=" + price + ", marketprice="
				+ marketprice + ", commentcount=" + commentcount + ", isgift=" + isgift + "]";
	}

}
