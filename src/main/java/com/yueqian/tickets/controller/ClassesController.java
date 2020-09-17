package com.yueqian.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("classes")
public class ClassesController extends ParamCheckController{
	@RequestMapping("delClasses")
	public String delClass() {
		return "delClass";
	}
}
