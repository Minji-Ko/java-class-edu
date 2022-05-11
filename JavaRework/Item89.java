package com.test.java;

import java.util.Calendar;

public class Item89 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 멤버변수 만들기(참조형) (2022. 3. 27. 오후 9:10:30)
		
		Person father = new Person();
		
		father.setName("홍기철");
		father.setBirthday(1965, 5, 10);
		
		Person me = new Person();
		
		me.setName("홍길동");
		me.setBirthday(1995, 3, 24);
		me.setFather(father);  
		
		
		me.info();
	}	
}

class Person {
	
	private String name;
	private Calendar birthday;
	private Person father;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public Calendar getBirthday() {
		return birthday;
	}	
	public void setBirthday(int year, int month, int date) {
		Calendar birthday = Calendar.getInstance();		//내부에서 객체 생성
		birthday.set(year, month - 1, date);
		this.birthday = birthday;
	}
	
	public void setFather(Person father) {
		this.father = father;
	}

	public void info() {
		System.out.printf("저는 %s이고, 생일은 %tF입니다.\n"
							+ "아빠는 %s이고, 생일은 %tF입니다.\n"
								, this.name
								, this.birthday
								, this.father.getName()
								, this.father.getBirthday()); //멤버변수 말고 메소드로(***)
	}
	
	
	
	
}
