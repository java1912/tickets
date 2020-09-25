package com.yueqian.tickets.mapper;

import java.util.List;
import java.util.Map;

import com.yueqian.tickets.domain.EmployeeVO;

public interface EmployeeMapper {
	
	/**
	 * 查询员工，分页
	 */
	public List<EmployeeVO> getEmps(Map<String,Object> param);
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
	/**
	 * 验证账户名
	 */
	public String isExistsAccName(String accName);
	
	/**
	 * 查询总条数
	 */
	public int getRowCount(Map<String,Object> param);


	/**
	 * 根据账户名获取员工
	 */
	public EmployeeVO getEmployeeByAccName(String accName);
}
