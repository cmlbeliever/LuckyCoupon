package com.cml.mvc.web.user.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cml.mvc.beans.User;
import com.cml.mvc.constant.I18nMessageKey;
import com.cml.mvc.web.user.bean.UserLoginBean;
import com.cml.mvc.web.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView login(
			@Valid @ModelAttribute("user") UserLoginBean login,
			BindingResult result, ModelAndView model) {

		model.setViewName("forward:/login.jsp");

		// 参数都正确
		if (!result.hasErrors()) {
			try {
				Subject subject = SecurityUtils.getSubject();

				// 已经登录，无需再次登录
				if (!subject.isAuthenticated()) {
					subject.login(new UsernamePasswordToken(
							login.getUsername(), login.getPassword(), login
									.isRemember()));
				}

				model.setViewName("redirect:/admin/index.mvc");
			} catch (AuthenticationException e) {
				result.reject(I18nMessageKey.Login.FAIL);
			}
		}

		log.info("登录结果：" + model.getViewName());

		return model;
	}

	@RequestMapping("tiles")
	public String tileTest() {
		return "jsp/admin/login";
	}

	@ResponseBody
	@RequestMapping("addUser")
	public User addUser() {

		System.out.println("ccccc");

		User user = new User();
		user.setName("测试：" + System.currentTimeMillis());

		userService.addUser(user);
		System.out.println("ddddd");

		return user;

	}

	@ResponseBody
	@RequestMapping("queryUser")
	public List<User> queryUser() {
		System.out.println(userService.getUsers());
		return userService.getUsers();

	}
}
