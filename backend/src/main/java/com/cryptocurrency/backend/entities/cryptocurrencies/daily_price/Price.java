package com.cryptocurrency.backend.entities.cryptocurrencies.daily_price;

import javax.persistence.Column;

public class Price {
	@Column(name = "symbol")
	private String symbol;

	
	// US Dollars
	@Column(name = "price")
	private String price;

	@Column(name = "price_date")
	private String priceDate;

	@Column(name = "price_timestamp")
	private String priceTimeStamp;
	// Price * Circulating Supply = Market Cap
	@Column(name = "circulating_supply")
	private String circulatingSupply;

	@Column(name = "max_supply")
	private String maxSupply;
	// Market Cap = Price * Circulating Supply
	@Column(name = "market_cap")
	private String marketCap;

	@Column(name = "high")
	private String high;

	@Column(name = "high_timestamp")
	private String highTimeStamp;


}
