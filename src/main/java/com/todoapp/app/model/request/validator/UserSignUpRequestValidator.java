package com.todoapp.app.model.request.validator;

import com.todoapp.app.model.request.UserSignUpRequest;
import com.todoapp.app.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

        notBlankValues(errors, form);
        validatePasswords(errors, form);
        validateUsername(errors, form);
    }

    private void notBlankValues(Errors errors, UserSignUpRequest form) {
        if (form.getName().isBlank())
            errors.rejectValue("name", "blankName", "Please insert a name");

        if (form.getPassword().isBlank())
            errors.rejectValue("password", "blankPassword", "Please insert a password");

        if (form.getUsername().isBlank())
            errors.rejectValue("username", "blankUsername", "Please insert a username");
    }

    private void validatePasswords(Errors errors, UserSignUpRequest form) {
        if (!form.getPassword().equals(form.getPasswordRepeated()))
            errors.rejectValue("password", "noMatchPasswords", "Passwords do not match");
    }

    private void validateUsername(Errors errors, UserSignUpRequest form) {
        try {
            if (userService.loadUserByUsername(form.getUsername()) != null) {
                errors.rejectValue("username", "userExists",
                        "There is already a user registered with this username");
            }
        } catch (UsernameNotFoundException e) {
            LOGGER.debug(e.getMessage());
        }

    }
}
