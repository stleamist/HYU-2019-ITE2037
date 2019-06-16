import java.util.*;

class Table {
	private int tableNum;
	private ArrayList<Dish> dishSet;
	
	public Table() {
		this.dishSet = new ArrayList<Dish>(4);
	}
	
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	
	public ArrayList<Dish> getDishSet() {
		return dishSet;
	}
}