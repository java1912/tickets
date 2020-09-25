package com.yueqian.tickets.mapper;

import java.util.List;
import java.util.Map;

import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.domain.RoleVO;

public interface RoleMapper {
	
	/**
	 * 根据用户名账号，查找角色
	 */
	public List<RoleVO> getRoleByAccName(String accName);


}
