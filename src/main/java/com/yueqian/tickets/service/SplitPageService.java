package com.yueqian.tickets.service;

public interface SplitPageService<T> {
	/**
	 * 获取总条数
	 */
	public int getRowCount();
	
	/**
	 * 查询分页内容
	 */
	public void setPageContentList();

}
