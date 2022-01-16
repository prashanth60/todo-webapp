package com.todoapp.app.shared.utils;

import java.util.Comparator;

import com.todoapp.app.io.entity.Todo;

public class DateComparator implements Comparator<Todo> {

    @Override
    public int compare(Todo t1, Todo t2) {
        return -(t1.getCreatedAt().compareTo(t2.getCreatedAt()));
    }

}
