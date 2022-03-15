package com.test.java.question.datetime;

import java.util.Calendar;

public class Q01_Now {
 
	public static void main(String[] args) {
		
//		요구사항]현재 시간을 출력하는 메소드 선언하시오.
//		void nowTime()
//		현재 시간을 24시간으로 출력하시오.
//		현재 시간을 오전/오후(12시간)로 출력하시오.
		nowTime();
	}

	public static void nowTime() {
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("현재 시간 : %02d시 %02d분 %02d초%n"
							, now.get(Calendar.HOUR)
							, now.get(Calendar.MINUTE)
							, now.get(Calendar.SECOND));
		
		String ampm = (now.get(Calendar.AM_PM) == 0) ? "오전" : "오후";
		
		System.out.printf("현재 시간 : %s %02d시 %02d분 %02d초%n"
							, ampm
							, now.get(Calendar.HOUR_OF_DAY)
							, now.get(Calendar.MINUTE)
							, now.get(Calendar.SECOND));
	}
}

//		설계]
//		main()
//		1. nowTime()메소드 선언 및 호출 
//		nowTime()
//		1. 현재 시각 얻어오기 > Calendar now = Calendar.getInstance();
//		2. 24시간으로 출력 
//		3. 12시간으로 출력 > %s %d시 %d분 %d초 
//			> 오전, 오후 변수 ampm 따로 생성  -> ampm == 0 ? "오전" : "오후"
//			> HOUR_OF_DAY, MINUTE, SECOND