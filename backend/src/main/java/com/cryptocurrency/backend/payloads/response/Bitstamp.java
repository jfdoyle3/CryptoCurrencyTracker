package com.cryptocurrency.backend.payloads.response;

public class Bitstamp {

	private String unixTimestamp;

	private String dateTime;

	private String open;

	private String high;

	private String low;

	private String close;

	private String volumeBTC;

	private String volumeCurrency;

	private String weightedPrice;

	public Bitstamp() {
	}

	public Bitstamp(
					String unixTimestamp, 
					String dateTime, 
					String open, 
					String high, 
					String low, 
					String close,
					String volumeBTC, 
					String volumeCurrency, 
					String weightedPrice
					) 
	{
		this.unixTimestamp = unixTimestamp;
		this.dateTime = dateTime;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volumeBTC = volumeBTC;
		this.volumeCurrency = volumeCurrency;
		this.weightedPrice = weightedPrice;
	}

	public String getUnixTimestamp() {
		return unixTimestamp;
	}

	public void setUnixTimestamp(String unixTimestamp) {
		this.unixTimestamp = unixTimestamp;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolumeBTC() {
		return volumeBTC;
	}

	public void setVolumeBTC(String volumeBTC) {
		this.volumeBTC = volumeBTC;
	}

	public String getVolumeCurrency() {
		return volumeCurrency;
	}

	public void setVolumeCurrency(String volumeCurrency) {
		this.volumeCurrency = volumeCurrency;
	}

	public String getWeightedPrice() {
		return weightedPrice;
	}

	public void setWeightedPrice(String weightedPrice) {
		this.weightedPrice = weightedPrice;
	}
}
