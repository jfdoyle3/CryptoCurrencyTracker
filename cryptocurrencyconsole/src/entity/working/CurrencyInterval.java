package entity.working;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interval_time")
public class CurrencyInterval {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "symbol")
	private String symbol;

	@Column(name = "time_interval")
	private String timeInterval;

	@Column(name = "volume")
	private String volume;
	@Column(name = "price_change")
	private String priceChange;
	@Column(name = "price_change_pct")
	private String priceChangePct;
	@Column(name = "volume_change")
	private String volumeChange;
	@Column(name = "volume_change_pct")
	private String volumeChangePct;
	@Column(name = "market_cap_change")
	private String marketCapChange;
	@Column(name = "market_cap_change_pct")
	private String marketCapChangePct;

	public CurrencyInterval() {

	}

	public CurrencyInterval(String symbol, String timeInterval, String volume, String priceChange,
			String priceChangePct, String volumeChange, String volumeChangePct, String marketCapChange,
			String marketCapChangePct) {
		
		this.symbol = symbol;
		this.timeInterval = timeInterval;
		this.volume = volume;
		this.priceChange = priceChange;
		this.priceChangePct = priceChangePct;
		this.volumeChange = volumeChange;
		this.volumeChangePct = volumeChangePct;
		this.marketCapChange = marketCapChange;
		this.marketCapChangePct = marketCapChangePct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(String priceChange) {
		this.priceChange = priceChange;
	}

	public String getPriceChangePct() {
		return priceChangePct;
	}

	public void setPriceChangePct(String priceChangePct) {
		this.priceChangePct = priceChangePct;
	}

	public String getVolumeChange() {
		return volumeChange;
	}

	public void setVolumeChange(String volumeChange) {
		this.volumeChange = volumeChange;
	}

	public String getVolumeChangePct() {
		return volumeChangePct;
	}

	public void setVolumeChangePct(String volumeChangePct) {
		this.volumeChangePct = volumeChangePct;
	}

	public String getMarketCapChange() {
		return marketCapChange;
	}

	public void setMarketCapChange(String marketCapChange) {
		this.marketCapChange = marketCapChange;
	}

	public String getMarketCapChangePct() {
		return marketCapChangePct;
	}

	public void setMarketCapChangePct(String marketCapChangePct) {
		this.marketCapChangePct = marketCapChangePct;
	}

	@Override
	public String toString() {
		return "CurrencyInterval [symbol=" + symbol + ", timeInterval=" + timeInterval + ", volume=" + volume
				+ ", priceChange=" + priceChange + ", priceChangePct=" + priceChangePct + ", volumeChange="
				+ volumeChange + ", volumeChangePct=" + volumeChangePct + ", marketCapChange=" + marketCapChange
				+ ", marketCapChangePct=" + marketCapChangePct + "]";
	}

}