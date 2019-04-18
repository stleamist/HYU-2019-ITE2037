class Employee {
	String name;
	int employeeNum;
	String department;
	
	Employee(String name, int employeeNum) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.department = "No Dept";
	}
	
	public String getDepartment() {
		return this.department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee employee = (Employee)obj;
			if (
				this.name.equals(employee.name) &&
				this.employeeNum == employee.employeeNum
			) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format(
			"Name: %s\n" +
			"Emp#: %d",
			this.name, this.employeeNum
		);
	}
}