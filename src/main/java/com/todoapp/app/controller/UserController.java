package com.todoapp.app.controller;

import com.todoapp.app.entity.User;
import com.todoapp.app.request.TodoRequest;
import com.todoapp.app.request.UserRequest;
import com.todoapp.app.service.internal.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    
    @GetMapping(path="/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
 
    @PostMapping()
    public User createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @PostMapping(path="/{userId}/todos")
    public void createTodo(@PathVariable Long userId, @RequestBody TodoRequest todoRequest){
        userService.createTodo(userId, todoRequest);
    }
}
