package com.cml.mvc.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "mvc.base";
	}
}
