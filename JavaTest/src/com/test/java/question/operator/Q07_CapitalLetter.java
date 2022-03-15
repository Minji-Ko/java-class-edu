package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07_CapitalLetter {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 영문 소문자 1글자 입력받은 후 대문자로 변환해서 출력하시오.
//		- 대문자와 소문자의 문자 코드값의 관계
//		생각하기]
//		- 소문자가 아닌 글자를 입력한다면?
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("문자 입력 : ");
		String input = reader.readLine();
		char letter = input.charAt(0);
		System.out.printf((letter >= 97 && letter <= 122) ? "소문자 \'%c\'의 대문자는 \'%c\'입니다.%n"
															: "소문자를 입력해주세요."
															, letter
															, (char)(letter - 32)); 		
															//TODO 형변환을 안해도 실행되는 이유?
																		
	}
}

/*
 	바로 코딩 시작(x) > 무조건 설계!!!!!!! 
 	
 	
 	문제 풀기 위한 프로세스..
	1. 라벨을 출력한다. > "소문자 입력: "
	2. BufferedReader를 생성한다. > throws Exception을 적는다.
	3. 소문자를 입력받는다. > reader.readLine()	
	4. 3의 반환값(문자열)을 받아서 char형으로 바꾼다. > 입력값.charAt(0)
	5. 4의 문자 코드값을 얻는다. > 형변환
	6. 5의 문자 코드값에서 -32 > 대문자의 문자 코드값
	7. 6의 문자 코드값을 char로 형변환
	8. 콘솔에 "소문자 'a'의 대문자는 'A'입니다." 출력한다.

*/

