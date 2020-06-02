package DataObjects;

public class All1day {
	String btcid;
	String volume;
	String price_change;
	String price_change_pct;
	String volume_change;
	String volume_change_pct;
	String market_cap_change;
	String market_cap_change_pct;
	
	public String getBtcid() {
		return btcid;
	}
	public void setBtcid(String btcid) {
		this.btcid = btcid;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getPrice_change() {
		return price_change;
	}
	public void setPrice_change(String price_change) {
		this.price_change = price_change;
	}
	public String getPrice_change_pct() {
		return price_change_pct;
	}
	public void setPrice_change_pct(String price_change_pct) {
		this.price_change_pct = price_change_pct;
	}
	public String getVolume_change() {
		return volume_change;
	}
	public void setVolume_change(String volume_change) {
		this.volume_change = volume_change;
	}
	public String getVolume_change_pct() {
		return volume_change_pct;
	}
	public void setVolume_change_pct(String volume_change_pct) {
		this.volume_change_pct = volume_change_pct;
	}
	public String getMarket_cap_change() {
		return market_cap_change;
	}
	public void setMarket_cap_change(String market_cap_change) {
		this.market_cap_change = market_cap_change;
	}
	public String getMarket_cap_change_pct() {
		return market_cap_change_pct;
	}
	public void setMarket_cap_change_pct(String market_cap_change_pct) {
		this.market_cap_change_pct = market_cap_change_pct;
	}
	@Override
	public String toString() {
		return "All1day [btcid=" + btcid + ", volume=" + volume + ", price_change=" + price_change
				+ ", price_change_pct=" + price_change_pct + ", volume_change=" + volume_change + ", volume_change_pct="
				+ volume_change_pct + ", market_cap_change=" + market_cap_change + ", market_cap_change_pct="
				+ market_cap_change_pct + "]";
	}
	
}