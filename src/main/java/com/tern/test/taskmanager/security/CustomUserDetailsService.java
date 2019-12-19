package com.tern.test.taskmanager.security;

import com.tern.test.taskmanager.domain.User;
import com.tern.test.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);

        if(user != null) {
           return new CustomUserDetails(user, Collections.singletonList(user.getUserRole().toString()));
        }

        throw new UsernameNotFoundException("No user present with email " + email);
    }
}
