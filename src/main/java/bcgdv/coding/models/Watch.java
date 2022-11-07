package bcgdv.coding.models;

public class Watch {
	
	private String watchId;
	private String watchName;
	private int unitPrice;
	private String discount;
	
	public Watch(String watchId, String watchName, int unitPrice, String discount) {
		super();
		this.watchId = watchId;
		this.watchName = watchName;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}
	public String getWatchId() {
		return watchId;
	}
	public void setWatchId(String watchId) {
		this.watchId = watchId;
	}
	public String getWatchName() {
		return watchName;
	}
	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
