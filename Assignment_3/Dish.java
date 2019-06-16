class Dish {
	private int tableNum;
	private String name;
	private String tool;
	private int time;
	
	public int getTableNum() {
		return tableNum;
	}
	public String getName() {
		return name;
	}
	public String getTool() {
		return tool;
	}
	public int getTime() {
		return time;
	}
	
	public Dish(int tableNum, String name) {
		this.tableNum = tableNum;
		this.name = name;
		
		setTool(name);
		setTime(this.tool);
	}
	
	void setTool(String name) {
		switch (name) {
			case "ramen":
			case "stew":
				this.tool = "pot";
				break;
			case "friedrice":
				this.tool = "fryingpan";
				break;
			case "ovenroast":
				this.tool = "oven";
				break;
		}
	}
	
	void setTime(String tool) {
		switch (tool) {
			case "pot":
				this.time = 350;
				break;
			case "fryingpan":
				this.time = 500;
				break;
			case "oven":
				this.time = 1300;
				break;
		}
	}
}