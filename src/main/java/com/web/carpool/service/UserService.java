package com.web.carpool.service;

import com.web.carpool.model.User;

public interface UserService {
	public User findUserById(int id);
	public User findUserByName(String name);
	public User findUserByEmail();
}
