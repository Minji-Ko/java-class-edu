package com.test.java;

import java.util.Calendar;

public class Item34 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] 현재 시각의 tick얻기(Calendar 클래스) (2022. 3. 17. 오전 12:54:18)

		Calendar now = Calendar.getInstance();
		long nowTick = now.getTimeInMillis();
	}
}
