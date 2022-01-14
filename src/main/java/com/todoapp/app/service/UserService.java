package com.todoapp.app.service;

import java.util.List;

import com.todoapp.app.io.entity.Todo;
import com.todoapp.app.io.entity.User;
import com.todoapp.app.model.request.TodoRequest;
import com.todoapp.app.model.request.UserSignUpRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User getUserById(Long userId);

    public User createUser(UserSignUpRequest userRequest);

    public void updateTodo(Long todoId, TodoRequest todoRequest, boolean completed);

    public void createTodo(String username, TodoRequest todoRequest);

    public List<Todo> getAllTodos(Long userId);

    public void saveUser(User user);

    public void deleteTodo(Long id);

}
