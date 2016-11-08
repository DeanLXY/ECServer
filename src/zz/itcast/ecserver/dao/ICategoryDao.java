package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.Category;

/**
 * 分类功能的dao接口
 * @author wangx
 *
 */
public interface ICategoryDao {

	/**
	 * 获取分类列表
	 * @param parentId 上级分类
	 * @return
	 */
	List<Category> getCategoryList(int parentId,int version);
}
