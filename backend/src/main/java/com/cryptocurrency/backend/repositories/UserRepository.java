package com.cryptocurrency.backend.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entities.auth.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
