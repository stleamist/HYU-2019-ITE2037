import java.util.*;

class Restaurant {
	static TableSet tbset;
	static ArrayList<Dish> dishes_lee;
	static ArrayList<Dish> dishes_kang;
	
	public static void main(String[] args) throws InterruptedException {
		tbset = loadingData();
		dishes_lee = new ArrayList<Dish>();
		dishes_kang = new ArrayList<Dish>();
		Kitchen kitchen = new Kitchen();
		
		devideDishes();
		
		Chef lee = new Chef("Lee", kitchen, dishes_lee);
		Chef kang = new Chef("Kang", kitchen, dishes_kang);
		
		lee.start();
		kang.start();
	}
	
	static void devideDishes() {
		
	}
}