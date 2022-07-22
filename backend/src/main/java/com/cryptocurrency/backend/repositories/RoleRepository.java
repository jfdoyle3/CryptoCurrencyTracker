package com.cryptocurrency.backend.repositories;

import com.cryptocurrency.backend.entities.ERole;
import com.cryptocurrency.backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
