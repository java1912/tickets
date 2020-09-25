package com.yueqian.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yueqian.tickets.service.EmployeeService;

@Controller
public class IndexController {
	@Resource
	private EmployeeService empService;

	@RequestMapping({ "/", "", "/index" })
	public String viewEmps(ModelMap mm) {
		// 获取用户的权限
		// 获取上下文
		SecurityContext context = SecurityContextHolder.getContext();
		// 获取登录用户的信息
		Authentication auth = context.getAuthentication();
		// 获取登录用户权限
		List<GrantedAuthority> grantList = (List<GrantedAuthority>) auth.getAuthorities();
		List<String> grantStrs = new ArrayList<String>();
		for (GrantedAuthority ga : grantList) {
			grantStrs.add(ga.getAuthority());
		}
		mm.addAttribute("authoritys", grantStrs);

		return "index";
	}

	@RequestMapping("/loginPage")
	public String loginPage() {

		return "elogin";
	}

	@RequestMapping("/accessDeniedPage")
	public String accessDeniedPage() {
		return "accessDeniedPage";
	}
}
