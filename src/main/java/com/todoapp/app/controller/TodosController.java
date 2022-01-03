package com.todoapp.app.controller;

import com.todoapp.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodosController {

    private final UserService userService;

    @Autowired
    public TodosController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list/{userId}")
    public ModelAndView getUsersPage(@PathVariable Long userId) {
        return new ModelAndView("users", "users", userService.getAllTodos(userId));
    }

}