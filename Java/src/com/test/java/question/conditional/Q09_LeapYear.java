package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09_LeapYear {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 년도를 입력받아 해당 년도가 '평년' 인지 '윤년' 인지 출력하시오.
//		- a. 년도를 4로 나눈다.
//			- 떨어지면 b 검사
//			- 떨어지지 않으면 "평년"
//		- b. 년도를 100으로 나눈다.
//			- 떨어지면 c 검사
//			- 떨어지지 않으면 "윤년"
//		- c. 년도를 400으로 나눈다.
//			- 떨어지면 "윤년"
//			- 떨어지지 않으면 "평년"
//		- Calendar 클래스 사용 금지
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년도 입력 : ");
		int year = Integer.parseInt(reader.readLine());
		
		if (year >= 0) {
			
			if (year % 4 == 0) {
				
				if (year % 100 == 0) {
					
					if (year % 400 == 0) {
						System.out.printf("%d년은 '윤년'입니다.", year);
						
					} else {
						System.out.printf("%d년은 '평년'입니다.", year);						
					
					}
					
				} else {
					System.out.printf("%d년은 '윤년'입니다.", year);
					
				}
				
			} else {
				System.out.printf("%d년은 '평년'입니다.", year);
			
			}
			
		} else {
			System.out.println("년도를 정확하게 입력해주세요.");
		}
		
	}
	
	
	
}


//평년? 2월 28일까지 있는 해
//윤년? 2월 29일까지 있는 해 **** 
//윤달? > 음력(1달 = 30일) > 간헐적 같은 달 x2번 반복 
//윤초? > 초를 조정

//> 공전주기에 따르면 4년마다 +1
//> 100년마다 -1
//> 400년마다 +1

//		설계]
//		1. 년도 입력받기
//			1.1 buffered
//			1.2 라벨 출력 > 년도 입력 :
//			1.3 int year에 형변환 후 저장
//		2. 년도 검사 > 출력
//			2.1 유효성 검사 >= 0
//			2.2 유효성 검사 출력
//			2.3 년도 검사
//				- if (year % 4 == 0) {..} else {평년}
//				- .. if (year % 100 == 0) {..} else {윤년}
//				- .... if(year % 400 == 0) {윤년} else {평년}