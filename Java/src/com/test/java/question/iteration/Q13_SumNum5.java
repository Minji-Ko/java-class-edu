package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q13_SumNum5 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 최대 9자리 정수를 입력받아 각자리의 홀수 숫자합과 짝수 숫자합을 구하시오.
//		- 9자리 이하 숫자만 입력하시오.
//		- Math.pow() 메소드 사용(제곱값 구하는 메소드)
//		- Math.pow(10, 2) → 100
//		- Math.pow(10, 3) → 1000
//		- Math.pow(10, 4) → 10000
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		int evenSum = 0;
		int oddSum = 0;
		
		for (int i=0; i<9; i++) {
			//각자리 숫자 구하기
			int n = (int)(num / Math.pow(10, i)) % 10;
			
			//각자리 숫자의 합
			if (n % 2 == 0) {
				evenSum += n;
			} else {
				oddSum += n;
			}
		} 
		
		System.out.printf("짝수의 합 : %d\n", evenSum);
		System.out.printf("홀수의 합 : %d\n", oddSum);
		
	}
}

//		설계]
//		1. 최대 정수 9자리 입력받기
//		2. 짝수의 합, 홀수의 합 변수선언  
//		3. 각자리 숫자를 분리
//			- for문 선언  -> 0~8
//			- num / 10^8 -> 9번째 자리수
//			- (num / 10^7) % 10 -> 8번째
//			- (num / 10^6) % 10 -> 7번째
//			- (num) % 10 -> 1번째
//		4. 각자리 숫자가 홀수인지 짝수인지 검사하여 더하기
//			- if (자리수값 % 2 ==0) {짝수에 더하기} else {홀수에 더하기}
//		5. 출력하기
