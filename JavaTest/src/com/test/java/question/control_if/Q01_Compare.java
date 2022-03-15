package com.test.java.question.control_if;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01_Compare {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자 2개를 입력받아 큰수와 작은수를 출력하시오.
//		- 숫자 2개를 입력받아 큰수와 작은수를 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
	
		
		if (num1 > num2) {	
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다", num1, num2, num1 - num2);
		
		} else if (num1 < num2) {
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다", num2, num1, num2 - num1);
			
		} else {
			System.out.println("두 숫자는 동일합니다.");
		}
	}
}

//		설계]
//		1. 숫자 2개를 입력
//			1.1 BufferedReader
//			1.2 라벨 > "첫번째 숫자 : "
//			1.3 int num1 변수 생성 > 형변환해서 저장
//			1.4 2-3 반복
//		2. 큰수와 작은수 비교
//			2.1 if (num1 > num2) {큰수 num1 작은수 num2, num1-num2}
//			2.2 else if (num1 < num2) {큰수 num2 작은수 num1, num2-num1}
//			2.3 else {동일}
//		3. 출력 > 2.if문에서 출력