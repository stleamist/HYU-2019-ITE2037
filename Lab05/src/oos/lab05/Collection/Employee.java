package oos.lab05.Collection;

public class Employee {
	private String name;
	private Double yearly_salary;
	private Double monthly_salary;
	private Double balance;
	
	/**
	 * Employee 객체를 생성합니다.
	 * @param name 이름
	 * @param yearly_salary 연봉
	 */
	public Employee(String name, Double yearly_salary) {
		this.name = name;
		this.yearly_salary = yearly_salary;
		
		this.monthly_salary = yearly_salary / 12;
		this.balance = 0.0;
	}
	
	/**
	 * Employee 객체의 이름을 반환합니다.
	 */
	public String getName() { return this.name; }
	/**
	 * Employee 객체의 연봉을 반환합니다.
	 */
	public Double getYearlySalary() { return this.yearly_salary; }
	/**
	 * Employee 객체의 월급을 반환합니다.
	 */
	public Double getMonthlySalary() { return this.monthly_salary; }
	/**
	 * Employee 객체의 자산을 반환합니다.
	 */
	public Double getBalance() { return this.balance; }

	/**
	 * Employee 객체의 연봉을 byPercent만큼 인상합니다.
	 * @param byPercent 인상률
	 */
	public void increaseYearlySalary(int byPercent) {
		this.yearly_salary *= 1 + ((double)byPercent / 100);
		this.monthly_salary = this.yearly_salary / 12;
	}
	/**
	 * Employee 객체의 월급을 자산에 더합니다.
	 */
	public void receiveSalary() {
		balance += monthly_salary;
	}
}