package com.springframework.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.model.User;
import com.springframework.repository.UserRepository;

@Component
public class AppBootStrap implements CommandLineRunner {
    private UserRepository userRepository;

    @Autowired
    public AppBootStrap(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(1234, "pass123");
        User user2 = new User(5678,"pass123");
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
