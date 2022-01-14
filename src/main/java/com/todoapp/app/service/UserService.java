package com.todoapp.app.service;

import java.util.List;

import com.todoapp.app.request.TodoRequest;
import com.todoapp.app.request.UserSignUpRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

import io.entity.Todo;
import io.entity.User;

public interface UserService extends UserDetailsService {
    public User getUserById(Long userId);

    public User createUser(UserSignUpRequest userRequest);

    public void updateTodo(Long todoId, TodoRequest todoRequest, boolean completed);

    public void createTodo(String username, TodoRequest todoRequest);

    public List<Todo> getAllTodos(Long userId);

    public void saveUser(User user);

    public void deleteTodo(Long id);

}
