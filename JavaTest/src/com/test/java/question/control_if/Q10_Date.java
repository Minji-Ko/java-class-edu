package com.test.java.question.control_if;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q10_Date {
	
	public static void main(String[] args) throws Exception {
		
//		요구사항] 날짜를 입력받아 아래의 조건에 맞게 결과를 출력하시오.	
//		- 입력받은 날짜가 평일이면 해당 주의 토요일을 알아낸다.
//		- 입력받은 날짜가 일요일이면 아무것도 안한다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("년 : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(reader.readLine()) - 1;
		System.out.print("일 : ");
		int date = Integer.parseInt(reader.readLine());
		
		
		Calendar day = Calendar.getInstance();
		
		day.set(year, month, date);
		
		
		int dayWeek = day.get(Calendar.DAY_OF_WEEK);
		
		if (2 <= dayWeek && dayWeek <=6) { //(월~금)
			
			System.out.println("입력하신 날짜는 '평일'입니다.");
			
			moveDate(day, dayWeek);
		
		} else {
			
			System.out.println("입력하신 날짜는 '휴일입니다.");
			
			if (dayWeek == 7) {
				moveDate(day, dayWeek);
				
			} else {
				System.out.println("결과가 없습니다.");
			}
			
		}
	}

	public static void moveDate(Calendar day, int dayWeek) {
		
		System.out.println("해당주의 토요일로 이동합니다.");
		
		day.add(Calendar.DATE, 7 - dayWeek);
		System.out.printf("이동한 날짜는 '%tF'입니다.\n", day);
	
	}
}

//		설계]
//		1. 날짜 입력받기
//			1.1 Buffered
//			1.2 안내메시지 > 년 :
//			1.3 int에 형변환 후 저장
//			1.4 2-3 2번 더 반복
//			1.5.Calendar day 클래스 선언
//			1.6 set(int, int, int)
//		2. 날짜 검사하기 (요일!= 일요일)
//			2.1 if( day.get(Calendar.dayofWeek..))!= 0) 
//				add(Calendar.DATE, 6-dayofweek)
//			2.2 else if (day.get(Calendar.dayofWeek..))!= 6) > 토요일
//			2.3 else > 출력




