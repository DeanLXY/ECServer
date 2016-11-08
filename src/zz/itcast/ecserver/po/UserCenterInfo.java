package zz.itcast.ecserver.po;

/**
 * 账户中心 po类
 * 
 * @author wangx
 *
 */
public class UserCenterInfo extends UserInfo {
	private int orderCount;
	private int favoritesCount;

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	@Override
	public String toString() {
		return "UserCenterInfo [orderCount=" + orderCount + ", favoritesCount=" + favoritesCount + "]";
	}

}
