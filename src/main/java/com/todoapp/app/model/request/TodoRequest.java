package com.todoapp.app.model.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoRequest {
    @NotEmpty
    private String itemContent;
}
