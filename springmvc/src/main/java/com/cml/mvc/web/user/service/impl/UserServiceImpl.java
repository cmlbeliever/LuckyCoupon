package com.cml.mvc.web.user.service.impl;

import java.util.List;

import com.cml.mvc.beans.User;
import com.cml.mvc.web.user.dao.UserMapper;
import com.cml.mvc.web.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userDao;

	@Override
	public Integer addUser(User user) {
		return userDao.insertUser(user);
	}

	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

}
