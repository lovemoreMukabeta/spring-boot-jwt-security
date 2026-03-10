package com.example.mukabeta.controller;

import com.example.mukabeta.dto.AuthRequest;
import com.example.mukabeta.dto.AuthResponse;
import com.example.mukabeta.entity.User;
import com.example.mukabeta.service.JwtService;
import com.example.mukabeta.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authManager;


    public AuthController(JwtService jwtService, UserService userService, AuthenticationManager authManager) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.authManager = authManager;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = userService.loadUserByUsername(request.getEmail());

        String token = jwtService.generateToken(userDetails.getUsername());

        return new AuthResponse(token);
    }
}
