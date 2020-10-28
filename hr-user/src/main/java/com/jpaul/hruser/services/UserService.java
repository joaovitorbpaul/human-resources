package com.jpaul.hruser.services;

import java.util.List;

import com.jpaul.hruser.entities.User;

public interface UserService {
	User findByEmail(String email);

	User findById(Long id);

	List<User> findAll();
}
