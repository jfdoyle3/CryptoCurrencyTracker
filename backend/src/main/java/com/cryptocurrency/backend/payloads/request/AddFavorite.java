package com.cryptocurrency.backend.payloads.request;

public class AddFavorite {

	private String currency;

	public AddFavorite() {
	}

	public AddFavorite(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
