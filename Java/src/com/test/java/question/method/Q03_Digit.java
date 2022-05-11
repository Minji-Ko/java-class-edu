package com.test.java.question.method;

public class Q03_Digit {

	public static void main(String[] args) {
		
//		요구사항] 숫자 1개를 전달하면 4자리로 출력하는 메소드를 선언하시오.
//		- void digit(int num)
//		- 입력한 숫자가 4자리 이상이면 그대로 출력한다.
	
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
	
	}
	
	public static void digit(int num) {
		System.out.printf("%d → %04d%n", num, num);
	}
}

//		설계]
//		1. 숫자 1개를 인자로 하는 digit 메소드 생성하기 > 숫자 1개를 4자리로 출력하기 > printf("%04d")
//		2. 숫자 1개를 인자로 digit 메소드 호출하기
			
