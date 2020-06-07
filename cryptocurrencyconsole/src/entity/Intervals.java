package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="intervals")
public class Intervals {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="intervalId")
	String intervalId;
	
	@Column(name="price_date")
	String priceDate;
	
	@Column(name="price_timestamp")
	String priceTimestamp;

	public Intervals(String priceDate, String priceTimestamp) {
		this.priceDate = priceDate;
		this.priceTimestamp = priceTimestamp;
	}

	public String getIntervalId() {
		return intervalId;
	}

	public void setIntervalId(String intervalId) {
		this.intervalId = intervalId;
	}

	public String getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}

	public String getPriceTimestamp() {
		return priceTimestamp;
	}

	public void setPriceTimestamp(String priceTimestamp) {
		this.priceTimestamp = priceTimestamp;
	}

	@Override
	public String toString() {
		return "Intervals [intervalId=" + intervalId + ", priceDate=" + priceDate + ", priceTimestamp=" + priceTimestamp
				+ "]";
	}
		
}