package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q04_Operation {

	public static void main(String[] args) throws Exception {
	
//		요구사항] 숫자를 2개 입력받아 연산식을 반환하는 메소드를 선언하시오.
//		- String add(int, int)
//		- String subtract(int, int)
//		- String multiply(int, int)
//		- String divide(int, int)
//		- Stirng mod(int, int)
//		생각하기] 
//		- * 연산결과가 int범위를 넘는다면?
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		int n1 = Integer.parseInt(input1);
		
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		int n2 = Integer.parseInt(input2);
		
		String result;
		result = add(n1, n2);
		System.out.println(result);
		
		result = substract(n1, n2);
		System.out.println(result);
		
		result = multiply(n1, n2);
		System.out.println(result);
		
		result = divide(n1, n2);
		System.out.println(result);
		
		result = mod(n1, n2);
		System.out.println(result);
		
		
	}
	
	public static String add(int num1, int num2) {
		
		return num1 + " + " + num2 + " = " + (num1 + num2);
	}
	
	public static String substract(int num1, int num2) {
		
		return num1 + " - " + num2 + " = " + (num1 - num2);
	}
	
	public static String multiply(int num1, int num2) {
		
		return num1 + " * " + num2 + " = " + (num1 * num2);
	}
	
	public static String divide(int num1, int num2) {
		
		return num1 + " / " + num2 + " = " + (Math.round((double)num1 / num2 * 10) / 10.0);
//		return String.format("%d / %d = %.1f\n", num1, num2, (double)num1 / num2);
	}
	
	public static String mod(int num1, int num2) {
		
		return num1 + " % " + num2 + " = " + (num1 % num2); //"%%" vs "%"
	}
}

//		설계]
//		1. 1번 숫자 입력받기 > BufferedReader > 메시지 출력
//		2. String input1에 저장 > int로 형변환해서 num1에 저장
//		3. 2번 숫자 입력받기 > BufferedReader > 메시지 출력
//		4. String input1에 저장 > int로 형변환해서 num2에 저장
//		
//		5. 숫자 2개를 인자로 하고, 연산식(String)을 반환하는 add 메소드 선언하기
//			- return num1 + " + " + num2 + " = " + (num1 + num2)
//			- return "%d + %d = %d", num1, num2, (num1 + num2)					
//		6. 숫자 2개를 인자로 하고, 연산식을 반환하는 subtract 메소드 선언하기
//		7. 숫자 2개를 인자로 하고, 연산식을 반환하는 multiply 메소드 선언하기
//		8. 숫자 2개를 인자로 하고, 연산식을 반환하는 divide 메소드 선언하기 > float로 형변환
//			- return num1 + " + " + num2 + " = " + ((double)num1 / num2)
//		9. 숫자 2개를 인자로 하고, 연산식을 반환하는 mod 메소드 선언하기
//		
//		10. String result 선언하기
//		11. add 메소드 호출해서 result에 저장 > println()출력하기
//		12. subtract 메소드 호출해서 result에 저장
//		13. multiply 메소드 호출해서 result에 저장
//		14. divide 메소드 호출해서 result에 저장
//		15. mod 메소드 호출해서 result에 저장