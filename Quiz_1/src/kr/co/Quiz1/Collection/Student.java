package kr.co.Quiz1.Collection;

import java.lang.Math;

public class Student {
	private String name;
	private int studentNumber;
	private int korean;
	private int math;
	private int english;
	private double avg;
	
	public Student(String name, int korean, int math, int english) {
		this.name = name;
		this.studentNumber = 2018000000 + (int)(Math.random() * 9999 + 1);
		this.korean = korean;
		this.math = math;
		this.english = english;
		this.avg = (double)(korean + math + english)/3;
	}
	
	public Student(Student student) {
		this.name = student.name;
		this.studentNumber = student.studentNumber;
		this.korean = student.korean;
		this.math = student.math;
		this.english = student.english;
		this.avg = student.avg;
	}
	
	public static void makeRank(Student[] studentList) { // 오름차순 정렬
		for (int i = 0; i < studentList.length; i++) {
			studentList[i] = new Student(studentList[i]); // 깊은 복사
		}
		
		Student tempStudent;
		
		for (int i = studentList.length - 1; i > 0; i--) { // 버블 정렬
			for (int j = 0; j < i; j++) {
				if (studentList[j].studentNumber > studentList[j+1].studentNumber) {
					tempStudent = studentList[j];
					studentList[j] = studentList[j+1];
					studentList[j+1] = tempStudent;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return String.format(
			"이름: %s 학번: %d\n" +
			"국어: %s 수학: %s 영어: %s\n" +
			"평균: %f",
			this.name, this.studentNumber, grade(this.korean), grade(this.math), grade(this.english), avg
		);
	}
	
	String grade(int score) {
		if (score >= 90) { return "A"; }
		else if (score >= 80) { return "B"; }
		else if (score >= 70) { return "C"; }
		else if (score >= 60) { return "D"; }
		else if (score >= 50) { return "E"; }
		else { return "F"; }
	}
}