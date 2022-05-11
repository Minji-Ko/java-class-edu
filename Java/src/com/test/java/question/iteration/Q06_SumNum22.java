package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06_SumNum22 {
	
	public static void main(String[] args) throws Exception {

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int startNum = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int endNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		int sign = 1;
		
	
		for (int i=startNum; i<=endNum ; i++) {
			
			if (sign > 0) {
				if (i == startNum) {
					System.out.printf("%d", i);
				} else {
					System.out.printf(" + %d", i);
				}
				
			} else if (sign < 0) {
				System.out.printf(" - %d", i);
			} 
			sum += sign * i;
			sign *= (-1); 

		}
		
		System.out.printf(" = d%\n", sum);
		

	}

}
