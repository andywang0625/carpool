package com.web.carpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.carpool.model.User;
import com.web.carpool.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public User findUserById(int id) {
		return userRepository.findById(id);
	}
}
