package com.cml.mvc.web.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
	@RequestMapping("/index")
	public String index() {
		return "admin.form.index";
	}
}
