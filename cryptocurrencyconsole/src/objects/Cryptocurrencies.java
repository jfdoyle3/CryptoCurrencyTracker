package objects;

public class Cryptocurrencies {

	private long id;

	private String currencyId;

	private String currency;

	private String symbol;

	private String name;

	private String logoUrl;


	public Cryptocurrencies() {

	}

	public Cryptocurrencies(long id, String currencyId, String currency, String symbol, String name, String logoUrl) {
		this.id = id;
		this.currencyId = currencyId;
		this.currency = currency;
		this.symbol = symbol;
		this.name = name;
		this.logoUrl = logoUrl;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
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

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@Override
	public String toString() {
		return "Cryptocurrencies [id=" + id + ", currencyId=" + currencyId + ", currency=" + currency + ", symbol="
				+ symbol + ", name=" + name + ", logoUrl=" + logoUrl + "]";
	}

}
