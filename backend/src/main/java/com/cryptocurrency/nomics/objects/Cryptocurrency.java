package com.cryptocurrency.nomics.objects;



public class Cryptocurrency {

	private int id;

	private String currency_id;

	private String currency;

	private String symbol;

	private String name;

	private String ranking;

	private String logoUrl;

	public Cryptocurrency() {}

	public Cryptocurrency(String currency_id, String currency, String symbol, String name, String logoUrl,
			String ranking) {

		// this.id = id;
		this.currency_id = currency_id;
		this.currency = currency;
		this.symbol = symbol;
		this.name = name;
		this.logoUrl = logoUrl;
		this.ranking = ranking;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getcurrency_id() {
		return currency_id;
	}

	public void setcurrency_id(String currency_id) {
		this.currency_id = currency_id;
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
		return "Cryptocurrency [id=" + id + ", currency_id=" + currency_id + ", currency=" + currency + ", symbol="
				+ symbol + ", name=" + name + ", logoUrl=" + logoUrl + ", ranking=" + ranking + "]";
	}

}
