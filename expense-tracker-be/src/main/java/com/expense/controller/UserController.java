package com.expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.model.User;
import com.expense.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	@CrossOrigin(origins = "http://localhost:3000")
	public List<User> getUsers() throws Exception {

		return userService.getUsers();

	}

	@PostMapping()
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User createdUser = userService.createUser(user);

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

	}
}
