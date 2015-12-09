package com.cml.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.mvc.framework.util.ErrorsUtil;
import com.cml.mvc.model.User;
import com.cml.mvc.validator.UserValidator;

public class ValidTestController {

	Log log = LogFactory.getLog(ValidTestController.class);

	@InitBinder
	public void init(WebDataBinder binder) {
		log.debug("=======init==============");
		binder.addValidators(new UserValidator());
	}

	@ResponseBody
	@RequestMapping("/user")
	public String testUser(@Valid @ModelAttribute("user") User user,
			BindingResult result) {

		if (result.hasErrors()) {
			return ErrorsUtil.getAllErrors(result);
		}

		log.debug("用户信息校验：" + user);
		log.debug("用户信息校验：" + result.hasErrors());
		log.debug("用户信息校验：" + result.getAllErrors());
		return "user";
	}
}
