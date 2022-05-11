package com.test.java.question.array;

public class Q15 {

	public static void main(String[] args) {
		
//		1	2	3	4	10
//		5	6	7	8	26
//		9	10	11	12	42
//		13	14	15	16	58
//		28	32	26	40	136
		
		int[][] nums = new int[5][5]; 
		
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 
		int n = 1;
			
		for(int i=0; i<4; i++) { 
			for(int j=0; j<4; j++) {
				nums[i][j] = n;
				nums[i][4] += n;
				nums[4][j] += n;
				nums[4][4] += n;
				
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
