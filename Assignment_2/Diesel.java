import java.util.Random;

class Diesel extends Oil {
	private int price;
	private double vat;
	private double envTax;
	
	public Diesel(int price, String company) {
		super(company, "diesel");
		this.price = price;
		this.vat = (double) ((new Random()).nextInt(30) + 1) / 100;
		this.envTax = 500;
	}
	
	@Override
	int getOilPrice() {
		return price;
	}
	
	@Override
	public void setOilPrice(int price) {
		this.price = price;
		double priceInStore = price + envTax + price * vat;
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