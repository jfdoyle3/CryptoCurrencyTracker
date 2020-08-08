package  testhibernate;

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
@Table(name="cryptocurrencies")
public class Cryptocurrencies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="currency_id")
	private String currency_id;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="name")
	private String name;
	
	@Column(name="logo_url")
	private String logoUrl;
	


	public Cryptocurrencies() {
		
	}

	public Cryptocurrencies(String currency_id, String currency, String symbol, String name, String logoUrl) {
		this.currency_id = currency_id;
		this.currency = currency;
		this.symbol = symbol;
		this.name = name;
		this.logoUrl = logoUrl;
	}


	public String getcurrency_id() {
		return currency_id;
	}

	public void setcurrency_id(String currency_id) {
		this.currency_id = currency_id;
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
		return "Cryptocurrencies [id=" + id + ", currency_id=" + currency_id + ", currency=" + currency + ", symbol="
				+ symbol + ", name=" + name + ", logoUrl=" + logoUrl + "]";
	}
	

	
	

	

	
}
