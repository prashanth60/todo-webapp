package com.todoapp.app.service;

import com.todoapp.app.entity.User;
import com.todoapp.app.request.TodoRequest;
import com.todoapp.app.request.UserRequest;

public interface UserService {
    public User getUserById(Long userId);
    public User createUser(UserRequest userRequest);
    public void createTodo(Long userId, TodoRequest todoRequest);
    

}
