package com.jpaul.hruser.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jpaul.hruser.controllers.dtos.UserDTO;
import com.jpaul.hruser.entities.User;
import com.jpaul.hruser.repositories.UserRepository;
import com.jpaul.hruser.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		Optional<User> userOpt = userRepository.findByEmail(email);
		userOpt.orElseThrow(() -> new IllegalArgumentException(String.format("User not found with email %s", email)));
		return userOpt.get();
	}

	@Override
	public User findById(Long id) {
		Optional<User> userOpt = userRepository.findById(id);
		userOpt.orElseThrow(() -> new IllegalArgumentException(String.format("User not found with id %s", id)));
		return userOpt.get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
