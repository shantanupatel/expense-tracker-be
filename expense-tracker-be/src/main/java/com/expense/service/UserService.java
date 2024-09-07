package com.expense.service;

import java.util.List;

import com.expense.model.User;

public interface UserService {

	public List<User> getUsers();

	public User createUser(User user);

}
