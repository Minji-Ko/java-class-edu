package com.test.java.question.iteration;

public class Q24_SumNum6 {

	public static void main(String[] args) {
		
		//요구사항] 아래와 같이 출력
		// 1 ~ 10 : 55
		// 11 ~ 20 : 155
		// ...
		// 91 ~ 100 : 955
		
		for(int i=0; i<100; i=i+10) {
			
			int sum = 0;
			
			for(int j=i+1; j<=i+10; j++) {
				sum += j;
			}

			System.out.printf("%2d ~ %3d : %3d\n", i+1, i+10, sum);
		}

	}
}

//		설계]
//		1. 바깥쪽 for > 초기식 0, 조건식<100, 증감식 10
//			1.1 int sum = 0;
//			1.2 안쪽 for문 돈 후 출력 
//		2. 안쪽 for > 초기식 1+i; 조건식 i+10; 증감식1
//			2.2 sum에 누적
