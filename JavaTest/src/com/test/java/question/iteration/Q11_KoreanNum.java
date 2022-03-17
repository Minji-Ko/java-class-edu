package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11_KoreanNum {
	
	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자를 10개 입력받아 한글로 변환 후 출력하시오.

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String print = "";
		
		int i = 1;
		
		while(i <= 10) {
			
			System.out.print("숫자(1~9) : ");
			String num = reader.readLine();
			
			print += setKorean(num);
			
			i++;
		}
	
		System.out.println(print);
	}

	public static String setKorean(String num) {
		
		if(num.equals("1")) {
			return "일";
		} else if(num.equals("2")) {
			return "이";
		} else if(num.equals("3")) {
			return "삼";
		} else if(num.equals("4")) {
			return "사";
		} else if(num.equals("5")) {
			return "오";
		} else if(num.equals("6")) {
			return "육";
		} else if(num.equals("7")) {
			return "칠";
		} else if(num.equals("8")) {
			return "팔";
		} else if(num.equals("9")) {
			return "구";
		}
		
		return "";
	}

}

//		설계]
//  	1. 초기식, 문자열변수 선언
//		2. 반복문 만들기
//			2.1 조건식 > (count > 10)
//			2.2 숫자 입력받기 
//			2.3 한글로 변환하기 
//			2.3 문자열에 누적하기
//			2.2 증감식
//		3. 출력하기
//			3. 문자열 출력하기
