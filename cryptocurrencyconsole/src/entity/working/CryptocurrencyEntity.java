package entity.working;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cryptocurrency")
public class CryptocurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "currency_id")
	private String currency_id;

	@Column(name = "currency")
	private String currency;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "name")
	private String name;

	@Column(name = "ranking")
	private String ranking;

	@Column(name = "logo_url")
	private String logoUrl;

	public CryptocurrencyEntity() {

	}

	public CryptocurrencyEntity(String currency_id, String currency, String symbol, String name, String logoUrl,
			String ranking) {
		super();
		this.currency_id = currency_id;
		this.currency = currency;
		this.symbol = symbol;
		this.name = name;
		this.logoUrl = logoUrl;
		this.ranking = ranking;
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

	public String getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Cryptocurrencies [currency_id=" + currency_id + ", currency=" + currency + ", symbol=" + symbol
				+ ", name=" + name + ", logoUrl=" + logoUrl + ", ranking=" + ranking + "]";
	}

}
