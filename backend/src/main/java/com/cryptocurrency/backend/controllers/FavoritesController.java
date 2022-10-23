package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cryptocurrency.backend.entities.auth.User;
import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;

import com.cryptocurrency.backend.entities.tracker.Tracker;
import com.cryptocurrency.backend.payloads.request.AddFavorite;

import com.cryptocurrency.backend.repositories.cryptocurrency.CryptocurrencyInfoRepository;

import com.cryptocurrency.backend.repositories.tracker.TrackerRepository;
import com.cryptocurrency.backend.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/trackers")
public class FavoritesController {

	@Autowired
	private TrackerRepository repository;

	@Autowired
	UserService userService;

	@Autowired
	private CryptocurrencyInfoRepository infoRepository;
	
	// GET MAPPINGS
	@GetMapping("/rate/{trackerId}")
	public List<CryptocurrencyInfo> getRatedCurrency(@PathVariable Long trackerId) {
		return infoRepository.findAllByRatings_tracker_id(trackerId);
	}

	// POST MAPPINGS
	@PostMapping("/addFavorite/")
	public ResponseEntity<Tracker> addFavorite(@RequestBody AddFavorite currency) {

		String currencyToUpper = currency.getCurrency().toUpperCase();

		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker tracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

		tracker.favorites.addAll(infoRepository.findBySymbol(currencyToUpper));

		repository.save(tracker);

		return new ResponseEntity<Tracker>(null, null, HttpStatus.SC_OK);

	}


	// DELETE MAPPINGS
	@DeleteMapping("/removeFavorite/{currency}")
	public ResponseEntity<Tracker> removeFavorite(@PathVariable String currency) {
		String currencyToUpper = currency.toUpperCase();

		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker tracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

		tracker.favorites.removeAll(infoRepository.findBySymbol(currencyToUpper));

		repository.save(tracker);

		return new ResponseEntity<Tracker>(null, null, HttpStatus.SC_OK);

	}
}
