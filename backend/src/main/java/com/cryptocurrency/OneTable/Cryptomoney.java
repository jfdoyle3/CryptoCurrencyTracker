package com.cryptocurrency.OneTable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="cryptomoney")
public class Cryptomoney {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="currencyId")
	private String currencyId;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="name")
	private String name;
	
	@Column(name="logo_url")
	private String logoUrl;
	

	public Cryptomoney() {
		
	}

	public Cryptomoney(String currencyId, String currency, String symbol, String name, String logoUrl) {
		this.currencyId = currencyId;
		this.currency = currency;
		this.symbol = symbol;
		this.name = name;
		this.logoUrl = logoUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}


	@Override
	public String toString() {
		return "Cryptocurrencies [id=" + id + ", currencyId=" + currencyId + ", currency=" + currency + ", symbol="
				+ symbol + ", name=" + name + ", logoUrl=" + logoUrl+ "]";
	}

	

	
}
