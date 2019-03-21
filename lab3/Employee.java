class Employee {
	private String name;
	private int age;
	private String position;
	private int salary;
	private int vacationDays = 20;
	
	Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	Employee(String name, int age, String position, int salary) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
	}
	Employee(String name, int age, String position, int salary, int vacationDays) {
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.vacationDays = vacationDays;
	}
	
	public String getName() { return this.name; }
	public int getAge() { return this.age; }
	public String getPosition() { return this.position; }
	public int getSalary() { return this.salary; }
	public int getVacationDays() { return this.vacationDays; }
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setPosition(String position) { this.position = position; }
	public void setSalary(int salary) { this.salary = salary; }
	public void setVacationDays(int vacationDays) { this.vacationDays = vacationDays; }
	
	public boolean equals(Object obj) {
		if(obj instanceof Employee){
			Employee employee = (Employee)obj;
			return (this.name.equals(employee.name)) && (this.age == employee.age);
		}
		return false;
	}
	
	public String toString() {
		return String.format("Name: %s, Age: %d, Position: %s, Salary: %d, VacationDays: %d", this.name, this.age, this.position, this.salary, this.vacationDays);
	}
	
	public boolean vacation(int days) {
		int leftVacationDays = this.vacationDays - days;
		if (leftVacationDays < 0) {
			System.out.println("남은 휴가 일수가 부족합니다.");
			return false;
		} else {
			this.vacationDays = leftVacationDays;
			System.out.printf("휴가를 사용하였습니다. 남은 휴가 일 수 : %d\n", leftVacationDays);
			return true;
		}
	}
}