package com.test.java;

public class Item17 {

	public static void main(String[] args) {
		
		//[SUMMARY] 메소드 만들기(매개 변수, 인자) (2022. 3. 13. 오후 9:18:05)
	
		wait("홍길동", 3);
	}
	

	public static void wait(String name, int num) {
							//매개변수가 전달되는 방식
							//1. 값형, String > Call by value
							//2. String 이외의 참조형 > Call by reference   
		
		System.out.printf("%s님은 대기번호 %d번 입니다.\n", name, num);
	}
}
