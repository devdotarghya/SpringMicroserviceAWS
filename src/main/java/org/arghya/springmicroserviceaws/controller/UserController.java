package org.arghya.springmicroserviceaws.controller;

import java.util.List;

import org.arghya.springmicroserviceaws.dto.UserRequest;
import org.arghya.springmicroserviceaws.dto.UserResponse;
import org.arghya.springmicroserviceaws.exception.UserNotFoundException;
import org.arghya.springmicroserviceaws.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userApp")
public class UserController {

	private UserService userService;

	public UserController(@Qualifier("userService") UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/user")
	public HttpEntity createUser(@RequestBody UserRequest userRequest) {

		userService.createUser(userRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public HttpEntity<List<UserResponse>> getUsers() {

		List<UserResponse> users = userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/user/{name}")
	public HttpEntity<UserResponse> getUser(@PathVariable(name = "name")String name) throws UserNotFoundException {

		UserResponse user = userService.getUser(name);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
