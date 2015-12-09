package com.cml.mvc.web.user.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserLoginBean {
	@NotNull
	@Length(min = 6, max = 16)
	private String username;
	@NotNull
	@Length(min = 6, max = 16)
	private String password;
	private boolean remember;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

}
