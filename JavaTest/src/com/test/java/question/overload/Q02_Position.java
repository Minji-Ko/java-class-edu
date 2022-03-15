package com.test.java.question.overload;

public class Q02_Position {

	public static void main(String[] args) {
		
//		요구사항] 인자로 받은 이름들을 직급 순으로 출력하는 메소드를 선언하시오
//		- 사원 → 대리 → 과장 → 부장
//		- void position(String)
//		- void position(String, String)
//		- void position(String, String, String)
//		- void position(String, String, String, String)
	
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");
		
//		재귀 메소드 이용
//		position("홍길동");
//		System.out.println();
//		position("홍길동", "유재석");		
//		System.out.println();
//		position("홍길동", "유재석", "박명수");
//		System.out.println();
//		position("홍길동", "유재석", "박명수", "정형돈");
//		System.out.println();
		
	} //main

	public static void position(String n1) {
		System.out.printf("사원 : %s%n", n1);
		System.out.println();
	}


	public static void position(String n1, String n2) {
		System.out.printf("사원 : %s%n"
				        + "대리 : %s%n", n1, n2);
		System.out.println();
	}

	public static void position(String n1, String n2, String n3) {
		System.out.printf("사원 : %s%n"
						+ "대리 : %s%n"
						+ "과장 : %s%n", n1, n2, n3);
		System.out.println();
	}

	public static void position(String n1, String n2, String n3, String n4) {
		System.out.printf("사원 : %s%n"
						+ "대리 : %s%n"
						+ "과장 : %s%n"
						+ "부장 : %s%n", n1, n2, n3, n4);
		System.out.println();
	}

//	재귀 메소드
//	public static void position(String n1, String n2) {
//		position(n1);
//		System.out.printf("대리 : %s%n", n2);
//	}
//
//	public static void position(String n1, String n2, String n3) {
//		position(n1, n2);
//		System.out.printf("과장 : %s%n", n3);
//	}
//	
//	public static void position(String n1, String n2, String n3, String n4) {
//		position(n1, n2, n3);
//		System.out.printf("부장 : %s%n", n4);
//	}
	
}
