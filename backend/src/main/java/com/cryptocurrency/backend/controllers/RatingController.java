package com.cryptocurrency.backend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.entities.auth.User;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;

import com.cryptocurrency.backend.entities.rating.Rating;
import com.cryptocurrency.backend.entities.tracker.Tracker;

import com.cryptocurrency.backend.payloads.request.SetRating;
import com.cryptocurrency.backend.repositories.cryptocurrency.CryptocurrencyInfoRepository;
import com.cryptocurrency.backend.repositories.rating.RatingRepository;
import com.cryptocurrency.backend.repositories.tracker.TrackerRepository;
import com.cryptocurrency.backend.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/currency")
public class RatingController {
	private int methodRan = 0;
	
	@Autowired
	private RatingRepository repository;
	
	@Autowired
	private CryptocurrencyInfoRepository infoRepository;

	@Autowired
	private TrackerRepository trackerRepository;

	@Autowired
	UserService userService;

	// POST MAPPINGS
	// Rate Currencies
	@PostMapping("/rate/{trackerId}/{cId}")
	public ResponseEntity<CryptocurrencyInfo> rateById(@PathVariable Long trackerId,@PathVariable Long cId,
			@RequestBody SetRating setRating) {
		Optional<CryptocurrencyInfo> currency = infoRepository.findById(cId);
		Optional<Tracker> tracker = trackerRepository.findById(trackerId);

		if (currency.isEmpty() || tracker.isEmpty())
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		if (repository.existsByCurrency_id(cId)) {
			Rating updateRating=repository.findByCurrencyId(cId);
			updateRating.setRate(setRating.getRate());
			repository.save(updateRating);
			return new ResponseEntity<>(currency.get(), HttpStatus.CREATED);
		}
		
		Rating newRating = new Rating(tracker.get(), currency.get(), setRating.getRate());
		repository.save(newRating);
		return new ResponseEntity<>(currency.get(), HttpStatus.CREATED);
	}
	
//	DELETE MAPPINGS
//	May need this
//  If Rating is then the record should be deleted
//	If Currency is no longer available 

}
