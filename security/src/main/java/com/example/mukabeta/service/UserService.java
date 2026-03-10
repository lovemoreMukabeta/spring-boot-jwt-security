package com.example.mukabeta.service;

import com.example.mukabeta.entity.User;
import com.example.mukabeta.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final CustomUserDetailsService customUserDetailsService;


    public UserService(UserRepository repo, PasswordEncoder encoder, CustomUserDetailsService customUserDetailsService) {
        this.repo = repo;
        this.encoder = encoder;
        this.customUserDetailsService = customUserDetailsService;
    }

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public UserDetails loadUserByUsername(String email) {
        return customUserDetailsService.loadUserByUsername(email);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
