class EmployeeManager {
	public static void main(String[] args) {
		Employee james = new Employee("James Wright", 42, "Manager", 20000);
		Employee amy = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
		Employee peter = new Employee("Peter Coolidge", 32, "Assistant manager", 12000, 7);
		Employee john = new Employee("John Doe", 22, "Engineer", 10000, 10);
		
		Employee array[] = { james, amy, peter, john };
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		Employee dongkyu = new Employee("Dongkyu Kim", 21);
		
		System.out.printf("Is %s equals to %s?: %b\n", dongkyu.getName(), amy.getName(), dongkyu.equals(amy));
		
		james.vacation(10);
		peter.vacation(10);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}