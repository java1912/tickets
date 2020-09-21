package com.yueqian.tickets.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.domain.PageVO;
import com.yueqian.tickets.service.EmployeeService;

@Controller
public class IndexController {
	@Resource
	private EmployeeService empService;
	
	@RequestMapping({"/","","index"})
	public String viewEmps(PageVO<EmployeeVO> pageVO, ModelMap mm) {
		mm.addAttribute("pageVO",pageVO);
		
		return "index";
	}
}
