package com.cryptocurrency.backend.entities.tracker;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.cryptocurrency.backend.entities.auth.User;
import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Tracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String name;
	
    @ManyToMany
    @JoinTable(
            name = "tracker_currency_favorites",
            joinColumns = @JoinColumn(name = "tracker_id"),
            inverseJoinColumns = @JoinColumn(name = "currency_info_id")
    )
    @JsonIgnoreProperties("trackers")
    public Set<CryptocurrencyInfo> currencyFavorites = new HashSet<>();


	@OneToOne
	@JoinColumn(name = "users_id", referencedColumnName = "id")
	@JsonIgnore
	private User user;


	

	public Tracker() {
	}

	public Tracker(Long id, String name) {
		this.id = id;
		this.name = name;
		
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

	public Set<CryptocurrencyInfo> getCurrencyFavorites() {
		return currencyFavorites;
	}

	public void setCurrencyFavorites(Set<CryptocurrencyInfo> currencyFavorites) {
		this.currencyFavorites = currencyFavorites;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
