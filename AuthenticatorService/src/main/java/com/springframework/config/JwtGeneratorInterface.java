package com.springframework.config;

import java.util.Map;

import com.springframework.model.User;

public interface JwtGeneratorInterface {

    Map<String, String> generateToken(User user);
}
