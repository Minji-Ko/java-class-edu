package com.test.java.question.overload;

public class Q01_Sum {

	public static void main(String[] args) {
		
//		요구사항] 인자로 받은 숫자들의 합을 구하는 메소드를 선언하시오.
//		- void sum(int)
//		- void sum(int, int)
//		- void sum(int, int, int)
//		- void sum(int, int, int, int)
//		- void sum(int, int, int, int, int)
	
		sum(10);
		sum(10, 20);
		sum(10, 20, 30);
		sum(10, 20, 30, 40);
		sum(10, 20, 30, 40, 50);
	} //main

	public static void sum(int n1) {
		System.out.printf("%d = %d\n", n1, n1);
	}
	
	public static void sum(int n1, int n2) {
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
	}
	
	public static void sum(int n1, int n2, int n3) {
		System.out.printf("%d + %d + %d = %d\n", n1, n2, n3, n1 + n2 + n3);
	}
	
	public static void sum(int n1, int n2, int n3, int n4) {
		System.out.printf("%d + %d + %d + %d = %d\n", n1, n2, n3, n4, n1 + n2 + n3 + n4);
	}
	
	public static void sum(int n1, int n2, int n3, int n4, int n5) {
		System.out.printf("%d + %d + %d + %d + %d = %d\n", n1, n2, n3, n4, n5, n1 + n2 + n3 + n4 + n5);
	}
	
	
}

//		설계]
//		1. int인자 1개 sum 메소드 선언하기  
//			> public static void sum(int n1)
//			> 출력 
//		2. int인자 2개 sum 메소드 선언하기 
//			> printf("%d + %d = %d\n", n1, n2, n1 + n2)
//		3. int인자 3개 sum 메소드 선언하기
//		4. int인자 4개 sum 메소드 선언하기
//		5. int인자 5개 sum 메소드 선언하기
//		6. sum 메소드 각각 호출하기 