import java.text.*;
import java.util.ArrayList;

class Chef extends Thread {
	private String name;
	private Kitchen kitchen;
	private ArrayList<Dish> dishes;
	
	public Chef(String name, Kitchen kitchen, ArrayList<Dish> dishes) {
		this.name = name;
		this.kitchen = kitchen;
		this.dishes = dishes;
	}
	
	public void run() {
		for (Dish dish: dishes) {
			int time = dish.getTime();
			
			switch (dish.getTool()) {
				case "oven":
					kitchen.useOven();
					break;
				case "fryingpan":
					kitchen.useFriedPan();
					break;
				case "pot":
					kitchen.usePot();
					break;
			}
			
			Thread.sleep(time);
			
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(System.currentTimeMillis());
			
			System.out.printf("Table #%d / %s is completed by %s. %s\n", dish.getTableNum(), dish.getName(), this.name, date);
			
			switch (dish.getTool()) {
				case "oven":
					kitchen.releaseOven();
					break;
				case "fryingpan":
					kitchen.releaseFriedPan();
					break;
				case "pot":
					kitchen.releasePot();
					break;
			}
			
		}
		
		
	}
}