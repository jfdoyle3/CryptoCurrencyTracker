package com.cryptocurrency.backend.entities.rating;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;
import com.cryptocurrency.backend.entities.tracker.Tracker;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer rate;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tracker_id", referencedColumnName="id")
	@JsonIncludeProperties("id")
	private Tracker tracker;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="currency_id", referencedColumnName="id")
	@JsonIncludeProperties("id")
	private CryptocurrencyInfo currency;

	
	public Rating() {}


	public Rating(Tracker tracker, CryptocurrencyInfo currency, Integer rate) {
		this.tracker = tracker;
		this.rate=rate;
		this.currency = currency;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Tracker getTracker() {
		return tracker;
	}
	

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}


	public CryptocurrencyInfo getCurrency() {
		return currency;
	}


	public void setCurrency(CryptocurrencyInfo currency) {
		this.currency = currency;
	}


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		this.rate = rate;
	}	
}
