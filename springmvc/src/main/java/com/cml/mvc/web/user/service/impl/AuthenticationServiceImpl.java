package com.cml.mvc.web.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cml.mvc.framework.security.realm.AuthenticationService;
import com.cml.mvc.framework.security.realm.AuthenticationUser;

public class AuthenticationServiceImpl implements AuthenticationService {

	private static final Logger log = Logger.getLogger(AuthenticationServiceImpl.class);

	@Override
	public AuthenticationUser doLogin(String username, String password) {
		
		log.info("用户登录====》" + username + "," + password);

		if (StringUtils.equals(username, password)) {
			List<String> roles = new ArrayList<String>();
			roles.add("user");
			roles.add("admin");
			AuthenticationUser user = new AuthenticationUser();
			user.setRoles(roles);
			return user;
		}
		return null;
	}

	@Override
	public List<String> getRoles(String username) {
		System.out.println("获取juese:" + username);

		return Arrays.asList("1", "2");
	}

}
