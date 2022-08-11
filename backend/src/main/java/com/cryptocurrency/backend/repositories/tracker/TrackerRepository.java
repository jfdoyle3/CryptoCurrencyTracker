package com.cryptocurrency.backend.repositories.tracker;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cryptocurrency.backend.entities.tracker.Tracker;

@Repository
public interface TrackerRepository extends JpaRepository<Tracker, Long> {
	
    List<Tracker> findAll();
    
    List<Tracker> findAllByRatings_currency_id(Long id);

    Optional<Tracker> findByUser_id(Long id);

    void deleteByUser_id(Long id);
    
   
    
    
    
   


    
    
    
    
}

