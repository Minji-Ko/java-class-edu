package com.test.java;

import java.util.Calendar;

public class Item28 {

	public static void main(String[] args) {
		
		//[SUMMARY] 특정 시각 표현하기(Calendar 클래스) (2022. 3. 17. 오전 12:54:59)
		
		Calendar birthday = Calendar.getInstance();
		
		birthday.set(Calendar.YEAR, 1995);
		birthday.set(Calendar.MONTH, 4);
		birthday.set(Calendar.DATE, 10);
		birthday.set(Calendar.HOUR, 10);
		birthday.set(Calendar.MINUTE, 30);
		birthday.set(Calendar.SECOND, 0);
		
		birthday.set(1995, 4, 10);
		birthday.set(1995, 4, 10, 10, 30, 0);

	}
}
