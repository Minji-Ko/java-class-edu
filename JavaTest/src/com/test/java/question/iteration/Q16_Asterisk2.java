package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16_Asterisk2 {

	public static void main(String[] args) throws Exception {
		
//		    *
//		   **
//		  ***
//		 ****
//	    *****
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행: ");
		int num = Integer.parseInt(reader.readLine());
		
		
		for (int i=1; i<=num; i++) {
			
			//공백출력
			for(int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			
			//별 출력
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}

	} //main
}
