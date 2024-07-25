package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.excelr.Entity.User;
import com.excelr.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Hash password and save user
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return (User) userRepository.save(user);
    }

    public User authenticate(String email, String password) throws Throwable {
        if (new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return user;
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}

