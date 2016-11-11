package zz.itcast.ecserver.po;

/**
 * 商品信息 {@link 收藏} {@link 商品列表}
 * 
 * @author wangx
 *
 */
public class Product {
	private int id;
	private String name;
	private float price;
	private float marketprice;
	private String pic;
	private int commentcount;
	private boolean isgift;
	
	private int sales;
	private int cid;
	//热门商品过期时间
	private long outoftime;
	// 商品网页链接
	private String href;
	//商品归属品牌id
	private int brandId;
	// 商品id
	private String productId;
	// 图片上提示信息
	private String alt;

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public long getOutoftime() {
		return outoftime;
	}

	public void setOutoftime(long outoftime) {
		this.outoftime = outoftime;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
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
