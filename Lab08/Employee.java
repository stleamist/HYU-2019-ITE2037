public abstract class Employee {
	String name;
	int employeeNum;
	String department;
	int workHrs;
	double salary;
	
	Employee(String name, int employeeNum) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.workHrs = 0;
		this.salary = 0.0;
	}
	
	public String getDepartment() {
		return this.department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getWorkHrs() {
		return this.workHrs;
	}
	
	public void doWork(int hrs) {
		this.workHrs += hrs;
		this.getPaid();
	}
	
	abstract public double getPaid();
	
	public boolean equalPay(Employee emp) {
		return (this.salary == emp.salary);
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
			"Emp#: %d\n",
			this.name, this.employeeNum
		);
	}
}