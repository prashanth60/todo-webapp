package com.todoapp.app.io.repositories;

import java.util.Optional;

import com.todoapp.app.io.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findOneByUsername(String username);
}
