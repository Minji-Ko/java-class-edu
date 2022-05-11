package com.test.java.question.array;

public class Q19 {

	public static void main(String[] args) {
		
//		2	7	6
//		9	5	1
//		4	3	8
		
		int[][] nums = new int[3][3]; 
		
		
		//데이터 입력
		int n=1;
		int row = 1;
		int col = 2;
		
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {

				nums[row][col] = n;
				n++;
				
				if(j < 2) {
					row = modifyIndex(--row); 
					col = modifyIndex(++col);	
				} else {
					col = modifyIndex(--col); 					
				}			
			}
		}
		
		
		//데이터 출력
		for(int i=0; i<3; i++) { //문제풀 때 상수쓰기
			for(int j=0; j<3; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int modifyIndex(int num) {
		
		switch(num) {
			case -1:
				return 2;
			case 3:
				return 0;
			default:
				return num;
		}
	}
}

//		0 	1 	2  3
//	0	2	7	6
//	1	9	5	1
//	2	4	3	8

//(1,2) -> (0,3)=(0,0) -> (-1,1)=(2,1) ->(왼)
//(2,0) -> (1,1) -> (0,2) -> (왼)
//(0,1) -> (-1,2)=(2,2) -> (1,3)=(1,0)


//	0 	1 	2
//0	6	2	7
//1	1	9	5
//2	8	4	3














