package objects;

public class CurrencyInterval {
<<<<<<< HEAD
	
=======

>>>>>>> Working
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

<<<<<<< HEAD

	public CurrencyInterval() {
		
	}

=======
	public CurrencyInterval() {

	}
>>>>>>> Working

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

<<<<<<< HEAD

=======
>>>>>>> Working
	public long getId() {
		return id;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setId(long id) {
		this.id = id;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getTimeInterval() {
		return timeInterval;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getSymbol() {
		return Symbol;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getVolume() {
		return volume;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setVolume(String volume) {
		this.volume = volume;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getPriceChange() {
		return priceChange;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setPriceChange(String priceChange) {
		this.priceChange = priceChange;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getPriceChangePct() {
		return priceChangePct;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setPriceChangePct(String priceChangePct) {
		this.priceChangePct = priceChangePct;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getVolumeChange() {
		return volumeChange;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setVolumeChange(String volumeChange) {
		this.volumeChange = volumeChange;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getVolumeChangePct() {
		return volumeChangePct;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setVolumeChangePct(String volumeChangePct) {
		this.volumeChangePct = volumeChangePct;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getMarketCapChange() {
		return marketCapChange;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setMarketCapChange(String marketCapChange) {
		this.marketCapChange = marketCapChange;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public String getMarketCapChangePct() {
		return marketCapChangePct;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	public void setMarketCapChangePct(String marketCapChangePct) {
		this.marketCapChangePct = marketCapChangePct;
	}

<<<<<<< HEAD

=======
>>>>>>> Working
	@Override
	public String toString() {
		return "CurrencyInterval [id=" + id + ", timeInterval=" + timeInterval + ", Symbol=" + Symbol + ", volume="
				+ volume + ", priceChange=" + priceChange + ", priceChangePct=" + priceChangePct + ", volumeChange="
				+ volumeChange + ", volumeChangePct=" + volumeChangePct + ", marketCapChange=" + marketCapChange
				+ ", marketCapChangePct=" + marketCapChangePct + "]";
	}

<<<<<<< HEAD

=======
>>>>>>> Working
}
