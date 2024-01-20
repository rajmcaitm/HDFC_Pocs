package com.springframework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springframework.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByCustIdAndPassword(int custId, String password);
}
