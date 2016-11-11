package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.Brand;

/**
 * 推荐品牌dao接口
 * @author wangx
 *
 */
public interface IBrandDao {

	/**
	 * 获取推荐品牌列表
	 * @return
	 */
	List<Brand> getBrandList();
	
	/**
	 * 获取品牌关键字
	 * @return
	 */
	List<String> getBrandKeys();
	
	/**
	 * 根据品牌关键字 获取品牌列表
	 * @return
	 */
	List<Brand> getBrandListByKey(String brandKey);	

	
	/**
	 * 添加新商品 给 单元测试用
	 * @param brand
	 */
	void addNewBrand(Brand brand);
	
}
