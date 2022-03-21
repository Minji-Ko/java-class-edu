package com.test.java.question.array;

public class Q18 {

	public static void main(String[] args) {
		
//		1	2	3	4	5
//		16	17	18	19	6
//		15	24	25	20	7
//		14	23	22	21	8
//		13	12	11	10	9

		int[][] nums = new int[5][5]; 
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 

		int n = 1;
		
		for(int i=0; i<=2; i++) {
			for(int j=i; j<5-i; j++) {
				nums[i][j] = n;
				nums[j][4-i] = n+4-2*i;
				n++;
			}
			n+= 11 - (6 * i);
		}
		

		n = 10;
				
		for(int i=4; i>=3; i--) {
			for(int j=i; j>=5-i; j--) {
				nums[i][j-1] = n;
				nums[j][4-i] = n+2*i-5;
				n++;
			}
			n+= 8;
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
//		(0,0)(0,1)(0,2)(0,3)(0,4)
//		(0,4)(1,4)(2,4)(3,4)(4,4)
//		(1,1)(1,2)(1,3)
//		(1,3)(2,3)(3,3)
//		(2,2) 
                         
//		(4,3)(4,2)(4,1)(4,0)(3,0)(2,0)(1,0)                 
//		(3,2)(3,1)(2,1)
         
// 		for(i:0~2) > for(j:i~4-i){nums[i][j]}, for(j:){nums[j][i]}








