import java.util.Random;

class Gasoline extends Oil {
	private int price;
	private double vat;
	
	public Gasoline(int price, String company) {
		super(company, "gasoline");
		this.price = price;
		this.vat = (double) ((new Random()).nextInt(30) + 1) / 100;
	}
	
	@Override
	int getOilPrice() {
		return price;
	}
	
	@Override
	public void setOilPrice(int price) {
		this.price = price;
		double priceInStore = price + price * vat;
		super.setPriceInStore(priceInStore);
	}
	
	@Override
	public String toString() {
		return String.format(
			super.toString() +
			"supply price: %s",
			this.price);
	}
}