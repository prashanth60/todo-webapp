package com.todoapp.app.service;

import com.todoapp.app.entity.User;
import com.todoapp.app.request.TodoRequest;
import com.todoapp.app.request.UserRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User getUserById(Long userId);

    // public User getUserByUsername(String username);

    public User createUser(UserRequest userRequest);

    public void createTodo(Long userId, TodoRequest todoRequest);

}
