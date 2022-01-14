package com.todoapp.app.model.request;

import lombok.Data;

@Data
public class UserSignUpRequest {
    private String name;
    private String username;
    private String password;
    private String passwordRepeated;

}
