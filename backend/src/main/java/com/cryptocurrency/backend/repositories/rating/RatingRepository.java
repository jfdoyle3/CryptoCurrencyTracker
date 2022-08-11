package com.cryptocurrency.backend.repositories.rating;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entities.tracker.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
