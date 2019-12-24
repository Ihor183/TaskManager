package com.tern.test.taskmanager.service;

import com.tern.test.taskmanager.domain.User;
import com.tern.test.taskmanager.domain.UserRole;
import com.tern.test.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.ROLE_USER);
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }
}
