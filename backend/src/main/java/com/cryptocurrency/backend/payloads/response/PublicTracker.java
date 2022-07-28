package com.cryptocurrency.backend.payloads.response;

import java.util.Set;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.tracker.Tracker;

public class PublicTracker {
	private Long id;
	private String name;
	 private Set<CryptocurrencyInfo> favorites;

	public PublicTracker(Long id, String name,Set<CryptocurrencyInfo> favorites) {
		this.id = id;
		this.name = name;
		this.favorites=favorites;
	}

	public static PublicTracker build(Tracker tracker) {
		return new PublicTracker(tracker.getId(),
								 tracker.getName(),
								 tracker.getFavorites()

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

	public Set<CryptocurrencyInfo> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<CryptocurrencyInfo> favorites) {
		this.favorites = favorites;
	}
}
