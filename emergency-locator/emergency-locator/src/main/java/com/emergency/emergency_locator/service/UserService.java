package com.emergency.emergency_locator.service;

import com.emergency.emergency_locator.model.User;
import com.emergency.emergency_locator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if email already exists to prevent database crashes
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Email already registered!");
        }

        // Ensure role is uppercase for consistency (USER, PROVIDER, ADMIN)
        if(user.getRole() != null) {
            user.setRole(user.getRole().toUpperCase());
        }

        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);

        // Professional check: matches password and ensures user exists
        if (user != null && user.getPassword().equals(password)) {
            // Note: In production, we'd use BCrypt for password hashing
            return user;
        }

        return null; // Controller will handle this by returning 401 Unauthorized
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}