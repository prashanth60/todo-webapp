package com.todoapp.app.service;

import com.todoapp.app.entity.User;
import com.todoapp.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(User user) {
        System.out.println("Service GET *****");
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public boolean getUserByUsername(String username, String password) {
        boolean isUsernamePresent;
        boolean isPasswordPresent;
/*         try {
            isUsernamePresent = userRepository.findTopByUsername(username) != null;
            System.out.println("Username present: " + isUsernamePresent);
            isPasswordPresent = userRepository.findTopByPassword(password) != null;
            System.out.println("Password present: " + isPasswordPresent);
        } catch(NonUniqueResultException nre) {
            return true;
        } */
        isUsernamePresent = userRepository.findTopByUsername(username) != null;
        isPasswordPresent = userRepository.findTopByPassword(password) != null;
        return isUsernamePresent && isPasswordPresent;
    }

    public boolean findUserByUsername(String username) {
      //  boolean isUsernamePresent;
/*         try {
            isUsernamePresent = userRepository.findTopByUsername(username) != null;
            System.out.println("Username present (U): " + isUsernamePresent);
        } catch(NonUniqueResultException nre) {
            return true;
        } */
        
        return userRepository.findTopByUsername(username) != null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
