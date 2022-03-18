package com.test.java.question.iteration;

public class Q21_PerfectNumber {

	public static void main(String[] args) {
		
//		요구사항] 1부터 100사이의 완전수를 구하시오.
//		- 완전수: 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수
//		- 약수: 어떤 수나 식을 나누어 나머지가 없이 떨어지는 수
	

		for(int i=2; i<=100; i++) {
			
			String print = String.format("%d = [", i);
			
			int sum = 0;
			
			//약수 구해서 전부 더하기
			for(int j=1; j<i; j++) {
				if(i % j == 0) {
					print += String.format("%d, ", j);
					sum += j;
				}
			}
			
			print += String.format("\b\b]");
			
			if(sum == i) {
				System.out.println(print);
			}
		}
		
	}
}
//	1.반복문
//		1.1. 약수구하기 
//			- sum에 누적하기 
//		1.2. 자기 자신 제외하고 더하기
//		1.3. 자기자신과 같으면 출력
		 