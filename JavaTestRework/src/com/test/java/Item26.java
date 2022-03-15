package com.test.java;

import java.util.Calendar;

public class Item26 {

	public static void main(String[] args) {
		
		//[SUMMARY] 날짜시간 표현하기(Calendar 클래스) (2022. 3. 15. 오전 12:39:14)
		
		Calendar c1 = Calendar.getInstance();
		
		System.out.println(c1.get(Calendar.YEAR));			//2022. 년도
		System.out.println(c1.get(Calendar.MONTH));			//2.	월(0~11) **
		System.out.println(c1.get(Calendar.DATE));			//14.	일(날짜)
		System.out.println(c1.get(Calendar.HOUR));			//5.	시(12H)
		System.out.println(c1.get(Calendar.MINUTE));		//23. 	분
		System.out.println(c1.get(Calendar.SECOND));		//11.	초
		System.out.println(c1.get(Calendar.MILLISECOND));	//460.	밀리초(1/1000)
		System.out.println(c1.get(Calendar.AM_PM));			//1.	오전(0), 오후(1) **
		
		System.out.println(c1.get(Calendar.DAY_OF_YEAR));	//73. 	일(올해)
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));	//14.	일(이번달)
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));	//2.	일(요일) 1(일)~7(토) **
		
		System.out.println(c1.get(Calendar.WEEK_OF_YEAR));	//12.	주(올해)
		System.out.println(c1.get(Calendar.WEEK_OF_MONTH));	//3.	주(이번달) 목요일 포함
		
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));	//17.	시(24H)
	
	}
}
