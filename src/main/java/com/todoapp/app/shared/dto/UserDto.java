package com.todoapp.app.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.todoapp.app.io.entity.Role;
import com.todoapp.app.io.entity.Todo;
import com.todoapp.app.shared.utils.DateComparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 8058093790817969475L;

    private Long id;
    private String name;
    private String username;
    private String password;
    private List<Todo> todoList = new ArrayList<>();
    private Boolean enabled = Boolean.TRUE;
    private Set<Role> authorities = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public List<Todo> getSortedByDateTodoList() {
        this.todoList.sort(new DateComparator());
        return this.todoList;
    }

}
