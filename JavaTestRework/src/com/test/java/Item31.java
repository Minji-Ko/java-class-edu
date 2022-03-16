package com.test.java;

import java.util.Calendar;

public class Item31 {

	public static void main(String[] args) {
		
		//[SUMMARY] 시간 구하기(Calendar 클래스) (2022. 3. 17. 오전 1:19:36)
	
		//2시간 30분 + 40분 = 3시간 10분
		Calendar c1 = Calendar.getInstance();
	
		c1.set(Calendar.HOUR, 2);
		c1.set(Calendar.MINUTE, 30);
		
		c1.add(Calendar.MINUTE, 40);

	}
	
}
