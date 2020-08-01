package com.cryptocurrency.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="intervals")
public class CurrrencyDateStamp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="price_date")
	private String priceDate;
		
	@Column(name="price_timestamp")
	private String priceTimeStamp;

	public CurrrencyDateStamp() {
		
	}

	public CurrrencyDateStamp(String priceDate, String priceTimeStamp) {
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

	@Override
	public String toString() {
		return "Intervals [id=" + id + ", priceDate=" + priceDate + ", priceTimeStamp=" + priceTimeStamp + "]";
	}

}
