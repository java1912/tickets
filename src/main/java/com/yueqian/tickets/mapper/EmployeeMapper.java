package com.yueqian.tickets.mapper;

import java.util.List;

import com.yueqian.tickets.domain.EmployeeVO;

public interface EmployeeMapper {
	
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
