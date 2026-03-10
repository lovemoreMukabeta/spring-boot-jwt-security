package com.example.mukabeta.controller;

import com.example.mukabeta.entity.User;
import com.example.mukabeta.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> gatAllUsers() {
        return userService.getAllUsers();
    }
}
