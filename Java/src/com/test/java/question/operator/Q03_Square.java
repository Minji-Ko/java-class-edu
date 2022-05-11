package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03_Square {

	public static void main(String[] args) throws Exception {

//		요구사항] 사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력하시오.
//		- 사각형 넓이 = 가로 * 높이
//		- 사각형 둘레 = 가로 * 2 + 높이 * 2
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("너비(cm) : ");
		String input1 = reader.readLine();
		int width = Integer.parseInt(input1);
		
		System.out.print("높이(cm) : ");
		String input2 = reader.readLine();
		int height = Integer.parseInt(input2);		//형변환을 바로하면 의미단위가 정확히 보임
		
		
//		System.out.print("너비(cm) : ");
//		String input1 = reader.readLine();
//		
//		System.out.print("높이(cm) : ");
//		String input2 = reader.readLine();
//		
//		int width = Integer.parseInt(input1);
//		int height = Integer.parseInt(input2);		//형변환을 따로 하면 정리된 느낌
		
		
		System.out.println();
		System.out.printf("사각형의 넓이는 %dcm²입니다.%n", width * height);
		System.out.printf("사각형의 둘레는 %dcm입니다.%n", (width + height) * 2);
			
	}
}
