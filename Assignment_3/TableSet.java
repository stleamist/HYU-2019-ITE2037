class TableSet {
	private Table[] tableSet;
	
	public TableSet() {
		this.tableSet = new Table[5];
		
		for (int i = 0; i < 5; i++) {
			this.tableSet[i] = new Table();
		}
	}
	
	void addToTable(int index, int tableNum, String name) {
//		tableSet[index].dishSet
	}
	
	public Table[] getTableSet() {
		return tableSet;
	}
}