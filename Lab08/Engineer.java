class Engineer extends Employee {
	double rate;
	
	Engineer(String name, int employeeNum) {
		super(name, employeeNum);
		this.name = name;
		this.employeeNum = employeeNum;
		this.rate = 4.0;
		this.department = "Engineering";
	}
	
	@Override
	public double getPaid() {
		double pay = workHrs * rate;
		this.salary = pay;
		return pay;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Engineer) {
			Employee employee = (Engineer)obj;
			return super.equals(employee);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format(
			"%s" +
			"Dept: %s\n",
			super.toString(), this.department
		);
	}
}