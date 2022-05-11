package com.test.java.question.array;

public class Q13 {

	public static void main(String[] args) {
		
				//	1	2	3	4	5
				//	6	7	8	9	0
				//	10	11	12	0	0	
				//	13	14	0	0	0
				//	15	0	0	0	0
				
				int[][] nums = new int[5][5]; 
				
				
				//데이터 입력 > 문제의 요구사항에 따라 수정 
				int n = 1;
					
				for(int i=0; i<5; i++) {
					for(int j=0; j<5-i; j++) { 
						nums[i][j] = n;
						n++;
					}
				}
			
				
				//데이터 출력 > 절대 수정 금지!!!
				for(int i=0; i<5; i++) { //문제풀 때 상수쓰기
					for(int j=0; j<5; j++) {
						System.out.printf("%5d", nums[i][j]);
					}
					System.out.println();
				}
	}
}
