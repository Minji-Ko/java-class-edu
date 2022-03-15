package com.test.java.question.method;

public class Q01_Hello {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 인삿말을 출력하는 메소드를 3개 선언하시오
//		- void hello()
//		- void introduce()
//		- void bye()
//		생각하기]
//		- 이름이 홍길동이 아니라면? 
		
		hello();
		introduce();
		bye();
	}
	
	public static void hello() { 
		System.out.println("안녕하세요.");
	}
	
	public static void introduce() {
		System.out.println("저는 홍길동입니다.");
	}
	
	public static void bye() {
		System.out.println("안녕히가세요.");
	}
	
}

// 		설계]
//		1. hello 메소드 만들기 : println() 출력
//		2. hello 메소드 호출하기
//	
//		4. introduce 메소드 만들기 > println() 출력
//		5. introduce 메소드 호출하기
//		
//		6. bye 메소드 만들기 
//		7. bye 메소드 호출하기
