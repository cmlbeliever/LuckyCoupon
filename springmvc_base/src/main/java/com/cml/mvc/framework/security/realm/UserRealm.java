package com.cml.mvc.framework.security.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.cml.mvc.framework.constant.Constant;

public class UserRealm extends AuthorizingRealm {

	private static final Logger log = Logger.getLogger(UserRealm.class);
	private AuthenticationService authcService;

	/**
	 * 认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection collection) {

		// 用户名也可以从这里获取
		log.debug("UserRealm==>doGetAuthorizationInfo:"
				+ collection.getPrimaryPrincipal().toString());

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		String username = (String) SecurityUtils.getSubject().getSession(true)
				.getAttribute(Constant.Session.USERNAME);

		info.addRoles(authcService.getRoles(username));

		return info;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken userToken = (UsernamePasswordToken) token;

		String username = userToken.getUsername();
		String password = new String(userToken.getPassword());

		log.debug("UserRealm==>doGetAuthenticationInfo:" + username + ","
				+ password);

		AuthenticationUser user = authcService.doLogin(userToken.getUsername(),
				password);

		if (null == user) {
			throw new AuthenticationException("user login fail!");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
				password, getName());

		SecurityUtils.getSubject().getSession(true)
				.setAttribute(Constant.Session.USERNAME, username);

		return info;
	}

	public AuthenticationService getAuthcService() {
		return authcService;
	}

	public void setAuthcService(AuthenticationService authcService) {
		this.authcService = authcService;
	}

}
