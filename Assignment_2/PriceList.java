import java.util.Arrays;

class PriceList {
	private Oil[][] priceList;
	private int vertical; // length
	
	private int size;
	
	PriceList() {
		this.vertical = 2;
		this.size = 0;
		this.priceList = new Oil[2][2];
	}
	
	public int getVertical() {
		return this.vertical;
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isFull() {
		return (this.size >= this.vertical);
	}
	public void setPriceList(int i, int j, Oil oil) {
		this.priceList[i][j] = oil;
		oil.setOilPrice(oil.getOilPrice());
	}
	public void extendList(int amount) {
		this.vertical = amount;
		priceList = Arrays.copyOf(priceList, amount);
		
		// Arrays.copyOf()로 2차원 배열의 크기를 늘렸으면 각 열 내의 1차원 배열도 초기화해주어야 한다.
		for (int i = 0; i < priceList.length; i++) {
			if (priceList[i] == null) {
				priceList[i] = new Oil[2];
			}
		}
	}
	public String getRegionInfo(int i) {
		String regionInfo = "";
		for (Oil oil: priceList[i]) {
			regionInfo += oil.toString() + "\n" + "\n";
		}
		return regionInfo;
	}
	public String getEntirePriceList() {
		String entirePriceList = "";
		
		entirePriceList += "\tGasoline\tDiesel\n";
		entirePriceList += "=======================================\n";
		
		for (int i = 0; i < this.size; i++) {
			entirePriceList += "Region #" + i;
			entirePriceList += "\t";
			entirePriceList += priceList[i][0].getPriceInStore();
			entirePriceList += "\t";
			entirePriceList += priceList[i][1].getPriceInStore();
			entirePriceList += "\n";
			entirePriceList += "\n";
		}
		
		return entirePriceList;
	}
}