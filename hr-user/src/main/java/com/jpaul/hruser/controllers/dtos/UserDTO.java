package com.jpaul.hruser.controllers.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.jpaul.hruser.entities.Role;
import com.jpaul.hruser.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO(User user, Set<Role> roles) {
		setId(user.getId());
		setName(user.getName());
		setEmail(user.getEmail());
		setPassword(user.getPassword());
		setRoles(roles.stream().map(RoleDTO::new).collect(Collectors.toSet()));
	}
}
