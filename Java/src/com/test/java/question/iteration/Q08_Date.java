package com.test.java.question.iteration;

public class Q08_Date {

	public static void main(String[] args) {
		
//		요구사항] 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.
//		- Calendar 클래스 사용 금지
		
		int year = 2022;
		int month = 3;
		int date = 16;
		
		int totalYear = (year - 1) * 365 + (year / 4) - (year / 100) + (year / 400);
		int totalMonth = getMonth(month); //2월 29일 반영 안됨!! > 2월 28일까지는 윤년이라 +1이 되어있음
		
//		boolean LeafYear = ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) || 
//				(year % 4 == 0) && (year % 100 != 0);
//		if(LeafYear && month <= 2) {
//			totalMonth--;
//		}
		
		
		int totalDay = totalYear + totalMonth + date;
			
		String day = getDay(totalDay);
	
		System.out.printf("%d년 %02d월 %02d일은 %,d일째 되는 날이고 %s요일입니다.", year, month, date, totalDay, day);
		
	}

	public static String getDay(int totalDay) {
		
		String day = "";
		
		if (totalDay % 7 == 1) {
			day = "월";
		} else if (totalDay % 7 == 2) {
			day = "화";
		} else if (totalDay % 7 == 3) {
			day = "수";
		} else if (totalDay % 7 == 4) {
			day = "목";
		} else if (totalDay % 7 == 5) {
			day = "금";
		} else if (totalDay % 7 == 6) {
			day = "토";
		} else if (totalDay % 7 == 0) {
			day = "일";
		}
		
		return day;
	}

	public static int getMonth(int month) {
		
		int totalMonth = 0;
		
		switch (month - 1) {
			case 12:
				totalMonth += 31;
			case 11:
				totalMonth += 30;
			case 10:
				totalMonth += 31;
			case 9:
				totalMonth += 30;
			case 8:
				totalMonth += 31;
			case 7:
				totalMonth += 31;
			case 6:
				totalMonth += 30;
			case 5:
				totalMonth += 31;
			case 4:
				totalMonth += 30;
			case 3:
				totalMonth += 31;
			case 2:
				totalMonth += 28;
			case 1:
				totalMonth += 31;
			default:
				totalMonth += 0;
				break; //month가 1~12가 아닐때 유효성 검사
		}
		
		return totalMonth;
	}
}

//		설계]
//		1. 오늘 날짜 얻어오기
//		1.몇일째인지 구하기
//			- 365일 * (year-1) 
//			- 30일 * (month-1) -> 보정
//				1 31
//				2 28
//				3 31
//				4 30
//				5 31
//				6 30
//				7 31
//				8 31
//				9 30
//				0 31
//				1 30
//				2 31
//				-> 뒤집어서 break없는 switch로 
//			- + date
//			- int totalDay 변수에 누적
//		2.요일 구하기
//			- String day변수에 저장
//			- totalDay % 7 == 1 > 월
//		3.출력하기
//			- "%d년 %d월 %d일은 %,d일째 되는 날이고 %s요일입니다.",..., totalDay, day