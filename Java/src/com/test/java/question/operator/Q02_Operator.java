package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02_Operator {
	
	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자(정수) 2개를 입력받아 아래의 연산식을 출력하시오.
//		- 출력 숫자에 천단위 표기 하시오.
//		- 결과값은 소수 이하 1자리까지 표기 하시오.
//		생각하기]
//		- 숫자가 아닌 값을 입력하면?
//		- 나눗셈의 결과가 정수일 때 소수이하를 표시안하려면?
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		int num1 = Integer.parseInt(input1);
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		int num2 = Integer.parseInt(input2);
		
		System.out.println();
		System.out.printf("%,d + %,d = %,d%n", num1, num2, num1 + num2);
		System.out.printf("%,d - %,d = %,d%n", num1, num2, num1 - num2);
		System.out.printf("%,d * %,d = %,d%n", num1, num2, num1 * num2);
		System.out.printf("%,d / %,d = %,.1f%n", num1, num2, (double)num1 / num2);
		System.out.printf("%,d %% %,d = %,d%n", num1, num2, num1 % num2);
	
//		double dnum = (double)num1 / num2;
//		int inum = num1 / num2;
//		System.out.printf("%,d / %,d = ", num1, num2);
//		System.out.printf((dnum - inum == 0 ) ? "%,d%n" : "%,.1f%n"
//												, inum
//												, dnum );			//나눗셈의 결고가 정수일 때 소수이하 표시안하기
	
	}
}
