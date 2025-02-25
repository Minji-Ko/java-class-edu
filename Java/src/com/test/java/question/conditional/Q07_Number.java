package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07_Number {

	public static void main(String[] args) throws Exception {
		
//		 5개를 입력받아 짝수와 홀수의 개수를 출력하시오.
		
		int num1 = input();
		int num2 = input();
		int num3 = input();
		int num4 = input();
		int num5 = input();
		
		
		int even = getEven(num1);
		even += getEven(num2);
		even += getEven(num3);
		even += getEven(num4);
		even += getEven(num5);
		
		int odd = 5 - even;
			
//		int even = 0, odd = 0;
//		
//		if (num1 % 2 == 0) {
//			++even;
//		} else {
//			++odd;
//		}
//		if (num2 % 2 == 0) {
//			++even;
//		} else {
//			++odd;
//		}
//		if (num3 % 2 == 0) {
//			++even;
//		} else {
//			++odd;
//		}
//		if (num4 % 2 == 0) {
//			++even;
//		} else {
//			++odd;
//		}
//		if (num5 % 2 == 0) {
//			++even;
//		} else {
//			++odd;
//		}
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", even, odd);
		System.out.printf("홀수가 짝수보다 %d개 더 많습니다.\n", (odd - even > 0)? odd - even : 0);
	
	} //main

	public static int getEven(int num) {
		
		int even = 0;
		
		if (num % 2 == 0) {
			++even;
		} 
		
		return even;
	}

	public static int input() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력 : ");
		int num = Integer.parseInt(reader.readLine());
		
		return num;
	}


}

//		설계]
//		1. 숫자 5개를 입력받기
//			1.1 int input() 메소드 생성
//			1.2 Buffered..
//			1.3 라벨 출력 
//			1.4 int 형변환
//			1.5 int num = 메소드 호출 x 5회  
//	
//		2. 짝수 홀수 개수 > 출력
//			2.1 짝, 홀수 변수 선언 및 초기화 int even = 0;
//			2.2 if문 > 출력
//				- if (num1 % 2 == 0) { ++even }
//				- else > ++odd
//				- 5번 반복 > 메소드?
//			2.3 출력
//				- "짝수는 %d개 홀수는 %d개 입력했습니다.\n", even, odd
//				- 홀수가 짝수보다 1개 더 많습니다.\n, (odd-even > 0)? odd-even : 0
//				

