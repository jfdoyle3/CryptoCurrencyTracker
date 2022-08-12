package com.cryptocurrency.backend.entities.tracker;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cryptocurrency.backend.entities.auth.User;
import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.rating.Rating;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Tracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String name;
	private String signature;
	
    @ManyToMany
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(name = "tracker_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "currencyinfo_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("trackers")
    public Set<CryptocurrencyInfo> favorites = new HashSet<>();


	@OneToOne
	@JoinColumn(name = "users_id", referencedColumnName = "id")
	@JsonIgnore
	private User user;

	@OneToOne
	private Avatar avatar;
	
	@OneToMany(mappedBy="tracker", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<Rating> ratings;
	

	public Tracker() {
	}

	public Tracker(Long id, String name, String signature) {
		this.id = id;
		this.name = name;
		this.signature=signature;
		
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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Set<CryptocurrencyInfo> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<CryptocurrencyInfo> favorites) {
		this.favorites = favorites;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}
