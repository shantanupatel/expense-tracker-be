package com.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.model.User;
import com.expense.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {

		return userRepository.findAll();
	}

	public User createUser(User user) {

		return this.userRepository.save(user);
	}
}
