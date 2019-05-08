class Manager extends Employee {
	double overtimeRate;
	double rate;
	int regularHrs;
	
	Manager(String name, int employeeNum) {
		super(name, employeeNum);
		this.rate = 5.0;
		this.overtimeRate = 8.0;
		this.regularHrs = 40;
		this.department = "Management";
	}
	
	@Override
	public double getPaid() {
		double pay;
		if (workHrs < 40) {
			pay = workHrs * rate;
		} else {
			int overtimeHrs = workHrs - regularHrs;
			pay = (regularHrs * rate) + (overtimeHrs * overtimeRate);
		}
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