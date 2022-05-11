package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04_EvenOdd {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 입력 횟수(N)와 숫자 N개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("입력 횟수 : ");
		int count = Integer.parseInt(reader.readLine());
		
		int evenNum = 0, evenSum = 0;
		int oddNum = 0, oddSum = 0;
		
		
		for(int i=0; i<count; i++) {
			
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 0) {
				++evenNum;
				evenSum += num;
			} else {
				++oddNum;
				oddSum += num;
			}
		}
		
		System.out.printf("짝수 %d개의 합 : %d%n", evenNum, evenSum);
		System.out.printf("홀수 %d개의 합 : %d%n", oddNum, oddSum);
		
	} //main
}

//		설계]
//		1. 입력횟수 입력받기 > int count 
//		2. 숫자입력받기 > 짝수 홀수? 
//			- 변수 선언 > evenNum, evenSum
//			- for(int i=0; i<count; i++) 
//			- int num = ..
//			- if(num % 2 == 0) { ++evenNum; evenSum += num} else{..}
//		4. 출력
//			- 짝수 evenNum개의 합 : evenSum
//		


