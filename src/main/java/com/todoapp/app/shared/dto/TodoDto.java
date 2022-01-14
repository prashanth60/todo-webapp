package com.todoapp.app.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.entity.User;
import lombok.Data;

@Data
public class TodoDto implements Serializable {

    private static final long serialVersionUID = 9087319657624196186L;

    private Long id;
    private User user;
    private String content;
    private Boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
