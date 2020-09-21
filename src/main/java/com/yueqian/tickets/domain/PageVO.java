package com.yueqian.tickets.domain;

import java.util.ArrayList;
import java.util.List;

public class PageVO<E> {
	//当前页页码
	private int nowPageNum = 1;
	//每页数量
	private int pageSize = 5;
	//页数
	private int pageCount;
	//当前页内容
	private List<E> contentList = new ArrayList<E>();
	
	/**
	 * 初始化第一页内容
	 * @param pageIndex
	 * @param pageSize
	 */
	public PageVO(int nowPageNum, int pageSize) {
		this.nowPageNum = nowPageNum;
		this.pageSize = pageSize;
	}
	
	/**
	 * 初始化第一页内容
	 * @param pageIndex
	 * @param pageSize
	 */
	public PageVO() {
		
	}
	
//	public void jumpPage(int pageIndex, int pageSize) {
//		
//	}

	public int getNowPageNum() {
		return nowPageNum;
	}

	public void setNowPageNum(int nowPageNum) {
		this.nowPageNum = nowPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<E> getContentList() {
		return contentList;
	}

	public void setContentList(List<E> contentList) {
		this.contentList = contentList;
	}
	
	

}
