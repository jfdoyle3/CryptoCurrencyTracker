package objects;

public class CurrencyInterval {
	
	private long id;
	private String timeInterval;
	private String Symbol;
	private String volume;
	private String priceChange;
	private String priceChangePct;
	private String volumeChange;
	private String volumeChangePct;
	private String marketCapChange;
	private String marketCapChangePct;


	public CurrencyInterval() {
		
	}


	public CurrencyInterval(long id, String timeInterval, String symbol, String volume, String priceChange,
			String priceChangePct, String volumeChange, String volumeChangePct, String marketCapChange,
			String marketCapChangePct) {
		this.id = id;
		this.timeInterval = timeInterval;
		this.Symbol = symbol;
		this.volume = volume;
		this.priceChange = priceChange;
		this.priceChangePct = priceChangePct;
		this.volumeChange = volumeChange;
		this.volumeChangePct = volumeChangePct;
		this.marketCapChange = marketCapChange;
		this.marketCapChangePct = marketCapChangePct;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTimeInterval() {
		return timeInterval;
	}


	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}


	public String getSymbol() {
		return Symbol;
	}


	public void setSymbol(String symbol) {
		Symbol = symbol;
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
		return "OneDayInterval [id=" + id + ", timeInterval=" + timeInterval + ", Symbol=" + Symbol + ", volume="
				+ volume + ", priceChange=" + priceChange + ", priceChangePct=" + priceChangePct + ", volumeChange="
				+ volumeChange + ", volumeChangePct=" + volumeChangePct + ", marketCapChange=" + marketCapChange
				+ ", marketCapChangePct=" + marketCapChangePct + "]";
	}


}
