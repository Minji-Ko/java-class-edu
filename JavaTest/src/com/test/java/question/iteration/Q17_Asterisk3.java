package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17_Asterisk3 {

	public static void main(String[] args) throws Exception {
	
//		요구사항] 삼각형모양 별찍기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("행: ");
		int num = Integer.parseInt(reader.readLine());
		
		for(int i=0; i<num; i++) {
			
			//공백찍기
			for(int j=0; j<num-i; j++) {
				System.out.print(" ");
			}
			
			//별찍기(열)
			for(int k=0; k<(2*i)+1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}

//		설계]
//		1. 행의 갯수 입력받기 > num
//		2. for문  
//			2.1 행수 -> int i=0; i<num; i++
//			2.2 공백 개수 -> num - 행
//				- 1행 -> 4
//				- 2행 -> 3개
//				- 5행 -> 0개
//			2.3 열의 별개수 -> 2 * 행 + 1
//				- 1행 -> 1
//				- 2행 -> 3
//				- 3행 -> 5 = 2 * 3 -1