package com.todoapp.app.model.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserSignUpRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordRepeated;

}
