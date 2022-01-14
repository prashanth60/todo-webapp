package com.todoapp.app.model.request.validator;

import com.todoapp.app.model.request.UserSignUpRequest;
import com.todoapp.app.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserSignUpRequestValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSignUpRequestValidator.class);
    private final UserService userService;

    @Autowired
    public UserSignUpRequestValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserSignUpRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        UserSignUpRequest form = (UserSignUpRequest) target;
        validatePasswords(errors, form);
        validateUsername(errors, form);
    }

    private void validatePasswords(Errors errors, UserSignUpRequest form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateUsername(Errors errors, UserSignUpRequest form) {
        if (userService.loadUserByUsername(form.getUsername()) != null) {
            errors.reject("username.exists", "User with this username already exists");
        }
    }
}
