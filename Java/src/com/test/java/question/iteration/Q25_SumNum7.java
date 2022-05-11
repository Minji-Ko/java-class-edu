package com.test.java.question.iteration;

public class Q25_SumNum7 {

	public static void main(String[] args) {
		
//		요구사항] 아래와 같이 출력
//		- 1 + 2 + 4 + 7 + 11 + 16 + 22 + 29 + 37 + 46 + 56 + 67 + 79 + 92 = 469
//		- 마지막 숫자가 100이 넘기 전까지 출력하시오.
	
		int sum = 0;
		int num = 1;
		
		for(int i=1; num<100; i++) {
			
			System.out.printf("%d + ", num);
			sum += num;
			num += i;
		}
		
		System.out.printf("\b\b= %d", sum);
	
	}
}
//		설계]
//		1. num 변수 선언 -> 1로 초기화
//		2. for문 (int i=1; num<100; i++)
//			2.1 "num변수 + "출력 
//			2.2 누적 sum
//			2.2 num += i;
//		3.  "\b\b= num" 출력