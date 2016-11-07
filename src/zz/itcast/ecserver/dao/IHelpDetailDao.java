package zz.itcast.ecserver.dao;

import java.util.List;

import zz.itcast.ecserver.po.HelpDetail;

public interface IHelpDetailDao {

	/**
	 * 获取帮助详情
	 * @param id
	 * @return
	 */
	List<HelpDetail> getHelpDetailList(int id);
}
