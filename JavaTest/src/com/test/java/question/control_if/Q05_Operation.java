package com.test.java.question.control_if;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05_Operation {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자 2개와 연산자 1개를 입력받아 연산 과정과 결과를 출력하시오.
//		- 정수만 입력하시오.(유효성 검사 필요없음)
//		- 나머지 연산 결과는 소수이하 첫째자리까지 출력 하시오.
//		- 연산자는 산술 연산자(+, -, *, /, %)만 입력하시오.  

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		System.out.print("연산자 : ");
		String input = reader.readLine();
		char operator = input.charAt(0);
		
		
		boolean validation = (operator == '+') 
							|| (operator == '-') 
							|| (operator == '*') 
							|| (operator == '/') 
							|| (operator == '%');
		
		if (validation) {
			
			if (operator == '+') {
				System.out.printf("%,d %c %,d = %,d", num1, operator, num2, num1 + num2);
				
			} else if (operator == '-') {
				System.out.printf("%,d %c %,d = %,d", num1, operator, num2, num1 - num2);
				
			} else if (operator == '*') {
				System.out.printf("%,d %c %,d = %,d", num1, operator, num2, num1 * num2);
				
			} else if (operator == '/') {
				System.out.printf("%,d %c %,d = %,.1f", num1, operator, num2, (double)num1 / num2);
				
			} else if (operator == '%') {
				System.out.printf("%,d %c %,d = %,d", num1, operator, num2, num1 % num2);
			}
			
		} else {
			System.out.println("연산이 불가능합니다.");
		}
		
	}
	
}

//		설계]
//		1. 숫자 2개와 연산자 1개를 입력받기
//			1.1 Buffered..
//			1.2 라벨 출력 
//			1.3 int num1로 형변환 해서 저장
//			1.4 2-3 int num2 저장
//			1.5 2-3 String에 저장 > char? // equals()보다 == 로 비교하는게 가독성 높음
//		2. 연산 과정과 결과를 출력
//			2.1 연산자 유효성 검사 >
//			2.2 if문 
//				- if 
//				- else if 4개  > 나눗셈 연산결과는 소수점 1자리 출력 > 천자리 표시
//			2.3 유효성 검사 출력 > "연산이 불가능합니다."
