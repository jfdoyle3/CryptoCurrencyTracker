package com.cryptocurrency.nomics.objects;

public class Cryptocurrency {

	private long id;

	private String currencyId;

	private String currency;

	private String symbol;

	private String name;

	private String logoUrl;
	
	private String ranking;

	public Cryptocurrency() {

	}



	public Cryptocurrency(long id, String currencyId, String currency, String symbol, String name, String logoUrl,
			String ranking) {
		super();
		this.id = id;
		this.currencyId = currencyId;
		this.currency = currency;
		this.symbol = symbol;
		this.name = name;
		this.logoUrl = logoUrl;
		this.ranking = ranking;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
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



	public String getranking() {
		return ranking;
	}



	public void setranking(String ranking) {
		this.ranking = ranking;
	}



	@Override
	public String toString() {
		return "Cryptocurrency [id=" + id + ", currencyId=" + currencyId + ", currency=" + currency + ", symbol="
				+ symbol + ", name=" + name + ", logoUrl=" + logoUrl + ", ranking=" + ranking + "]";
	}

}
