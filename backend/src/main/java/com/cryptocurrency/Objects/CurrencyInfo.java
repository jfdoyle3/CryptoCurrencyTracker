package com.cryptocurrency.Objects;

public class CurrencyInfo {

	private long id;

	private String price;

	private String circulatingSupply;

	private String maxSupply;

	private String marketCap;

	private String ranking;

	private String high;

	private String highTimeStamp;

	public CurrencyInfo() {

	}

	public CurrencyInfo(String price, String circulatingSupply, String maxSupply, String marketCap, String ranking,
			String high, String highTimeStamp) {
		this.price = price;
		this.circulatingSupply = circulatingSupply;
		this.maxSupply = maxSupply;
		this.marketCap = marketCap;
		this.ranking = ranking;
		this.high = high;
		this.highTimeStamp = highTimeStamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCirculatingSupply() {
		return circulatingSupply;
	}

	public void setCirculatingSupply(String circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}

	public String getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(String maxSupply) {
		this.maxSupply = maxSupply;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getHighTimeStamp() {
		return highTimeStamp;
	}

	public void setHighTimeStamp(String highTimeStamp) {
		this.highTimeStamp = highTimeStamp;
	}

	@Override
	public String toString() {
		return "CurrencyInfo [id=" + id + ", price=" + price + ", circulatingSupply=" + circulatingSupply
				+ ", maxSupply=" + maxSupply + ", marketCap=" + marketCap + ", ranking=" + ranking + ", high=" + high
				+ ", highTimeStamp=" + highTimeStamp + "]";
	}

}
