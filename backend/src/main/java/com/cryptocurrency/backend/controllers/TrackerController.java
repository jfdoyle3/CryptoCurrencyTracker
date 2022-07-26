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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cryptocurrency.backend.entities.auth.User;
import com.cryptocurrency.backend.entities.tracker.Tracker;
import com.cryptocurrency.backend.payloads.response.PublicTracker;
import com.cryptocurrency.backend.payloads.response.SelfTracker;
import com.cryptocurrency.backend.repositories.CryptocurrencyInfoRepository;
import com.cryptocurrency.backend.repositories.TrackerRepository;
import com.cryptocurrency.backend.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/trackers")
public class TrackerController {

	@Autowired
	private TrackerRepository repository;

	@Autowired
	UserService userService;

	@Autowired
	private CryptocurrencyInfoRepository infoRepository;

	// GET ALL
	@GetMapping
	public @ResponseBody List<Tracker> getTrackers() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PublicTracker> getTrackerById(@PathVariable Long id) {

		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker currentTracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

		Tracker tracker = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

		return new ResponseEntity<PublicTracker>(PublicTracker.build(tracker), null, HttpStatus.SC_OK);

	}

	// GET SELF
	@GetMapping("/self")
	public @ResponseBody SelfTracker getSelf() {
		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker currentTracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));
		return SelfTracker.build(currentTracker);
	}

	// Works: CREATE Tracker
	@PostMapping
	public ResponseEntity<SelfTracker> createTracker(@RequestBody Tracker newTracker) {

		User currentUser = userService.getCurrentUser();

		if (currentUser == null) {
			return new ResponseEntity<SelfTracker>(null, null, HttpStatus.SC_BAD_REQUEST);
		}

		newTracker.setUser(currentUser);

		Tracker tracker = repository.save(newTracker);

		return new ResponseEntity<SelfTracker>(SelfTracker.build(tracker), null, HttpStatus.SC_CREATED);
	}

	@PostMapping("/currency/{currency}")
	public ResponseEntity<?> favACurrency(@PathVariable String currency) {

		String currencyToUpper = currency.toUpperCase();

		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker tracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

		tracker.currencyFavorites.addAll(infoRepository.findBySymbol(currencyToUpper));

		repository.save(tracker);

		return ResponseEntity.ok(tracker);
	}

	@DeleteMapping("/removeFavorite/{c}")
	public ResponseEntity<Tracker> removeFavorite(@PathVariable String c) {
		String currencyToUpper = c.toUpperCase();

		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker tracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));
		// Remove from Set
		return new ResponseEntity<Tracker>(null, null, HttpStatus.SC_OK);
	}

}
