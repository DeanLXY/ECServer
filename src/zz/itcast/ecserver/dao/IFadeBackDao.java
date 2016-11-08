package zz.itcast.ecserver.dao;

/**
 * 反馈的dao
 * @author wangx
 *
 */
public interface IFadeBackDao {

	/**
	 * 添加新的反馈信息
	 * @param userid
	 * @param content
	 */
	void addNewFadeBack(int userid,String content);
}
