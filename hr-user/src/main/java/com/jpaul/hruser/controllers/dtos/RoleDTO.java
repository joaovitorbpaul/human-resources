package com.jpaul.hruser.controllers.dtos;

import java.io.Serializable;

import com.jpaul.hruser.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String roleName;
	
	public RoleDTO(Role role) {
		setId(role.getId());
		setRoleName(role.getRoleName());
	}
	
}
