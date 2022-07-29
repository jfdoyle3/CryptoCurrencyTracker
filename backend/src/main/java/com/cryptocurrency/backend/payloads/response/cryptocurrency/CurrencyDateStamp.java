package com.cryptocurrency.backend.payloads.response.cryptocurrency;


public class CurrencyDateStamp {

	private int id;

	private String priceDate;

	private String priceTimeStamp;

	public CurrencyDateStamp() {}

	public CurrencyDateStamp(
							  String priceDate,
							  String priceTimeStamp
							  ) 
	{
		this.priceDate = priceDate;
		this.priceTimeStamp = priceTimeStamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}

	public String getPriceTimeStamp() {
		return priceTimeStamp;
	}

	public void setPriceTimeStamp(String priceTimeStamp) {
		this.priceTimeStamp = priceTimeStamp;
	}
}
