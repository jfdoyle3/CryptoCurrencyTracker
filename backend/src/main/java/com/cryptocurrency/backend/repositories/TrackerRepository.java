package com.cryptocurrency.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cryptocurrency.backend.entities.Tracker;

@Repository
public interface TrackerRepository extends JpaRepository<Tracker, Long> {
	
    List<Tracker> findAllByCurrencies(Long id);

    Optional<Tracker> findByUser_id(Long id);

    Void deleteByUser_id(Long id);
}

