package objects;

public class CurrencyInfo {

	private long id;

	private String symbol;

	private String price;
	
	private String priceDate;
	
	private String priceTimeStamp;

	private String circulatingSupply;

	private String maxSupply;

	private String marketCap;

	private String high;

	private String highTimeStamp;

	public CurrencyInfo() {

	}

	public CurrencyInfo(long id, String symbol, String price, String priceDate, String priceTimeStamp,
			String circulatingSupply, String maxSupply, String marketCap, String high,
			String highTimeStamp) {
		this.id = id;
		this.symbol = symbol;
		this.price = price;
		this.priceDate = priceDate;
		this.priceTimeStamp = priceTimeStamp;
		this.circulatingSupply = circulatingSupply;
		this.maxSupply = maxSupply;
		this.marketCap = marketCap;
	
		this.high = high;
		this.highTimeStamp = highTimeStamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
		return "CurrencyInfo [id=" + id + ", symbol=" + symbol + ", price=" + price + ", priceDate=" + priceDate
				+ ", priceTimeStamp=" + priceTimeStamp + ", circulatingSupply=" + circulatingSupply + ", maxSupply="
				+ maxSupply + ", marketCap=" + marketCap + ", high=" + high
				+ ", highTimeStamp=" + highTimeStamp + "]";
	}


}
