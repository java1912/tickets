package com.yueqian.tickets.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yueqian.tickets.service.EmployeeService;

@Controller
public class IndexController {
	@Resource
	private EmployeeService empService;
	
	@RequestMapping({"/","","index"})
	public String viewEmps(ModelMap mm) {
		mm.addAttribute("emps", empService.getEmps());
		return "index";
	}
}
