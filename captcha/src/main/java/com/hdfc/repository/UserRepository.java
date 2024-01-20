package com.hdfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}