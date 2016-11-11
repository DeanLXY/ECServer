package zz.itcast.ecserver.po;

/**
 * 商品图片
 * 
 * @author wangx
 *
 */
public class ProductPic {
	private String productId;
	private String alt;
	private String url;
	private float width;
	private float height;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "ProductPic [productId=" + productId + ", alt=" + alt + ", url=" + url + ", width=" + width + ", height="
				+ height + "]";
	}

}
