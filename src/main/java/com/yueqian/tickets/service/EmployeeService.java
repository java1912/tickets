package com.yueqian.tickets.service;

import java.util.List;

import com.yueqian.tickets.domain.EmployeeVO;

public interface EmployeeService {

	/**
	 * 查询员工
	 */
	public List<EmployeeVO> getEmps();
	/**
	 * 登录验证
	 */
	/**
	 * 添加员工
	 */
	public int regEmp(EmployeeVO emp);
	/**
	 * 删除员工
	 */
}
