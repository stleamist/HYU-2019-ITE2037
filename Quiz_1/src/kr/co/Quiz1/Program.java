package kr.co.Quiz1;

import kr.co.Quiz1.Collection.*;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생 수를 입력하세요: ");
		int numberOfStudents = scanner.nextInt();
		
		Student[] studentList = new Student[numberOfStudents];
		
		for (int i = 0; i < numberOfStudents; i++) {
			String name;
			int korean;
			int math;
			int english;
			
			System.out.print("학생 이름을 입력하세요: ");
			name = scanner.next();
			
			System.out.print("국어 성적을 입력하세요: ");
			korean = scanner.nextInt();
			
			System.out.print("수학 성적을 입력하세요: ");
			math = scanner.nextInt();
			
			System.out.print("영어 성적을 입력하세요: ");
			english = scanner.nextInt();
			
			Student student = new Student(name, korean, math, english);
			studentList[i] = student;
		}
		
		Student.makeRank(studentList);
		
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println(studentList[i].toString());
		}
	}
}