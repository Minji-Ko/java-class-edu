package com.test.java;

public class Item105 {

	public static void main(String[] args) {
	
		//[SUMMARY] 인터페이스 만들기 (2022. 4. 11. 오후 10:31:18)

	}
}
interface MyInterface {
	
	public static final int A = 20;	//static final
	
	public static void bbb() { 		//static > 모두의 행동
		
	}
	
	default void ccc() { 			//default
		
	}
	
	int sum(int a, int b); //추상 메소드
	
}
