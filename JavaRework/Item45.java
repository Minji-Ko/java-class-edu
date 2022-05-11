package com.test.java;

import java.util.Calendar;

public class Item45 {

	public static void main(String[] args) {
		
		//[SUMMARY] 특정 월의 마지막날 마지막구하기 (2022. 3. 17. 오전 2:11:55)
		Calendar c1 = Calendar.getInstance();
		
		c1.set(2022, 1, 1); //2022년 2월 1일
		
		System.out.println(c1.getActualMaximum(Calendar.DATE));
		
	}
}
