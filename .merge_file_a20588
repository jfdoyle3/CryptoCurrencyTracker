package com.cryptocurrency.backend.entity.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bitstamp")
public class Bitstamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "unix_timestamp")
	private String unixTimestamp;
	
	@Column(name = "date_time")
	private String dateTime;
	
	@Column(name = "open")
	private String open;
	
	@Column(name = "high")
	private String high;
	
	@Column(name = "low")
	private String low;
	
	@Column(name = "close")
	private String close;
	
	@Column(name = "volume_btc")
	private String volumeBTC;
	
	@Column(name = "volume_currency")
	private String volumeCurrency;
	
	@Column(name = "weighted_price")
	private String weightedPrice;

	public Bitstamp() {}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
