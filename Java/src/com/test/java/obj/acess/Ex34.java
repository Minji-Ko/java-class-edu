package com.test.java.obj.acess;

import java.util.Calendar;

public class Ex34 {

	public static void main(String[] args) {
		
		/*
		 
		 	1. Person 클래스 정의
		 		- 이름
		 		- 나이
		 		- 성별
		 		- 생일(**)
		 		- 아빠(**)
		 		- 엄마(**)
		 	2. 몇명의 Person 객체 생성
		 		
		 	
		 */
		
		Person father = new Person();
		father.setName("홍기철");
		father.setAge(50);
		father.setGender("m");
		father.setBirthday(1965, 5, 10);
		
		Person mother = new Person();
		mother.setName("호호호");
		mother.setAge(46);
		mother.setGender("f");
		mother.setBirthday(1969, 8, 20);
		
		Person hong = new Person();
		
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setGender("m");
		
//		Calendar birthday = Calendar.getInstance();
//		birthday.set(1995, 2, 24);
//		hong.setBirthday(birthday);
		
		hong.setBirthday(1995, 3, 24);
		System.out.println(hong.getBirthday());
		
		hong.setFather(father);  
		hong.setMother(mother);
		
		hong.hello();
		hong.info();
		
		
	} //main
	
} //Ex34

class Person {
	
	//클래스(객체)의 멤버 변수
	//- 멤버 변수
	//- 필드
	//- 상태 
	//- (객체) 데이터			//도메인(Domain) 정의 > 업무 지식 
	private String name;	//이름: 한글 2~5자 이내
	private int age;		//나이: 만 0~140세 
	private String gender;	//성별: m, f
	
	private Calendar birthday;	//생일
	private Person father; 		//아빠
	private Person mother; 		//엄마
	
	
	//클래스 멤버 메소드
	//- 객체의 행동 > 객체 자신의 데이터를 활용해서 행동
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (checkName(name)) {
			this.name = name;
		} else {
			System.out.println("올바르지 않은 이름입니다.");
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age >= 0 && age <=140) { //분량이 적어서 메소드로 안뺌, 유효성검사가 한줄로 끝나서 옳은 지를 검사
			this.age = age;
		} else {
			System.out.println("올바르지 않은 나이입니다.");
		}
	}
	public String getGender() {
		return gender; 	
	}
	public void setGender(String gender) {
		if (gender.equals("m")|| gender.equals("f")) {
			this.gender = gender;			
		} else {
			System.out.println("올바르지 않은 성별입니다.");
		}
	}
//	public Calendar getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(Calendar birthday) {
//		this.birthday = birthday;
//	}
	public String getBirthday() {
		return String.format("%tF", this.birthday);
	}
	public void setBirthday(int year, int month, int date) {
		Calendar birthday = Calendar.getInstance(); 
		birthday.set(year, month-1, date); //***month-1
		this.birthday = birthday;
	}

	
	public Person getFather() {
		return father;
	}
	public void setFather(Person father) {
		this.father = father;
	}
	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}
	
	
	
	private boolean checkName(String name) {
		if(name.length() <2 || name.length() > 5) {
			return false;
		}
		
		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i); //TODO 글자가 길면 변수명을 의미없이해도 괜찮은가? (2022. 3. 25. 오전 12:12:24)
			if(c < '가' || c > '힣') {
				return false;
			}
		}
		return true;
	}
	
	//인사
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.\n", this.name);
	}
	//자기소개
	public void info() {
		System.out.printf("반갑습니다. 저는 %s이고 %d살입니다.\n생일은 %tF입니다.\n"
							+ "아빠는 %s이고, 생일은 %s입니다.\n"
							+ "엄마는 %s이고, 생일은 %s입니다.\n"
								, this.gender.equals("m") ? "남자": "여자" //내부적으로 원본은 m,f으로 하기로 했으므로 수정하면 안됨
								, this.age
								, this.birthday
								, this.father.getName()
								, this.father.getBirthday()
								, this.mother.getName()
								, this.mother.getBirthday());  //클래스의 객체정보를 가져올 때 멤버변수말고 메소드로 가져오기!!!
	}
	
}
