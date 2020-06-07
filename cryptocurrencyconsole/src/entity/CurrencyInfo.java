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
@Table(name="currencyinfo")
public class CurrencyInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="currencyId")
	private String currencyId;
	
	@Column(name="price")
	private String price;
		
	@Column(name="circulating_supply")
	private String circulatingSupply;
	
	@Column(name="max_supply")
	private String maxSupply;
	
	@Column(name="market_cap")
	private String marketCap;
	
	@Column(name="rank")
	private String rank;
	
	@Column(name="high")
	private String high;
	
	@Column(name="high_timestamp")
	private String high_timestamp;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="intervalId")
	private Intervals intervals;

	public CurrencyInfo(String price, String circulatingSupply, String maxSupply, String marketCap, String rank,
			String high, String high_timestamp) {
		this.price = price;
		this.circulatingSupply = circulatingSupply;
		this.maxSupply = maxSupply;
		this.marketCap = marketCap;
		this.rank = rank;
		this.high = high;
		this.high_timestamp = high_timestamp;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getHigh_timestamp() {
		return high_timestamp;
	}

	public void setHigh_timestamp(String high_timestamp) {
		this.high_timestamp = high_timestamp;
	}

	public Intervals getIntervals() {
		return intervals;
	}

	public void setIntervals(Intervals intervals) {
		this.intervals = intervals;
	}

	@Override
	public String toString() {
		return "CurrencyInfo [currencyId=" + currencyId + ", price=" + price + ", circulatingSupply="
				+ circulatingSupply + ", maxSupply=" + maxSupply + ", marketCap=" + marketCap + ", rank=" + rank
				+ ", high=" + high + ", high_timestamp=" + high_timestamp + ", intervals=" + intervals + "]";
	}
	
}
