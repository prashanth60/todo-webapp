package com.todoapp.app.controller;

import javax.validation.Valid;

import com.todoapp.app.model.request.UserSignUpRequest;
import com.todoapp.app.model.request.validator.UserSignUpRequestValidator;
import com.todoapp.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
        modelAndView.addObject("userSignUpRequest", new UserSignUpRequest());
        modelAndView.setViewName(REGISTRATION_VIEW);
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid UserSignUpRequest user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("userSignUpRequest", user);
        modelAndView.setViewName(REGISTRATION_VIEW);

        UserSignUpRequestValidator uv = new UserSignUpRequestValidator(userService);
        uv.validate(user, bindingResult);

        // checks empty value errors
        if (bindingResult.hasErrors())
            return modelAndView;

        userService.createUser(user);
        modelAndView.addObject("successMessage", "User has been registered successfully");

        return modelAndView;
    }

}
