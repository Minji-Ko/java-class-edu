package com.test.java;

import java.util.Calendar;

public class Item27 {

	public static void main(String[] args) {
		
		//[SUMMARY] 날짜시간 표현하기(형식 문자) (2022. 3. 15. 오전 12:40:48)
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("%tF\n", now); //2022-03-14 **********
		System.out.printf("%tT\n", now); //17:45:03 **********
		System.out.printf("%tA\n", now); //월요일
	}
}
