package com.jpaul.hroauth.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpaul.hroauth.dtos.UserDTO;
import com.jpaul.hroauth.integrations.UserClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService{
	
	private final UserClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userClient.findUserByEmail(username);
		if(user == null) {
			log.error("Email not found: {}", username);
			new UsernameNotFoundException(String.format("User not found with email %s", username));
		}
		log.info("Email found: {}", username);
		return user;
	}

}
