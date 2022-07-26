package com.cryptocurrency.backend.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.tracker.Tracker;

@Repository
public interface TrackerRepository extends JpaRepository<Tracker, Long> {
	
//    List<Tracker> findAllByCurrencies(Long id);

    Optional<Tracker> findByUser_id(Long id);

    void deleteByUser_id(Long id);
    
   


    
    
    
    
}

