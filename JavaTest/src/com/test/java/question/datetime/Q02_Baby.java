package com.test.java.question.datetime;

import java.util.Calendar;

public class Q02_Baby {

	public static void main(String[] args) {
		
//		요구사항] 오늘 태어난 아이의 백일과 첫돌을 출력하시오.
		
		Calendar dday = Calendar.getInstance();
		
		dday.add(Calendar.DATE, 100);
		System.out.printf("백일: %tF%n", dday);
		
		dday = Calendar.getInstance();
		dday.add(Calendar.YEAR, 1);
		System.out.printf("첫돌: %tF%n", dday);
	}
}

//		설계]
//		1. 현재 시각 얻어오기 > Calendar now = Calendar.getInstance()
//		3. add() > date상수에 100더하기 
//		4. 출력하기 > "백일: %tF%n"
//		5. now 현재시각으로 초기화하기 > getInstance()
//		6. add() > year상수에 1더하기
//		7. 출력하기 > "첫돌: %tF%n"