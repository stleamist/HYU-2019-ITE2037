class Manager extends Employee {
	int officeNum;
	String team;
	
	Manager(String name, int employeeNum, int officeNum, String team) {
		super(name, employeeNum);
		this.department = "Management";
		
		this.officeNum = officeNum;
		this.team = team;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Manager) {
			Manager manager = (Manager)obj;
			
			if (
				super.equals(manager) &&
				this.officeNum == manager.officeNum &&
				this.team.equals(manager.team)
			) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format(
			"%s\n" +
			"Location: %s, Office: %s",
			super.toString(), this.department, this.officeNum
		);
	}
}