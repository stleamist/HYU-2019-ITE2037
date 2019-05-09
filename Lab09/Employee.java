public class Employee {
	String name;
	int workDay;
	int workHrs;
	
	Employee(String name) {
		this.name = name;
		this.workDay = workDay;
		this.workHrs = workHrs;
	}
	
	public String getName() {
		return this.name;
	}
	public int getWorkDay() {
		return this.workDay;
	}
	public int setWorkHrs() {
		return this.workHrs;
	}
	
	void addWorkDay() {
		this.workDay += 1;
	}
	void addWorkHrs(int hrs) {
		this.workHrs += hrs;
	}
}