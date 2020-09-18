package com.yueqian.tickets.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.mapper.EmployeeMapper;
import com.yueqian.tickets.service.SplitPageService;

@Service("empSplitPageService")
public class EmpSplitPageServiceImpl implements SplitPageService<EmployeeVO> {
	@Resource
	private EmployeeMapper empMapper;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPageContentList() {
		// TODO Auto-generated method stub
		
	}

}
