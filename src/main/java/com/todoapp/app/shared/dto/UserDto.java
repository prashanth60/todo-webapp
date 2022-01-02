package com.todoapp.app.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.todoapp.app.entity.Todo;

import lombok.Data;

@Data
public class UserDto implements Serializable {

    private String username;

    private String password;

    private List<Todo> todoList = new ArrayList<>();

}
