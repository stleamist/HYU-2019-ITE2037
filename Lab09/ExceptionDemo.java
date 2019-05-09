import java.util.*;

class ExceptionDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee("Lee");
		
		int day = 1;
		
		while (true) {
			try {
				System.out.print(day + "일차 근무 시간을 입력하세요: ");
				int workHrs = sc.nextInt();
				if (workHrs < 0) {
					throw new NegativeException();
				} else if (workHrs == 0) {
					throw new Exception("Program Exit");
				} else if (workHrs > 24) {
					throw new TooMuchStuffException(workHrs);
				} else {
					emp.addWorkHrs(workHrs);
					emp.addWorkDay();
					System.out.println("이름 : " + emp.getName());
					System.out.println("누적 근무 시간 : " + emp.workHrs);
					System.out.println("No Exception has been occurred");
					day += 1;
				}
			} catch (NegativeException e) {
				System.out.println(e.getMessage());
			} catch (TooMuchStuffException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getInputNum() + " occurs " + e.getClass().getName());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} finally {
				System.out.println("End of try-catch statement");
			}
		}
	}
}