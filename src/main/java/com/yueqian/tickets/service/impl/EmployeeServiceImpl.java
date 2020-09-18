package com.yueqian.tickets.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.mapper.EmployeeMapper;
import com.yueqian.tickets.service.EmployeeService;
import com.yueqian.tickets.util.StringUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper empMapper;

	@Override
	public List<EmployeeVO> getEmps(String condition, String orderCol, String orderSeq) {
		List<EmployeeVO> resultList = new ArrayList<EmployeeVO>();
		if(StringUtils.isEmptyStr(orderSeq, orderCol)) {
			return resultList;
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		if(!StringUtils.isEmptyStr(condition)) {
			param.put("condition", condition);
		}
		param.put("orderCol", orderCol);
		param.put("orderSeq", orderSeq);
		
		return empMapper.getEmps(param);
	}

	@Override
	public int regEmp(EmployeeVO emp) {
		return empMapper.regEmp(emp);
	}
	
	/**
	 * 验证账户名
	 */
	public String isExistsAccName(String accName) {
		
		return empMapper.isExistsAccName(accName) == null ? "no" : "yes";
	}

}
