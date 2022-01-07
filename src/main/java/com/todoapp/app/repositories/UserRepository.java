package com.todoapp.app.repositories;

import java.util.Optional;

import com.todoapp.app.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findOneByUsername(String username);
}
