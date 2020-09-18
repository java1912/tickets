package com.yueqian.tickets.domain;

import java.util.List;

public class PageVO<E> {
	//当前页页码
	private int nowPageNum = 1;
	//当前页码分页内容
	private List<Integer> pageNumList;
	//每页数量
	private int pageSize = 5;
	//页数
	private int pageCount;
	//当前页内容
	private List<E> contentList;
	
	/**
	 * 初始化第一页内容
	 * @param pageIndex
	 * @param pageSize
	 */
	public PageVO() {
		
	}
	
	public void jumpPage(int pageIndex, int pageSize) {
		
	}

}
