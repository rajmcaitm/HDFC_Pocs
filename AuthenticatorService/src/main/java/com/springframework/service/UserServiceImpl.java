package com.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.exception.UserNotFoundException;
import com.springframework.model.User;
import com.springframework.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByCustIdAndPassword(int custId, String password) throws UserNotFoundException {
        User user = userRepository.findByCustIdAndPassword(custId, password);
        if(user == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        return user;
    }
}
