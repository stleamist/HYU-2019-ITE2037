package oos.lab05;

import java.util.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.lang.Math;
import oos.lab05.Collection.*;

class Program {
	public static void main(String[] args) {
		Employee employee = new Employee("Kim", 4500.0);
		Calendar date = Calendar.getInstance(); // 프로그램 내에서의 현재 날짜
		Calendar contractDate = (Calendar)date.clone(); // 객체를 딥 카피하는 Object 클래스의 내장 메소드
		int incentiveMonth = -1; // 인센티브를 받는 달은 입사 n년차가 되는 달에 초기화된다. 
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); // Calendar 객체를 문자열로 포맷해주는 포매터
		
		System.out.println("계약일: " + formatter.format(contractDate.getTime()));
		printEmployeeInfo(employee);
		
		while(true) {
			employee.receiveSalary();
			
			if (date.get(Calendar.MONTH) == contractDate.get(Calendar.MONTH)) { // 입사 n년차에 접어들었을 때
				incentiveMonth = (int)(Math.random() * (11 + 1)); // 0-11 중 임의의 정수 (0월부터 시작함)
				
				if (getDiffYear(contractDate, date) != 0) { // 입사 1년차가 아니라면
					int rate = (int)(Math.random() * (10 + 1)); // 0-11 중 임의의 정수
					employee.increaseYearlySalary(rate);
					System.out.printf("%d년차 연봉이 %d%% 인상되었습니다.\n", getDiffYear(contractDate, date) + 1, rate);
				}
			}
			
			if (date.get(Calendar.MONTH) == incentiveMonth) { // 이번 달이 인센티브를 받는 달이라면
				employee.receiveSalary();
				System.out.printf("%d년차 %d월에 인센티브를 받았습니다.\n", getDiffYear(contractDate, date) + 1, date.get(Calendar.MONTH) + 1);
				incentiveMonth = -1; // 인센티브를 받았으므로 다음 입사 연차가 오기 전까지 인센티브를 받는 달의 값을 -1로 변경해 둔다.
			}
			
			if (employee.getBalance() >= 20000.0) {
				System.out.println("날짜: " + formatter.format(date.getTime()));
				printEmployeeInfo(employee);
				break;
			} else {
				date.add(Calendar.MONTH, 1);
			}
		}
	}
	
	/**
	 * 두 개의 Calendar 객체를 인자로 받아 두 날짜의 연도 차이를 반환합니다.
	 * @param startCal 시작 날짜
	 * @param endCal 종료 날짜
	 */
	private static int getDiffYear(Calendar startCal, Calendar endCal) {
		int diffYear = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
		if (endCal.get(Calendar.MONTH) < startCal.get(Calendar.MONTH)) {
			diffYear -= 1;
		}
		return diffYear;
	}
	
	/**
	 * Employee 객체의 이름과 연봉, 월급, 재산을 출력합니다.
	 * @param employee Employee 객체
	 */
	private static void printEmployeeInfo(Employee employee) {
		System.out.printf("이름: %s\n", employee.getName());
		System.out.printf("연봉: %4f\n", employee.getYearlySalary());
		System.out.printf("월급: %4f\n", employee.getMonthlySalary());
		System.out.printf("재산: %4f\n", employee.getBalance());
	}
}