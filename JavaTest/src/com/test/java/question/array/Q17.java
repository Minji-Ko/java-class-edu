package com.test.java.question.array;

public class Q17 {

	public static void main(String[] args) {
		
//		1	2	4	7	11
//		3	5	8	12	16
//		6	9	13	17	20
//		10	14	18	21	23
//		15	19	22	24	25
		
		int[][] nums = new int[5][5]; 
		
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 
		int n = 1;
		
		for(int i=0; i<5; i++) { 
			for(int j=0; j<=i; j++) {
				nums[j][i-j] = n;
				n++;	
			}
		}
		
		for(int i=5; i<9; i++) { 
			for(int j=i-4; j<=4; j++) {
				nums[j][i-j] = n;
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
//		설계]
//		nums[i][j]
//		- i+j = 0 > 1 > 2 ... > 8 
//		-	(0,0)
//		- 	(0,1)(1,0)
//		- 	(0,2)(1,1)(2,0)
//		-	...
//		-	(1,4)(2,3)...(4,1)
//		- 	(4,4)
		
		
		
		
		
		
		
