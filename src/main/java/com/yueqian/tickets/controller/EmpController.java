package com.yueqian.tickets.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yueqian.tickets.common.Constant;
import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.domain.PageVO;
import com.yueqian.tickets.service.EmployeeService;
import com.yueqian.tickets.service.SplitPageService;

@Controller
@RequestMapping("emp")
public class EmpController extends ParamCheckController {
	@Resource
	private EmployeeService empService;
	@Resource(name = "empSplitPageService")
	private SplitPageService<EmployeeVO> empSplitPageService;
	
	@RequestMapping("regEmpPage")
	public String getRegEmpPage() {
		
		return "empOper/regEmp";
	}
	
	@RequestMapping("reg")
	public String regEmp(EmployeeVO emp, String repwd, ModelMap mm) {
		//参数校验
		//校验密码
		String errMsg = checkPassword(emp.getPwd(), repwd);
		if( errMsg != null) {
			mm.addAttribute(Constant.ERROR_MSG_KEY, errMsg);
			return "empOper/regEmp";
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
	
	/**
	 * 账户名唯一性验证
	 */
	@RequestMapping("isExistsAccName")
	@ResponseBody
	public String isExistsAccName(String accName) {
		return empService.isExistsAccName(accName);
	}
	
	/**
	 * 显示员工列表
	 */
	@ResponseBody
	@RequestMapping("getEmps")
	public PageVO<EmployeeVO> getEmps(String condition, String orderCol, String orderSeq, PageVO<EmployeeVO> pageVO, ModelMap mm) {
		mm.addAttribute("pageVO",pageVO);
		empSplitPageService.setRowCount(condition, orderCol, orderSeq, pageVO);
		empSplitPageService.setPageContentList(pageVO, condition, orderCol, orderSeq);
		
///		List<EmployeeVO> list = empService.getEmps(condition, orderCol, orderSeq);
		
		return pageVO;
	}
	

}
