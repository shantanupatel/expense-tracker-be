package com.expense.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.model.User;
import com.expense.repository.UserRepository;
import com.expense.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return this.userRepository.save(user);
	}

}
