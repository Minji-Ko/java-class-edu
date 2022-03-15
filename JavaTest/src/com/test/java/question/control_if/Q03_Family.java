package com.test.java.question.control_if;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03_Family {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 문자 1개를 입력받아 아래와 같이 출력하시오.
//		- f, F → Father
//		- m, M → Mother
//		- s, S → Sister
//		- b, B → Brother
//		- 유효성 검사를 하시오.(위의 문자가 아닌 문자는 예외 처리)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 : ");
		String input = reader.readLine();
		char letter = input.charAt(0);
		
		
		boolean f = (letter == 'f') || (letter == 'F');
		boolean m = (letter == 'm') || (letter == 'M');
		boolean s = (letter == 's') || (letter == 'S');
		boolean b = (letter == 'b') || (letter == 'B');
		
		
		if (f || m || s || b) {
			
			if (f) {
				System.out.println("Father");
				
			} else if (m) {
				System.out.println("Mother");
				
			} else if (s) {				
				System.out.println("Sister");
				
			} else if (b) {
				System.out.println("Brother");
				
			}
			
		} else {
			System.out.println("입력한 문자가 올바르지 않습니다.");
		
		}
	
	}
}

//		설계]
//		1. 문자 1개를 입력받기
//			1.1 Buffered
//			1.2 라벨
//			1.3 char로 형변환 -> charAt(0)
//		2. 문자 검사 > 출력
//			2.1 유효성 검사
//			2.2 if문 처리 else if 2개 
//			2.3 if문 출력 > Father..
//			2.4 유효성 검사 출력 > "입력한 문자가 올바르지 않습니다."
