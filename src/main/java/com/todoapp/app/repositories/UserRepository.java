package com.todoapp.app.repositories;

import com.todoapp.app.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsernameAndPassword(String username, String password);
    User findTopByUsername(String username);
    User findTopByPassword(String password);
}
