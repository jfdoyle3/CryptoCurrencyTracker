package objects;

public class CurrencyID {
	
	String id;
	String currency;
	String symbol;
	String name;
	String logo_url;
	
	
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
	
	@Override
	public String toString() {
		return "CurrencyID [id=" + id + ", currency=" + currency + ", symbol=" + symbol + ", name=" + name
				+ ", logo_url=" + logo_url + "]";
	}


}
