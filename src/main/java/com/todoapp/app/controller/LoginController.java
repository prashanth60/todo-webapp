package com.todoapp.app.controller;

import javax.validation.Valid;

import com.todoapp.app.request.UserSignUpRequest;
import com.todoapp.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import io.entity.User;

@Controller
public class LoginController {

    private static final String REGISTRATION_VIEW = "registration";

    @Autowired
    private UserService userService;

    @GetMapping(value = { "/", "/login" })
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        UserSignUpRequest user = new UserSignUpRequest();
        modelAndView.addObject("user", user);
        modelAndView.setViewName(REGISTRATION_VIEW);
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid UserSignUpRequest user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            User userExists = (User) userService.loadUserByUsername(user.getUsername());
            if (userExists != null) {
                bindingResult
                        .rejectValue("username", "error.user",
                                "There is already a user registered with the user name provided");
            }
        } catch (UsernameNotFoundException e) {
            userService.createUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
        } finally {
            modelAndView.setViewName(REGISTRATION_VIEW);
        }
        return modelAndView;
    }

}
