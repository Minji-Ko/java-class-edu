package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10 {

	public static void main(String[] args) throws Exception {

//		요구사항] 입력받은 금액을 한글로 출력하시오.
//		- 입력 범위(원): 0 ~ 99,999,999
//		- 배열 + 문자열
		
//		입력] 금액(원): 12345678
//		출력] 일금 일천이백삼십사만오천육백칠십팔원
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("금액(원): ");
		char[] amount = reader.readLine().toCharArray();
		
		//한글로 변환
		for(int i=0; i<amount.length; i++) {
			amount[i] = replaceNum(amount[i]);
		}
		
		//숫자 출력
		System.out.print("일금 ");
		for(int i=0; i<amount.length; i++) {
				
			int print = (amount.length - i) % 4;
					
			if(print == 0) {
				System.out.print((amount[i] != '\0') ? amount[i] + "천" : "");
			} else if (print == 3){
				System.out.print((amount[i] != '\0') ? amount[i] + "백" : "");
			} else if (print == 2) {
				System.out.print((amount[i] != '\0') ? amount[i] + "십" : "");
			} else {
				System.out.print((amount[i] != '\0') ? amount[i] + "만" : "만");
			}
			
		}
		System.out.print("\b원");
		
	
	}
	
	public static char replaceNum(char num) {
		
		switch(num) {
			case '0':
				return '\0';
			case '1':
				return '일';
			case '2':
				return '이';
			case '3':
			case '4':
				return '사';
			case '5':
				return '오';
			case '6':
				return '육';
			case '7':
				return '칠';
			case '8':
				return '팔';
			case '9':
				return '구';
		}
		return '\0';
	}
}

//		설계]
//		1. 입력받기
//		2. for문으로 각 문자 추출 > charArray
//		3. for문
//			- length() % 4 
//			- 4개단위로
//			- " ""십"백천 더하기