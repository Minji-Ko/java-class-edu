package com.test.java;

public class Item104 {

	public static void main(String[] args) {
	
		//[SUMMARY] 사용자 정의 함수형 인터페이스 만들기 (2022. 4. 11. 오후 10:28:39)

		MyConsumer m = num -> System.out.println(num * num);
		
		m.squared(100);
	}
}

//@FunctionalInterface 
//1. 함수형 인터페이스임을 알림
//2. 추상 메소드가 1개인지 검사

@FunctionalInterface
interface MyConsumer {
	void squared(int num);
}