package com.test.java.question.iteration;

public class Q19_Multiplication {

	public static void main(String[] args) {
		
//		요구사항] 구구단을 출력하시오.
		
//		//2~5단 출력
//		for(int i=1; i<=9; i++) {
//			
//			for(int j=2; j<=5; j++) {
//				System.out.printf("%d x %d = %2d\t", j, i, j * i);
//			}
//			System.out.println();
//		}
//
//		System.out.println();
//		
//		//6~9단 출력
//		for(int i=1; i<=9; i++) {
//			
//			for(int j=6; j<=9; j++) {
//				System.out.printf("%d x %d = %2d\t", j, i, j * i);
//			}
//			System.out.println();
//		}
		
		for(int dan=2; dan<=6; dan+=4) {
			
			for(int i=1; i<=9; i++) {
				
				for(int j=dan; j<=dan+3; j++) {
					System.out.printf("%d x %d = %2d\t", j, i, j * i);
				}
				System.out.println();
			}
	
			System.out.println();
		}
		
	}
}
//		설계]
//		1. 반복문 2,3,4,5 루프
//			- 1 > 2, 3, 4, 5 
//			- 2 > 2, 3, 4, 5
//			- 9 > 2, 3, 4, 5
//		2. 반복문 6,7,8,9루프
