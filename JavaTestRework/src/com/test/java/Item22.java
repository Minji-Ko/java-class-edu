package com.test.java;

public class Item22 {

	public static void main(String[] args) {
		
		//[SUMMARY] 두 변수의 값 교환하기(비트 연산자), swap (2022. 3. 15. 오전 12:21:47)
		
		int a = 10;
		int b = 20;
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	
	}
}
