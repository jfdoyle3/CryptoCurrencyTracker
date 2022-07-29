package com.cryptocurrency.backend.repositories.auth;

import com.cryptocurrency.backend.entities.auth.ERole;
import com.cryptocurrency.backend.entities.auth.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    
    @Query(value = "select count(*) from role",
            nativeQuery = true)
    int isRoleEmpty();

}
