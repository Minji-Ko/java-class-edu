package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12_369 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 사용자가 입력한 범위의 숫자까지 369 게임 과정을 출력하시오.
//		- 최대 3자리까지만 입력하시오.
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("최대 숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		int i = 1;
		
		while (i <= num) {
			
			do369(i);
			
			i++;
		}
		
	} //main()

	public static void do369(int num) {
			
		int hundreds = num / 100;
		int tens = (num / 10) % 10;
		int units = num % 10;

		
		boolean hundreds369 = (hundreds != 0) && (hundreds % 3 == 0);
		boolean tens369 = (tens != 0) && (tens % 3 == 0);
		boolean units369 = (units != 0) && (units % 3 == 0);
		
		
		if(hundreds369 && tens369 && units369) {
			System.out.print("짝짝짝 ");
			
		} else if (hundreds369 && tens369 && !units369) {
			System.out.print("짝짝 ");
		} else if (hundreds369 && !tens369 && units369) {
			System.out.print("짝짝 ");
		} else if (!hundreds369 && tens369 && units369) {
			System.out.print("짝짝 ");
		
		} else if (hundreds369 && !tens369 && !units369) {
			System.out.print("짝 ");
		} else if (!hundreds369 && tens369 && !units369) {
			System.out.print("짝 ");
		} else if (!hundreds369 && !tens369 && units369) {
			System.out.print("짝 ");
		
		} else {
			System.out.printf("%d ", num);					
		}
		
		
//		if(hundreds369) {
//			
//			if(tens369) {
//				System.out.print("짝");
//			}
//			if(units369) {
//				System.out.print("짝");
//			}
//			
//			System.out.print("짝 ");
//			
//		} else if(tens369) {
//				
//			if(units369) {
//				System.out.print("짝");
//			} 
//			
//			System.out.print("짝 ");
//			
//		} else if(units369) {
//			System.out.print("짝 ");
//		} else {
//			System.out.printf("%d ", num);					
//		}
			
			
		
		
	} //do369
		
//		public static void do369(int num) {
//			
//			int hundreds = num / 100;
//			int tens = (num / 10) % 10;
//			int units = num % 10;
//			
//			if((hundreds != 0) && (hundreds % 3 == 0)) {
//				System.out.print("짝 ");
//			} else {
//				
//				if((tens != 0) && (tens % 3 == 0)) {
//					System.out.print("짝 ");
//				} else {
//					if((units != 0) && (units % 3 == 0)) {
//						System.out.print("짝 ");
//					} else {
//						System.out.printf("%d ", num);
//					}
//				}
//			} 
		
		
} 

//		설계]
//		1. 최대 숫자 입력받기 > int num
//		2. 반복문 만들기
//			2.1 초기식 int i = 1;
//			2.2 while(i <=num){}
//			2.3 숫자 검사 >  String clap(int num) 메소드 
//			2.4 print출력
//			2.5 i % 20 == 0 이면 엔터!
//			2.6 증감식
//		3. clap메소드
//			3.1 일, 십, 백의 자리 나누기 > int units, tens, hundreds
//			3.2 백의자리부터 중첩으로 3으로 나눈 나머지가 0 이면 ok 
//			3.3 짝 or num 반환
