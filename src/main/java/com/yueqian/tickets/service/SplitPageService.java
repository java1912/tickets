package com.yueqian.tickets.service;

import com.yueqian.tickets.domain.PageVO;

public interface SplitPageService<T> {
	/**
	 * 获取总条数
	 */
	public void setRowCount(String condition, String orderCol, String orderSeq, PageVO<T> pageVO);
	
	/**
	 * 查询分页内容
	 */
	public void setPageContentList(PageVO<T> pageVO, String condition, String orderCol, String orderSeq);

}
