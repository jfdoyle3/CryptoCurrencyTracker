package com.cryptocurrency.backend.payloads.response;


import java.util.Set;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.tracker.Tracker;

public class SelfTracker {
    private Long id;
    private String name;
    private Set<CryptocurrencyInfo> favorites;
    
    public SelfTracker(Long id, String name, Set<CryptocurrencyInfo> favorites) {
        this.id = id;
        this.name = name;
        this.favorites=favorites;
        
        
    }

    static public SelfTracker build(Tracker Tracker) {
     //   Set<Tracker> empty/currency = new HashSet<>();
        return new SelfTracker(
                Tracker.getId(),
                Tracker.getName(),
                Tracker.getFavorites()
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
