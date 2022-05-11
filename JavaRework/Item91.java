package com.test.java;

public class Item91 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 정적멤버 만들기(static) (2022. 3. 27. 오후 9:33:07)
		
		Student.setSchool("역삼 중학교");
		
	}	
}

class Student {
	
	private String name;
	private static String school; 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) { 
		Student.school = school;  					//Studnet.(***)
	}
	
	public String info() {
		return String.format("이름: %s, 학교: %s"
								, this.name
								, Student.school);  //Student.(***)
	}
}










