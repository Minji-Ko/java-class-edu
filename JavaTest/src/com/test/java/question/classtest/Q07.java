package com.test.java.question.classtest;

public class Q07 {

	public static void main(String[] args) {
		
//		요구사항] 학생 클래스의 생성자 오버로딩을 구현하시오.
//		- 상태
//			name: 이름
//			age: 나이
//			grade: 학년
//			classNumber: 반
//			number: 번호
//		- 행동
//			public Student() > 이름("미정"), 나이(0), 학년(0), 반(0), 번호(0)
//			public Student(String name, int age, int grade, int classNumber, int number)
//			public Student(String name, int age)
//			public Student(int grade, int classNumber, int number)
//			String info() > 이름(나이 : 0세, 학년 : 0, 반 : 0, 번호 : 0)
	
		//학생 1
		Student s1 = new Student(); //기본 생성자 호출
		System.out.println(s1.info());

		//학생 2
		Student s2= new Student("홍길동", 13); //오버로딩 생성자 호출
		System.out.println(s2.info());

		//학생 3
		Student s3= new Student(3, 10, 30); //오버로딩 생성자 호출
		System.out.println(s3.info());

		//학생 4
		Student s4= new Student("아무개", 12, 1, 5, 11); //오버로딩 생성자 호출
		System.out.println(s4.info());
	}
}

class Student {
	
	private String name;
	private int age;
	private int grade;
	private int classNumber;
	private int number;
	
	public Student() {
		this("미정", 0, 0, 0, 0);
	}
	
	public Student(String name, int age) {
		this(name, age, 0, 0, 0);	
	}
	
	public Student(int grade, int classNumber, int number) {
		this("미정", 0, grade, classNumber, number);	
	}
	
	public Student(String name, int age, int grade, int classNumber, int number) {
		
		if(name.length() >= 2 || name.length() <= 5) 
			this.name = name;
		
		if(age >= 0) 		
			this.age = age;
		
		if(grade >= 0) 		
			this.grade = grade;
		
		if(classNumber >= 0) 
			this.classNumber = classNumber;
		
		if(number >= 0) 		
			this.number = number;	
	}
	
	public String info() {
				
		return String.format("%s(나이: %s, 학년: %s, 반: %s, 번호: %s)"
								, name
								, (age == 0) ? "미정" : age + "세"
								, (grade == 0) ? "미정" : Integer.toString(grade)
								, (classNumber == 0) ? "미정" : Integer.toString(classNumber)
								, (number == 0) ? "미정" : Integer.toString(number));
	}
}