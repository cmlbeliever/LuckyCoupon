package com.cml.mvc.framework.security.realm;

import java.util.List;

public interface AuthenticationService {
	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public AuthenticationUser doLogin(String username, String password);
	
	public List<String> getRoles(String username);
}
