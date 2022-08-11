package com.cryptocurrency.backend.entities.cryptocurrencies;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cryptocurrency.backend.entities.rating.Rating;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@Entity
@Table(name = "currency_info")
public class CryptocurrencyInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "name")
	private String name;

	@Column(name = "ranking")
	private String ranking;

	@Column(name = "logo_url")
	private String logoUrl;
	
	@OneToMany(mappedBy="currency",fetch=FetchType.LAZY)
	@JsonIncludeProperties("tracker")
	private Set<Rating> ratings;
	
	public CryptocurrencyInfo() {}

	public CryptocurrencyInfo(
							  String symbol,
							  String name,
							  String ranking,
							  String logoUrl
							  )
	{
		this.symbol = symbol;
		this.name = name;
		this.ranking = ranking;
		this.logoUrl = logoUrl;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}
