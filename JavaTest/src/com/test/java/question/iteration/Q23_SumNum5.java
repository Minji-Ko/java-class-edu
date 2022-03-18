package com.test.java.question.iteration;

public class Q23_SumNum5 {

	public static void main(String[] args) {
		
		//요구사항] 아래와 같이 출력
		// 1 ~ 10 : 55
		// 1 ~ 20 : 210
		// ...
		// 1 ~ 100 : 5050
		int sum = 0;
		
		for(int i=0; i<100; i=i+10) {
			
			for(int j=1+i; j<=10+i; j++) {
				sum += j;
			}
			
			System.out.printf("1 ~ %3d : %4d\n", i+10, sum);
		}
	}
}

//		설계]
//		1. 바깥쪽 for문 
//			1.1 1~10라벨 출력 > 증감식이 10씩 증가
//			1.2 안쪽for문 돌고 sum출력 > 엔터
//		2. 안쪽 for문
//			2.1 초기식을 바깥쪽 i만큼 더하기
//			2.2.sum 값에 누적
