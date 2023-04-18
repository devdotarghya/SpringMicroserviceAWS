package org.arghya.springmicroserviceaws.service;

import java.util.List;
import java.util.UUID;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.arghya.springmicroserviceaws.domain.User;
import org.arghya.springmicroserviceaws.dto.UserRequest;
import org.arghya.springmicroserviceaws.dto.UserResponse;
import org.arghya.springmicroserviceaws.exception.UserNotFoundException;
import org.arghya.springmicroserviceaws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService {

	private UserRepository userRepository;
	
	public UserService(@Qualifier("userRepository")UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void createUser(UserRequest userRequest) {
		User user = new User(UUID.randomUUID().toString(), userRequest.getName());
		userRepository.save(user);
	}
	
	public List<UserResponse> getUsers() {
		return userRepository.findAll().stream()
				.map(user -> new UserResponse(user.getUid(), user.getName()))
				.collect(Collectors.toList());
	}
	
	public UserResponse getUser(String name) throws UserNotFoundException {
		
		return userRepository.findByName(name).map(user -> new UserResponse(user.getUid(), user.getName()))
				.orElseThrow(()-> new UserNotFoundException("user not found"));
	}
}
