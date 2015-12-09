package com.cml.mvc.web.user.service;

import java.util.List;

import com.cml.mvc.beans.User;

public interface UserService {
	public Integer addUser(User user);

	public List<User> getUsers();
}
