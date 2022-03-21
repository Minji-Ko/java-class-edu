package com.test.java.question.array;

public class Q10 {

	public static void main(String[] args) {
		
		//	1	2	3	4	5
		//	10	9	8	7	6
		//	11	12	13	14	15
		//	20	19	18	17	16
		//	21	22	23	24	25
		
		int[][] nums = new int[5][5]; 
		
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 
		int n = 1;
		
		for(int i=0; i<5; i++) { 
			
			if(i % 2 == 0) {
				for(int j=0; j<5; j++) {
					nums[i][j] = n;
					n++;
				}
			} else {
				for(int j=4; j>=0; j--) {
					nums[i][j] = n;
					n++;
				}
			}
		}
		
		
		
		
//		for(int i=0; i<5; i=i+2) { 
//			for(int j=0; j<5; j++) {
//				nums[i][j] = n;
//				n++;
//			}
//			n += 5;
//		} 
//		
//		n = 6;
//		
//		for(int i=1; i<4; i=i+2) { 
//			for(int j=4; j>=0; j--) {
//				nums[i][j] = n;
//				n++;
//			}
//			n += 5;
//		} 
		


		
		//데이터 출력 > 절대 수정 금지!!!
		for(int i=0; i<5; i++) { //문제풀 때 상수쓰기
			for(int j=0; j<5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
	}
}

//		설계] 데이터 입력
		
				
				
				
				
				
				