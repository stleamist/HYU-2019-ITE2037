import java.lang.Math;

class City {
	private String name;
	private int location_x;
	private int location_y;
	
	public City(String name, int location_x, int location_y) {
		this.name = name;
		this.location_x = location_x;
		this.location_y = location_y;
	}
	
	public City(String name) {
		this.name = name;
		this.location_x = (int)(Math.random() * (360 + 1));
		this.location_y = (int)(Math.random() * (360 + 1));
	}
	
	public String getName() { return this.name; }
	public int getLocation_x() { return this.location_x; }
	public int getLocation_y() { return this.location_y; }
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof City){
			City city = (City)obj;
			if (
				(this.name).equals(city.name) &&
				this.location_x == city.location_x &&
				this.location_y == city.location_y
			) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %d, %d", this.name, this.location_x, this.location_y);
	}
	
	public static double distance(City city1, City city2) {
		return Math.sqrt(Math.pow(city1.location_x - city2.location_x, 2) + Math.pow(city1.location_y - city2.location_y, 2));
	}
}