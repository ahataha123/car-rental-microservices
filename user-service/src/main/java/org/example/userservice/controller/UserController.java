// src/main/java/org/example/userservice/controller/UserController.java
package org.example.userservice.controller;

import org.example.userservice.dto.LoginRequest;
import org.example.userservice.model.User;
import org.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.register(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }
}
