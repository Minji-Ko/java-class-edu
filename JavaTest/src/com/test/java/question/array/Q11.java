package com.test.java.question.array;

public class Q11 {

	public static void main(String[] args) {
		
			//	25	24	23	22	21
			//	20	19	18	17	16
			//	15	14	13	12	11	
			//	10	9	8	7	6
			//	5	4	3	2	1
			
			int[][] nums = new int[5][5]; 
			
			
			//데이터 입력 > 문제의 요구사항에 따라 수정 
			int n = 25;
			
			for(int i=0; i<5; i++) { 
				
				for(int j=0; j<5; j++) {
					nums[i][j] = n;
					n--;
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
