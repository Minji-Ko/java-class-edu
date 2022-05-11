package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06_Tax {

	public static void main(String[] args) throws Exception {

//		요구사항] 사용자의 한달 수입을 입력받아 세후 금액을 출력하시오.
//		- 세금 : 수입의 3.3%
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한달 수입 금액(원) : ");
		String input = reader.readLine();
		long income = Long.parseLong(input);
		
		final double TAX_RATE = 0.033; 
		long tax = (long)(income * TAX_RATE);   //버림		
		
		System.out.printf("세금(원) : %,d원%n", tax);
		System.out.printf("세후 금액(원) : %,d원%n", income - tax);
		
	
//		double tax1 = (income * TAX_RATE);   		
		
//		System.out.printf("세금(원) : %,.0f원%n", tax1);   //소수점 이하 반올림
//		System.out.printf("세후 금액(원) : %,.0f원%n", income - tax1);

	
	}
}
