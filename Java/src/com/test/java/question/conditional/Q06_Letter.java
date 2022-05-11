package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06_Letter {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 영문자 1개를 입력받아 대/소문자 변환을 한 뒤 출력하시오.
//		- 유효성 검사를 하시오.(영문자만 입력 가능)
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 : ");
		String input = reader.readLine();
		char letter = input.charAt(0);
		
		
		boolean lowerCase = (97 <= letter) && (letter <= 122);
		boolean upperCase = (65 <= letter) && (letter <=90);
		
		
		if(lowerCase || upperCase) {
			
			if(lowerCase) {
				System.out.printf("'%c'의 대문자는 '%c'입니다.", letter, (char)(letter - 32));
				
			} else if (upperCase) {
				System.out.printf("'%c'의 소문자는 '%c'입니다.", letter, (char)(letter + 32));	
			}
			
		} else {
			System.out.println("영문자만 입력하시오.");
		}
		
	}
}

//		설계]
//		1. 영문자 1개를 입력받기
//			1.1 Buffered..
//			1.2 라벨 출력 
//			1.3 String > char 형변환
//		2. 대소문자 변환 > 출력
//			2.1 영문자 유효성 검사 > if(65<= c <=90 || 97<= c <=122)
//			2.2 유효성 검사 출력 > 영문자만 입력하시오.
//			2.3 if문 > 출력
//				- if (65<= c <=90)  > 'c'의 소문자는 'c+32' 입니다.
//				- else > 'c'의 대문자는 'c-32;입니다.

