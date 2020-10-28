package com.jpaul.hruser.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpaul.hruser.controllers.dtos.UserDTO;
import com.jpaul.hruser.entities.User;
import com.jpaul.hruser.services.UserService;
import com.sun.istack.NotNull;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@RestController
@RequestMapping(UserController.BASE_URL)
@RequiredArgsConstructor
public class UserController {

	public static final String BASE_URL = "/users";
	private static final String USER_BY_EMAIL_PATH = "/search";
	public static final String USER_BY_ID_PATH = "/{id}";
	
	@NotNull
	private final Environment env;

	@NotNull
	private final UserService userService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserDTO> findAll() {
		log.debug("PORT = " + env.getProperty("local.server.port"));
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = users.stream().map((user) -> new UserDTO(user, user.getRoles())).collect(Collectors.toList());
		return usersDTO;
	}

	@GetMapping(USER_BY_ID_PATH)
	@ResponseStatus(HttpStatus.OK)
	public UserDTO findById(@PathVariable Long id) {
		log.debug("PORT = " + env.getProperty("local.server.port"));
		User user = userService.findById(id);
		return new UserDTO(user, user.getRoles());
	}
	
	@GetMapping(USER_BY_EMAIL_PATH)
	@ResponseStatus(HttpStatus.OK)
	public UserDTO findByEmail(@RequestParam String email) {
		log.debug("PORT = " + env.getProperty("local.server.port"));
		User user = userService.findByEmail(email);
		return new UserDTO(user, user.getRoles());
	}
}
