package com.test.java;

import java.util.Calendar;

public class Item29 {

	public static void main(String[] args) {
		
		//[SUMMARY] 특정 시간 전후 표현하기(Calendar 클래스) (2022. 3. 17. 오전 1:05:21)
	
		Calendar birthday = Calendar.getInstance();
		
		birthday.set(1995, 4, 10);
		birthday.add(Calendar.DATE, 100); //백일잔치
		
		birthday.set(1995, 4, 10);		//초기화***
		birthday.add(Calendar.YEAR, 1); //돌잔치
		
		birthday.set(1995, 4, 10);		
		birthday.add(Calendar.DATE, -266); //수정일
		
	}
}
