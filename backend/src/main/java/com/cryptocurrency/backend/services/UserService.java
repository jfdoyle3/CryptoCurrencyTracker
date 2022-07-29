package com.cryptocurrency.backend.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cryptocurrency.backend.entities.auth.User;
import com.cryptocurrency.backend.repositories.auth.UserRepository;
import com.cryptocurrency.backend.security.services.UserDetailsImpl;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Optional<User> currentUser = userRepository.findById(userDetails.getId());

        if(currentUser.isEmpty()) {
            return null;
        }

        return currentUser.get();

    }

}
