package com.test.java;

public class Item24 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] 재귀 메소드 만들기 (2022. 3. 15. 오전 12:30:05)
		
		int n = 5;
		int result = factorial(n);
		
		System.out.println(result);
	
	}

	public static int factorial(int n) {
		
		int result = (n == 1) ? 1 : n * factorial(n-1);
		
		return result;
	}
}
