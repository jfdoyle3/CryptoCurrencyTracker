package com.cryptocurrency.backend.entities;

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
            name = "tracker_currenc_info",
            joinColumns = @JoinColumn(name = "tracker_id"),
            inverseJoinColumns = @JoinColumn(name = "currency_info_id")
    )
    @JsonIgnoreProperties("trackers")
    public Set<CryptocurrencyInfo> curencyInfo = new HashSet<>();


	@OneToOne
	@JoinColumn(name = "users_id", referencedColumnName = "id")
	@JsonIgnore
	private User user;

	public Tracker() {
	}

	public Tracker(Long id, String name, User user) {
		this.id = id;
		this.name = name;
		this.user = user;
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

	public Set<CryptocurrencyInfo> getCurencyInfo() {
		return curencyInfo;
	}

	public void setCurencyInfo(Set<CryptocurrencyInfo> curencyInfo) {
		this.curencyInfo = curencyInfo;
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
