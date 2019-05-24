public abstract class Oil {
	private String company;
	private String oilType;
	private double priceInStore;
	
	public Oil(String company, String oilType) {
		this.company = company;
		this.oilType = oilType;
		this.priceInStore = 0;
	}
	
	public double getPriceInStore() {
		return this.priceInStore;
	}
	public void setPriceInStore(double priceInStore) {
		this.priceInStore = priceInStore;
	}
	
	@Override
	public String toString() {
		return String.format(
			"company: %s\n" +
			"oil type: %s\n",
			this.company, this.oilType);
	}
	
	abstract int getOilPrice();
	abstract void setOilPrice(int price);
}