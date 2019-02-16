package com.web.carpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.carpool.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	User findById(int id);
}
