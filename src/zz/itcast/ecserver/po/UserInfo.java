package zz.itcast.ecserver.po;

/**
 * 用户登录信息po类
 * @author wangx
 *
 */
public class UserInfo {
	private int userId;
	private int bonus ;
	private String level;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
