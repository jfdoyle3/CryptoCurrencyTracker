package com.cryptocurrency.backend.repositories.rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entities.rating.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	Rating findByCurrencyId(Long id);
    List<Rating> findAllById(Long id);
    
    boolean existsByCurrency_id(Long currencyId);
    
    void deleteById(Long id);

}
