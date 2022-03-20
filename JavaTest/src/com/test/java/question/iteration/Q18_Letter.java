package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q18_Letter {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 삼각형 모양 알파벳찍기
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행: ");
		int row = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<row; i++) {
			
			for(int j=1; j<row-i; j++) {
				System.out.print(" ");
			}	
			for(char c=97; c<=97+i; c++) {
				System.out.print(c);
			}
			for(char c=(char)(97+i); c>=97; c--) {
				System.out.print(c);				
			}
		
			
			System.out.println();
		}
	}
}

//		설계]
//		1. 행 입력받기 -> 0 <= i < num
//		2. 공백 찍기  4-i
//			- 1행 -> 4
//			- 2행 -> 3
//			- 5행 -> 0
//		3. 열 찍기 -> 97<= <97+i
//			2.1 순서대로
//			2.2 역순으로
//			- aa  > 97,97 > char형 변수
//			- abba > 97,97+1,97+1,97
//			- abccba > 97, 97+1, 97+2 ...

