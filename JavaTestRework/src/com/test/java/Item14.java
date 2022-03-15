package com.test.java;

public class Item14 {

	public static void main(String[] args) {
		
		//[SUMMARY] 비교 연산자(==, !=) (2022. 3. 13. 오후 9:04:25)
		
		int num1 = 100;
		int num2 = 100;
		int num3 = 300;
		
		System.out.println(num1 == num2); //true
		System.out.println(num1 == num3); //flase
		System.out.println(num1 != num3); //true
		
		//문자열을 대상으로 ==, != 연산자를 절대로 사용하면 안된다!!
		String txt1 = "홍길동";
		String txt2 = "홍길동";
		String txt3 = "아무개";
		
		System.out.println(txt1.equals(txt2)); 	//true
		System.out.println(txt1.equals(txt3)); 	//false
		System.out.println(!txt1.equals(txt3)); //true
	}
}
