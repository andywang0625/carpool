package com.web.carpool.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.carpool.model.User;
import com.web.carpool.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public User findUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		User checkUser = findUserByUsername(user.getUsername());
		if (checkUser != null) {
			return null;
		}

        User lastUser = userRepository.findTopByOrderByIdDesc();
		return userRepository.save(user.setPassword(getPasswordHash("", user.getPassword()))
				.setId((lastUser != null) ? (userRepository.findTopByOrderByIdDesc().getId() + 1) : 1));
	}

	/**
	 * This helper function is used to hash password with SHA-256
	 * @param salt	improves the strength of hash, usually the username will be one of the options.
	 * @param plainText plain password that needs to be encrypted.
	 * @return String hashed password
	 **/
	private String getPasswordHash(String salt, String plainText) {
		return Hashing.sha256().hashString(salt + plainText, StandardCharsets.UTF_8).toString();
	}
}
