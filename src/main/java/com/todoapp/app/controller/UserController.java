package com.todoapp.app.controller;

import com.todoapp.app.entity.User;
import com.todoapp.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// TODO: CREAR USER DTO


@RestController("/user")
@CrossOrigin(origins = { "http://localhost:3000"})
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    private User getCurrentUser(@RequestBody User user) {
        System.out.println("GET User by username and password *****");
        return userService.getUser(user);
    }

    //TODO: modificar esto
    @GetMapping("/login/{username}/{password}")
    private boolean findUserByUsername(@PathVariable String username, @PathVariable String password) {
        System.out.println("GET User by username and password *****");
        return userService.getUserByUsername(username, password);
    }

    @PostMapping("/createUser")
    private boolean addUser(@RequestBody User user) {
        boolean userExists = userService.findUserByUsername(user.getUsername());
        if(userExists) {
            System.out.println("CANT CREATE USER!");
            return false;
        }
        userService.saveUser(user);
        return true;
    }
}
