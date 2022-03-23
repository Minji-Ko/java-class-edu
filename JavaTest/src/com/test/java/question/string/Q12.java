package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12 {

	public static void main(String[] args) throws Exception {
	
//		요구사항] 연산식을 입력받아 실제 연산을 하시오.
//		- 산술 연산자만 구현하시오.(+, -, *, /, %)
//		- 연산식의 공백은 자유롭게 입력 가능합니다.
//		- 산술 연산자가 반드시 존재하는지 체크하시오.
//		- 피연산자의 갯수가 2개인지 체크하시오.
//		
//		입력]	입력: 10 + 2
//		출력]	10 + 2 = 12]
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력: ");
		String numSentence = reader.readLine().replace(" ", "");
		
		//연산자 추출하기
		String operator = "";
		
		for(int i=0; i<numSentence.length(); i++) {
			if(!('0'<= numSentence.charAt(i) && numSentence.charAt(i) <= '9')) {
				operator = String.valueOf(numSentence.charAt(i));
			}
		}
		
		//피연산자 배열만들기
		String[] operand = numSentence.split("\\" + operator);
		
 		
		//출력하기
		if(operand.length < 2) {
			System.out.println("피연산자가 부족합니다.");
			
		} else {
			
			int operand1 = Integer.parseInt(operand[0]);
			int operand2 = Integer.parseInt(operand[1]);
			
			if(operator.equals("+")) {
				System.out.printf("%s + %s = %d\n", operand1, operand2, operand1 + operand2);
			
			} else if (operator.equals("-")) {
				System.out.printf("%s - %s = %d\n", operand1, operand2, operand1 - operand2);
			
			} else if (operator.equals("*")) {
				System.out.printf("%s * %s = %d\n", operand1, operand2, operand1 * operand2);
			
			} else if (operator.equals("/")) {
				System.out.printf("%s / %s = %f\n", operand1, operand2, operand1 / (double)operand2);
			
			} else if (operator.equals("%")) {
				System.out.printf("%s % %s = %d\n", operand1, operand2, operand1 % operand2);
			
			} else {
				System.out.println("연산자가 올바르지 않습니다.");
			}
		
		}
		
	}
}

//		설계]
//		1. 입력받기 > replace()
//		2. 숫자가 아닌부분 찾기 
//			- 산술연산자가 아니면 > 연산자가 올바르지 않습니다.
//			- 연산자 저장하기 > split
//		3. 배열개수가 3개가 아니라면 > 피연산자가 부족합니다.
//		4. if로 연산자나눠서 계산후 출력하기
	
		