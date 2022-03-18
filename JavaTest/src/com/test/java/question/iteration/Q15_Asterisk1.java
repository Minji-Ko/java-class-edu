package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15_Asterisk1 {

	public static void main(String[] args) throws Exception {
		
//		*****
//		 ****
//		  ***
//		   **
//		    *
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("행: ");
		int num = Integer.parseInt(reader.readLine());
		
		
		for (int i=1; i<=num; i++) {
			
			//공백출력
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			
			//별 출력
			for(int j=0; j<=num-i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	
	}
}

//  공백   1->0. 2->1 3->2
// 	별	  1->5, 2->4
