package com.cryptocurrency.backend.payloads.response;

import com.cryptocurrency.backend.entities.auth.User;
import com.cryptocurrency.backend.entities.tracker.Tracker;

public class PublicTracker {
	private Long id;
	private String name;

	public PublicTracker(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public static PublicTracker build(Tracker tracker) {
		return new PublicTracker(tracker.getId(), tracker.getName()

		);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
