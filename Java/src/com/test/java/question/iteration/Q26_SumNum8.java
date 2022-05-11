package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q26_SumNum8 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 + 34 + 55 + 89 = 232
//		- 마지막 숫자가 100이 넘기 전까지 출력하시오.
		
//		int sum = 0;
//		
//		int n1 = 1;
//		int n2 = 1;
//		
//		while(true) {
//			
//			//출력 > 누적 > 값 증가시키기
//			if (n1 > 100) {
//				break;
//			}
//			System.out.printf("%d + ", n1);
//			sum += n1;
//			n1 += n2;
//			
//			//100이 넘어서 종료할지 판단
//			if (n2 > 100) {
//				break;
//			}
//			System.out.printf("%d + ", n2);
//			sum += n2;
//			n2 += n1;
//			
//		}
//		
//		System.out.printf("\b\b= %d", sum);
		
		
		
		int a = 0;		
		int b = 1;			
		int sum = 0;	
		
		while(b<100) {
			System.out.printf("%d + ", b);
			sum += b;
			
			int temp = a+b;
			a = b;
			b = temp;
		}
		
		System.out.printf("\b\b= %d", sum);
		
	}
}

//	설계]
//	1. 반복문 > 숫자 만들기
//		- n1=1 ->(+n2) 2 -> (+n2)5
//		- n2=	1  -> (+n1) 3 -> (+n1) 8
//		- n1 출력 n1+=n2 > n2 출력 n2+=n1 > n1출력 ..
//		- 
//	2. 100넘는지 검사 > 멈추기
//	3. 합 누적
//	4. 출력