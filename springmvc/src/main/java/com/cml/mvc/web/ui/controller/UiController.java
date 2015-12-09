package com.cml.mvc.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UiController {

	@RequestMapping("/index")
	public String index() {
		return "admin.ui.index";
	}

}
