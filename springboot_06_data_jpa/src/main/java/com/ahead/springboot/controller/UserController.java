package com.ahead.springboot.controller;

import com.ahead.springboot.pojo.User;
import com.ahead.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/16
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.get();
    }

    @GetMapping("/user")
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }
}
