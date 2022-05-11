package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q22_CommonDivisor {

	public static void main(String[] args) throws Exception {
		
		//요구사항] 숫자를 2개 입력받아 각각의 약수와 두 숫자의 공약수를 구하시오.
		//- 공약수: 둘 이상의 정수에 공통된 약수
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자: ");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자: ");
		int num2 = Integer.parseInt(reader.readLine());
		
		
		//약수 구하기
		System.out.printf("%d의 약수: ", num1);
		getDivisor(num1, num1);
		
		System.out.printf("%d의 약수: ", num2);
		getDivisor(num2, num2);
		
		
		//공약수 구하기
		System.out.printf("%d와 %d의 공약수:", num1, num2);
		getDivisor(num1, num2);
			
//		if(num1 >= num2) {   
//			getDivisor(num1, num2);
//		} else {
//			getDivisor(num2, num1);
//		}	 							//공약수를 구할 때, 작은수 큰수를 구분할 필요가 없음**
		
	} //main

	public static void getDivisor(int numBig, int numSmall) {
		
		for(int i=1; i<=numSmall; i++) {	
			if ((numBig % i == 0) && (numSmall % i == 0)) {
				System.out.printf(" %d,", i);
			}
		}
		System.out.println("\b ");  //"\b"다음에 덮어쓸 문자가 있어야 함!!		
	}
	
}

	
//	설계] 
//	1. 숫자 입력받기 > int num
//	2. 약수 구하기 > 메소드 
//		2.1 12 = 1, 2, 3, 4, 6, 12 -> num 까지 나눠보고 나머지0인수
//		2.2 나머지 0이면 "숫자," 출력
//	3. 공약수 구하기
//		3.1 더 작은수 구하기
//		3.2 8과 12 모두 나머지 0인걸 8,7,6,5..순으로 구하다가 나오면 멈추기
//		3.3 나온 수의 약수 구하기
