package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04_Career {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 근무 년수를 입력받아 아래와 같이 출력하시오.
//		- 1 ~ 4년차 : 초급 개발자
//		- 5 ~ 9년차 : 중급 개발자
//		- 10년차 이상 : 고급 개발자
//		- 유효성 검사를 하시오.(1 미만 입력 예외 처리)
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("근무 년수 : ");
		int year = Integer.parseInt(reader.readLine());
				
		
		if (year >= 1) {
			
			if (1 <= year && year <= 4) {
				System.out.printf("%d년차 초급 개발자입니다.\n", year);
				System.out.printf("앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다. \n", 5 - year);

			} else if (5 <= year && year <= 9) {
				System.out.printf("%d년차 중급 개발자입니다.\n", year);
				System.out.printf("당신은 %d년전까지 초급 개발자였습니다.\n", year - 4);				
				System.out.printf("앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다. \n", 10 - year);
				
			} else {
				System.out.printf("%d년차 고급 개발자입니다.\n", year);
				System.out.printf("당신은 %d년전까지 중급 개발자였습니다.\n", year - 9);					
			}
			
		} else {
			System.out.println("입력한 값이 올바르지 않습니다. 1이상의 값을 입력하시오.");
		}
		
	}
}


//		설계]
//		1. 근무 년수 입력받기
//			1.1 Buffer
//			1.2 라벨 > "근무 년수 : "
//			1.3 int year로 형변환해서 저장
//		2. 년차 구분하기 > 출력
//			2.1 유효성 검사 (1이상인지)
//			2.2 if문
//				- if (1~4)
//				- else if (5~9)
//				- else 
//			2.3 if문 출력
//				- if "year년차 초급 개발자입니다.\n앞으로 5-year년..."
//				- else if "... year-4년전까지.. 앞으로 10-year"
//				- else "...year-9년전까지.."
//			2.4 유효성 검사 출력 > "입력한 값이 올바르지 않습니다. 1이상의 값을 입력하시오."