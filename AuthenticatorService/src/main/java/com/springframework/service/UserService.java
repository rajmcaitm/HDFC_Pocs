package com.springframework.service;

import org.springframework.stereotype.Service;

import com.springframework.exception.UserNotFoundException;
import com.springframework.model.User;

@Service
public interface UserService {
    public void saveUser(User user);
    public User findByCustIdAndPassword(int custId, String password) throws UserNotFoundException;
}
