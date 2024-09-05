package com.expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.model.User;
import com.expense.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// @Tag(name = "get", description = "GET methods of User APIs")
	@Operation(summary = "Get list of all Users", description = "Get list of all Users. The response is a list of Users object with id, first name last name, email, activated, active, creation date, last updated date and last login date.")
	@GetMapping()
	public List<User> getUsers() throws Exception {

		return userService.getUsers();

	}

	// @Tag(name = "post", description = "POST methods of User APIs")
	@Operation(summary = "Create a new User", description = "Create a new User. The response is an User object with id, first name last name, email, activated, active, creation date, last updated date and last login date.")
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User createdUser = userService.createUser(user);

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

	}
}
