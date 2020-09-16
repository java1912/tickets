package com.yueqian.tickets.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.mapper.EmployeeMapper;
import com.yueqian.tickets.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper empMapper;

	@Override
	public List<EmployeeVO> getEmps() {
		return empMapper.getEmps();
	}

	@Override
	public int regEmp(EmployeeVO emp) {
		return empMapper.regEmp(emp);
	}

}
