package zz.itcast.ecserver.po;

/**
 * 购物车信息 有商品信息 商品数量
 * 
 * @author wangx
 *
 */
public class CartItem {
	private String productId;// 商品id
	private int count;// 商品数量

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartItem [productId=" + productId + ", count=" + count + "]";
	}

}
