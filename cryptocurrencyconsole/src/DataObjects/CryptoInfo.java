package DataObjects;

public class CryptoInfo {
	
	String id;
	String currency;
	String symbol;
	String name;
	String logo_url;
	String price;
	String price_date;
	String price_timestamp;
	String circulating_supply;
	String max_supply;
	String market_cap;
	String rank;
	String high;
	String high_timestamp;
	String btc1dayid;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
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
	public String getBtc1dayid() {
		return btc1dayid;
	}
	public void setBtc1dayid(String btc1dayid) {
		this.btc1dayid = btc1dayid;
	}
	@Override
	public String toString() {
		return "AllCrypto [id=" + id + ", currency=" + currency + ", symbol=" + symbol + ", name=" + name
				+ ", logo_url=" + logo_url + ", price=" + price + ", price_date=" + price_date + ", price_timestamp="
				+ price_timestamp + ", circulating_supply=" + circulating_supply + ", max_supply=" + max_supply
				+ ", market_cap=" + market_cap + ", rank=" + rank + ", high=" + high + ", high_timestamp="
				+ high_timestamp + ", btc1dayid=" + btc1dayid + "]";
	}
	
	

}
