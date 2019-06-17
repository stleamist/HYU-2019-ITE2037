import java.util.*;
import java.io.*;

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
	
	static TableSet loadingData() {
		TableSet tableSet = new TableSet();
		int index = -1;
		int tableNum = -1;
		
		try {
			File file = new File("OrderSheet.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = "";
			while((line = bufferedReader.readLine()) != null){
				
				if (line.startsWith("Table")) {
					String tableNumString = line.substring(line.length() - 1);
					tableNum = Integer.parseInt(tableNumString);
					index += 1;
				} else {
					tableSet.addToTable(index, tableNum, line);
				}
			}
			
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e){
			System.out.println(e);
		}
		
		return tableSet;
	}
	
	static void devideDishes() {
		for (int i = 0; i < 5; i++) {
			ArrayList<Dish> dishes = (i % 2 == 0) ? dishes_lee : dishes_kang;
			dishes.addAll(tbset.getTableSet()[i].getDishSet());
		}
	}
}