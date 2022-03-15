package com.test.java;

public class Ex15_Overloading {

	public static void main(String[] args) {
		
//		1. 호출 구문 > 메소드 자동 생성(Ctrl + 1 > create)
//		2. 블럭 선택 > refactor > extract method
		test1();

		/*
			메소드 오버로딩, Method Overloading
			- 메소드가 인자 리스트를 다양한 형태로 가질 수 있는 기술
			- 같은 이름의 메소드 + 인자를 다양하게
		
			메소드 오버로딩을 하는 이유?
			- 성능 향상(x)
			- 개발자 도움(o) > 머리 나쁜 개발자들을 위한 기술 > 메소드 이름 외우기 힘든 사람들을 위해서..
		
			메소드 오버로딩 구현 조건 가능
			1. 매개변수의 갯수
			2. 매개변수의 자료형
			
			메소드 오버로딩 구현 조건 불가능
			1. 매개변수의 이름
			2. 반환값의 자료형
		
			메소드 선언하는 중...
			1. public static void test() {}				//o
			2. public static void test() {}				//x, 1번
			3. public static void test(int n) {}		//o
			4. public static void test(int m) {} 		//x, 3번
			5. public static void test(String s) {}		//o
			6. public static void test(int n, int m ) {}//o
			7. public static int test() {}				//x, 1번
			
			메소드 호출하기(검증!!) *****
			test();		//1번
			test(10); 	//3번
			test("문자열");	//5번
			test(10, 20); 	//6번
			
			int reulst = test(); //7번(불가능)
		
		 */
		
//		요구사항] 선을 출력하는 메소드
//		추가사항] 선의 모양을 다양하게
		
		drawLine();
		drawLine();		//선긋기
		drawLine();		//drawLineEquals()
			
		drawLine("*");	//drawLineAsterisk()
		drawLine("$");	//drawLineDollar()
		drawLine("+");	//drawLinePlus()
		
		
		//숫자출력
		System.out.println(100);
		println(100);
		
		//문자열 출력
		System.out.println("문자열");
		println("문자열"); //> 오버로딩된 메소드
		
		System.out.println(true);
		println(true);
		
		

	} //main
	
	
	public static void println(int num) {
		//num 출력
	}
	public static void println(String num) {
		//num 출력
	}
	public static void println(boolean num) {
		//num 출력
	}


	//메소드 생성 > 이름?
	public static void drawLine() {

		System.out.println("==============================");
	}

//	public static void drawLine() {
//		System.out.println("***************************");
//	}
	
	public static void drawLine(String s) {
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);	
		System.out.println();
	
	}

	private static String test1() {

//		printf() > 형식 문자 사용 > 출력할 때만 사용 가능 
//		10 / 3 -> "3.3"
		System.out.println(10 / 3); //3
		System.out.println(10.0 / 3); //3.333333333
		
		System.out.printf("%.1f\n", 10.0 / 3);  //3.3  -> 출력시만 사용 가능
		
//		1. 자바 수학 기능
//		2. 형식 문자열 지원 메소드 (*********)
		
		System.out.println(Math.round(10.0 / 3 * 10) / 10.0);
		
		//return String.valueOf(Math.round(10.0 / 3 * 10) / 10.0);
	
		//printf 메소드와 기능은 동일하지만 > 결과를 출력(X) 결과를 반환(O)
		String result = String.format("%.1f", 10.0 / 3);
		
		return result;
	} 
		

}

