package com.cryptocurrency.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import com.cryptocurrency.backend.payloads.response.tracker.PublicTracker;
import com.cryptocurrency.backend.payloads.response.tracker.SelfTracker;
import com.cryptocurrency.backend.repositories.cryptocurrency.CryptocurrencyInfoRepository;
import com.cryptocurrency.backend.repositories.tracker.TrackerRepository;
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

	// GET MAPPINGS
	@GetMapping
	public @ResponseBody List<Tracker> getTrackers() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PublicTracker> getTrackerById(@PathVariable Long id) {

		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker tracker = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

		return new ResponseEntity<PublicTracker>(PublicTracker.build(tracker), null, HttpStatus.SC_OK);

	}
	
//	@GetMapping("/favorites/{id}")
//    public ResponseEntity<?> getFavoriteByCurrency(@PathVariable Long id) {
//		User currentUser = userService.getCurrentUser();
//
//		if (currentUser == null)
//			return null;
//
//		Tracker currentTracker = repository.findByUser_id(currentUser.getId())
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));
////		
////		currentTracker.favorites.
////		
////		return new ResponseEntity<?>(null, null, HttpStatus.SC_GONE);
//    }

	@GetMapping("/self")
	public @ResponseBody SelfTracker getSelf() {
		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker currentTracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));
		return SelfTracker.build(currentTracker);
	}

	// POST MAPPINGS
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

	@PostMapping("/addFavorite/{currency}")
	public ResponseEntity<?> addFavorite(@PathVariable String currency) {

		String currencyToUpper = currency.toUpperCase();

		User currentUser = userService.getCurrentUser();

		if (currentUser == null)
			return null;

		Tracker tracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

		tracker.favorites.addAll(infoRepository.findBySymbol(currencyToUpper));

		repository.save(tracker);

		return ResponseEntity.ok(tracker);
	}

	// PUT MAPPINGS
	@PutMapping
	public @ResponseBody Tracker updateTracker(@RequestBody Tracker updates) {
		User currentUser = userService.getCurrentUser();

		if (currentUser == null) {
			return null;
		}
		Tracker tracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));


		if (updates.getName() != null)
			tracker.setName(updates.getName());

		return repository.save(tracker);
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

		return new ResponseEntity<Tracker>(null, null, HttpStatus.SC_GONE);
	}

	@DeleteMapping
	public ResponseEntity<String> destroyTracker() {
		User currentUser = userService.getCurrentUser();

		if (currentUser == null) {
			return null;
		}
		repository.deleteById(currentUser.getId());
		return new ResponseEntity<String>("Deleted", null, HttpStatus.SC_GONE);
	}
}
