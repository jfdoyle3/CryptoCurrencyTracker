package objects;

public class IntervalDateStamp {

	private long id;

	private String priceDate;

	private String priceTimeStamp;

	public IntervalDateStamp() {

	}

	public IntervalDateStamp(String priceDate, String priceTimeStamp) {
		this.priceDate = priceDate;
		this.priceTimeStamp = priceTimeStamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Intervals [id=" + id + ", priceDate=" + priceDate + ", priceTimeStamp=" + priceTimeStamp + "]";
	}

}
