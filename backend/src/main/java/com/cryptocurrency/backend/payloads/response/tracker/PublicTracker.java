package com.cryptocurrency.backend.payloads.response.tracker;

import java.util.Set;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.tracker.Tracker;

public class PublicTracker {
	private Long id;
	private String name;
	private String signature;
	 private Set<CryptocurrencyInfo> favorites;

	public PublicTracker(Long id, String name,String signature,Set<CryptocurrencyInfo> favorites) {
		this.id = id;
		this.name = name;
		this.signature=signature;
		this.favorites=favorites;
	}

	public static PublicTracker build(Tracker tracker) {
		return new PublicTracker(tracker.getId(),
								 tracker.getName(),
								 tracker.getSignature(),
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
	
	public void setSignature(String signature) {
		this.signature=signature;
	}

	public String getSignature() {
		return signature;
	}
	
	public Set<CryptocurrencyInfo> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<CryptocurrencyInfo> favorites) {
		this.favorites = favorites;
	}
}
