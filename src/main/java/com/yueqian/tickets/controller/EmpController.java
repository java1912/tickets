package com.yueqian.tickets.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yueqian.tickets.common.Constant;
import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.service.EmployeeService;

@Controller
@RequestMapping("emp")
public class EmpController extends ParamCheckController {
	@Resource
	private EmployeeService empService;
	
	@RequestMapping("regEmpPage")
	public String getRegEmpPage() {
		
		return "regEmp";
	}
	
	@RequestMapping("reg")
	public String regEmp(EmployeeVO emp, String repwd, ModelMap mm) {
		//参数校验
		//校验密码
		String errMsg = checkPassword(emp.getPwd(), repwd);
		if( errMsg != null) {
			mm.addAttribute(Constant.ERROR_MSG_KEY, errMsg);
			return "regEmp";
		}
		//校验其他参数
		
		
		//注册员工
		empService.regEmp(emp);
		
		
		return "redirect:/";
	}

	/**
	 * 密码校验
	 * @param emp
	 * @param repwd
	 * @param mm
	 * @return
	 */
	private String checkPassword(String empPwd, String repwd) {
		//校验密码是否为空
		if(isEmptyStr(repwd, empPwd)) {
			return "密码或确认密码为空";
		}
		//校验密码是否一致
		if(!repwd.equals(empPwd)) {
			return "确认密码失败";
		}
		//校验密码是否符合长度
		if(!isAllowStrLength(repwd, 6, 12)) {
			return "请输入6~12位的密码";
		}
		return null;
	}

}
