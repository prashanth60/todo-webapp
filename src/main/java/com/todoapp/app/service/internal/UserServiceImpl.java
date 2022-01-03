package com.todoapp.app.service.internal;

import java.util.NoSuchElementException;

import com.todoapp.app.entity.Todo;
import com.todoapp.app.entity.User;
import com.todoapp.app.repositories.UserRepository;
import com.todoapp.app.request.TodoRequest;
import com.todoapp.app.request.UserRequest;
import com.todoapp.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(NoSuchElementException::new);
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        return userRepository.save(user);
    }

    public void createTodo(Long userId, TodoRequest todoRequest) {
        User user = this.getUserById(userId);
        Todo todo = new Todo();

        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        userRepository.save(user);
    }

    /*
     * @Override
     * public User getUserByUsername(String username) {
     * // User user = userRepository.findByUsername(username);
     * // if (user == null)
     * // throw new UsernameNotFoundException("User not found with that username");
     * return userRepository
     * .findByUsername(username)
     * .orElseThrow(
     * () -> new UsernameNotFoundException("User with username - " + username +
     * ", not found"));
     * }
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username - " + username + ", not found"));
    }
}
