package com.jpaul.hroauth.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpaul.hroauth.dtos.UserDTO;

@Component
@FeignClient(name="hr-user", path="/users")
public interface UserClient {

	@GetMapping(value = "/search")
	UserDTO findUserByEmail(@RequestParam String email);
}
