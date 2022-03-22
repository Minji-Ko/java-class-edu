package com.test.java.question.array;

public class Q18_2 {

	public static void main(String[] args) {
		
//		1	2	3	4	5
//		16	17	18	19	6
//		15	24	25	20	7
//		14	23	22	21	8
//		13	12	11	10	9

		int[][] nums = new int[5][5]; 
		
		//데이터 입력 > 문제의 요구사항에 따라 수정 
		
		int n = 1;

		int row = 0;
		int col = 0;
		
		//(0,0) 채우기
		nums[row][col] = n;
		
		//첫번째행 채우기
		for(int j=0; j<nums.length-1; j++) {
			col++;
			n++;
			nums[row][col] = n;
		}
		
		//나머지행 채우기
		for(int i=nums.length-1, k=0; i>0; i--, k++) {
				
			for(int j=0; j<i; j++) {
				
				n++;
				
				if(k % 2 == 0) {
					nums[++row][col] = n;
				} else {
					nums[--row][col] = n;
				}
			}
			
			for(int j=0; j<i; j++) {
				
				n++;
				
				if(k % 2 == 0) {
					nums[row][--col] = n;
				} else {
					nums[row][++col] = n;
				}
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
//		(0,0)(0,1)(0,2)(0,3)(0,4)
//		(0,4)(1,4)(2,4)(3,4)(4,4)
//		(1,1)(1,2)(1,3)
//		(1,3)(2,3)(3,3)
//		(2,2) 
                         
//		(4,3)(4,2)(4,1)(4,0)(3,0)(2,0)(1,0)                 
//		(3,2)(3,1)(2,1)
         
// 		for(i:0~2) > for(j:i~4-i){nums[i][j]}, for(j:){nums[j][i]}



//		1 2
//		4 3
//
//	col++, low++, col--
//
//		1 2 3
//		8 9 4
//		7 6 5
//
//	col++(2), low++(2), col--(2) -
//	low--(1), col++(1)

//		 1  2  3  4
//		12 13 14  5
//		11 16 15  6
//		10  9  8  7

//	col++(3), low++(3), col--(3), 
//	low--(2), col++(2), 
//	low++(1), col--(1)

//		1	2	3	4	5
//		16	17	18	19	6
//		15	24	25	20	7
//		14	23	22	21	8
//		13	12	11	10	9

//	col++(4), low++(4), col--(4), 
//	low--(3) col++(3),
//	low++(2), col--(2)
//	low--(1) col++(1)


//		1	2	3	4	5	6
//		20	21	22	23	24	7
//		19	32	33	34	25	8
//		18	31	36	35	26	9
//		17	30	29	28	27	10
//		16	15	14	13	12	11
	
//	col++(5), low++(5), col--(5), 
//	low--(4), col++(4),
//	low++(3), col--(3)
//	low--(2) col++(2)
//	low++(1) col--(1)







