package com.web.carpool.service;

import java.util.List;

import com.web.carpool.model.User;

public interface UserService {
	public User findUserById(int id);
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public User findUserByConfirmationToken(String confirmationToken);
	public List<User> findAll();
	public User createUser(User user);
}
