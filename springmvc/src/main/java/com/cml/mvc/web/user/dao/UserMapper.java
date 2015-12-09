package com.cml.mvc.web.user.dao;

import java.util.List;

import com.cml.mvc.beans.User;

public interface UserMapper {
	public Integer insertUser(User user);
	public List<User> getUsers();
}
