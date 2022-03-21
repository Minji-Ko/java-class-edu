package com.test.java.question.array;

public class Q12 {

	public static void main(String[] args) {

		//	1	6	11	16	21
		//	2	7	12	17	22
		//	3	8	13	18	23	
		//	4	9	14	19	24
		//	5	10	15	20	25
		
		int[][] nums = new int[5][5]; 
		
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 
		int n = 1;
			
		for(int j=0; j<5; j++) {
			for(int i=0; i<5; i++) { 
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

