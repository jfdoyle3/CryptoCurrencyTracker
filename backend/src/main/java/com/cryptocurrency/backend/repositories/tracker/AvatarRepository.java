package com.cryptocurrency.backend.repositories.tracker;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entities.tracker.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

}
