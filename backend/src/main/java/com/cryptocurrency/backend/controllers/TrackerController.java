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
import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.tracker.Tracker;
import com.cryptocurrency.backend.payloads.response.PublicTracker;
import com.cryptocurrency.backend.payloads.response.SelfTracker;
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

	
	// GET ALL
	@GetMapping
	public @ResponseBody List<Tracker> getTrackers() {
		return repository.findAll();
	}

	
	// GET SELF
	@GetMapping("/self")
	public @ResponseBody SelfTracker getSelf() {
		User currentUser = userService.getCurrentUser();

		if (currentUser == null) 
			return null;
		
		Tracker currentDev = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));
		return SelfTracker.build(currentDev);
	}

	 @GetMapping("/{id}")
	    public ResponseEntity<?> getTrackerById(@PathVariable Long id) {
	        
	        User currentUser = userService.getCurrentUser();

	        if (currentUser == null) {
	            return null;
	        }
	        
	        
	        Tracker currentTracker = repository.findByUser_id(currentUser.getId()).orElseThrow(
	                () -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null)
	        );

//	        Tracker currentTracker = repository.findById(id).orElseThrow(
//	                () -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null)
//	        );
	        // TODO: if blocked send 404

	        return new ResponseEntity<PublicTracker>(PublicTracker.build(currentTracker), null, HttpStatus.SC_OK);

	    }
	
	// CREATE Tracker
	@PostMapping
	public ResponseEntity<SelfTracker> createTracker(@RequestBody Tracker newTracker) {

		User currentUser = userService.getCurrentUser();

		if (currentUser == null) {
			return new ResponseEntity<SelfTracker>(null, null, HttpStatus.SC_BAD_REQUEST);
		}

		// TODO add check for existing Tracker profile.
		newTracker.setUser(currentUser);

		Tracker dev = repository.save(newTracker);

		return new ResponseEntity<SelfTracker>(SelfTracker.build(dev), null, HttpStatus.SC_CREATED);
	}

	// Add a Currency to favorites
//	@PostMapping("/addCurrency")
//	public ResponseEntity<?> addCurrency(){
//		
//		
//		
//		
//		
//		return new ResponseEntity<?>(null, null, HttpStatus.SC_CREATED);
//	}
//	
	
	// DELETE TRACKER
	@DeleteMapping
	public ResponseEntity<String> destroyTracker() {
		User currentUser = userService.getCurrentUser();

		if (currentUser == null) {
			return null;
		}
		repository.deleteByUser_id(currentUser.getId());
		return new ResponseEntity<String>("Deleted", null, HttpStatus.SC_OK);
	}
//	@PutMapping("/currency")
//	public Tracker addCurrency(@RequestBody List<CryptocurrencyInfo> updates) {
//		User currentUser = userService.getCurrentUser();
//
//		if (currentUser == null) {
//			return null;
//		}
//		Tracker Tracker = repository.findByUser_id(currentUser.getId())
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));
//
//		Tracker.currencyFavorites.addAll(updates);
//		return repository.save(Tracker);
//	}

	@PutMapping
	public @ResponseBody Tracker updateTracker(@RequestBody Tracker updates) {
		User currentUser = userService.getCurrentUser();

		if (currentUser == null) {
			return null;
		}
		Tracker Tracker = repository.findByUser_id(currentUser.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.SC_NOT_FOUND, null, null));

//	        updates.setId(Tracker.getId());
//	        return repository.save(updates);
		if (updates.getName() != null)
			Tracker.setName(updates.getName());
//	        if (updates.getEmail() != null) Tracker.setEmail(updates.getEmail());
	        if (updates.currencyFavorites != null) Tracker.setCurrencyFavorites(updates.getCurrencyFavorites());

		return repository.save(Tracker);
	}

}
