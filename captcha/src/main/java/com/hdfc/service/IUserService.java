package com.hdfc.service;

import java.util.List;
import java.util.Optional;

import com.hdfc.entities.User;


public interface IUserService {

	void createUser(User user);
	List<User> getAllUsers();
	Optional<User> getOneUser(Integer Id);
}