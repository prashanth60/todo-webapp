package com.todoapp.app.service.internal;

import java.util.NoSuchElementException;

import com.todoapp.app.entity.Todo;
import com.todoapp.app.entity.User;
import com.todoapp.app.repositories.UserRepository;
import com.todoapp.app.request.TodoRequest;
import com.todoapp.app.request.UserRequest;
import com.todoapp.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    public void createTodo(Long userId, TodoRequest todoRequest) {
        User user = this.getUserById(userId);
        Todo todo = new Todo();

        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new Exception("User not found with that username");
        return user;
    }
}
