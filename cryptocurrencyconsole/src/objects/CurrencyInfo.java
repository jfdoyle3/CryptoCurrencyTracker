package objects;

public class CurrencyInfo {
	
	String currencyId;
	String price;
	String price_date;
	String price_timestamp;
	String circulating_supply;
	String max_supply;
	String market_cap;
	String rank;
	String high;
	String high_timestamp;
	String intervalId;
	
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
	public String getPrice_date() {
		return price_date;
	}
	public void setPrice_date(String price_date) {
		this.price_date = price_date;
	}
	public String getPrice_timestamp() {
		return price_timestamp;
	}
	public void setPrice_timestamp(String price_timestamp) {
		this.price_timestamp = price_timestamp;
	}
	public String getCirculating_supply() {
		return circulating_supply;
	}
	public void setCirculating_supply(String circulating_supply) {
		this.circulating_supply = circulating_supply;
	}
	public String getMax_supply() {
		return max_supply;
	}
	public void setMax_supply(String max_supply) {
		this.max_supply = max_supply;
	}
	public String getMarket_cap() {
		return market_cap;
	}
	public void setMarket_cap(String market_cap) {
		this.market_cap = market_cap;
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
	public String getIntervalid() {
		return intervalId;
	}
	public void setIntervalid(String intervalId) {
		this.intervalId = intervalId;
	}
	@Override
	public String toString() {
		return "CurrencyInfo [currencyId=" + currencyId + ", price=" + price + ", price_date=" + price_date
				+ ", price_timestamp=" + price_timestamp + ", circulating_supply=" + circulating_supply
				+ ", max_supply=" + max_supply + ", market_cap=" + market_cap + ", rank=" + rank + ", high=" + high
				+ ", high_timestamp=" + high_timestamp + ", intervalId=" + intervalId + "]";
	}
	
	
}
