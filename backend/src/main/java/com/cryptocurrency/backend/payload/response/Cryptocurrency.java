package com.cryptocurrency.backend.payload.response;

public class Cryptocurrency {

	private String currency_id;

	private String currency;

	private String symbol;

	private String name;

	private String ranking;

	private String logoUrl;

	public Cryptocurrency() {}

	public Cryptocurrency(
						  String currency_id,
						  String currency,
						  String symbol,
						  String name,
						  String ranking,
						  String logoUrl
						  )
	{

		this.currency_id = currency_id;
		this.currency = currency;
		this.symbol = symbol;
		this.name = name;
		this.logoUrl = logoUrl;
		this.ranking = ranking;
	}


	public String getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
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
}
