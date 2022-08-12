package com.cryptocurrency.backend.payloads.request;

public class SetRating {
	
	private int rate;

	public SetRating() {
	}

	public SetRating(int rate) {
		this.rate = rate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
