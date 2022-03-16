package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06_SumNum2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int start = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int end = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for(int i=start; i<=end; i++) {
			
			if(i % 2 != 0) { //홀수
				sum += i;
				System.out.print(i);
				
				if(i==end) {
					System.out.printf(" = %d\n", sum);
					break;
				}
				
				System.out.print(" - ");
			} else { 
			
				sum += -i;
				System.out.print(i);
				
				if(i==end) {
					System.out.printf(" = %d\n", sum);
					break;
				}
				
				System.out.print(" + ");
			}
			
		}
	}
}

//		설계]
//		2. 출력하기
//			- 부호바꾸기 > -
//			- if(i % 2 != 0) {-출력}else {+}
