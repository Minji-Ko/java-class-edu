package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05_Number {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자를 전달하면 '짝수' 혹은 '홀수'라는 단어를 반환하는 메소드를 선언하시오.
//		- String getNumber(int)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 : ");
		String input = reader.readLine();
		int n = Integer.parseInt(input);
		
		String result;
		result = getNumber(n);
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
//		System.out.printf("입력하신 숫자 \'%d\'는(은) \'%s\'입니다.\n", n, result);
						
							//TODO 문자열에 \'이 아닌 '만 입력해도 정상작동되는 이유?
	}
	
	public static String getNumber(int num) {

		return (num % 2 == 0)? "짝수" : "홀수"; 
	
	}
}

//		설계]
//		- 1. 숫자 입력받기 > BufferedReader > 안내메시지 출력***** > String input에 저장 > int n으로 형변환
//		- 2. getNumber 메소드 생성하기 > return 값은 "홀수" 또는 "짝수"(n % 2 == 0) 
//		- 3. String result 선언하기
//		- 4. n을 인자로 getNumber 메소드 선언하고 result에 저장
//		- 5. 출력하기 > printf("입력하신 숫자 \'%d\'는(은) \'%s\'입니다.\n", n, result)