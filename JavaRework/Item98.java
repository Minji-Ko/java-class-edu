package com.test.java;

public class Item98 {

	public static void main(String[] args) {
		
		//[SUMMARY] 접근 제어자 final 사용하기 (2022. 3. 28. 오후 10:40:30)
		
	}	
}

//final class : 상속 불가능
final class Final { 
	
	//final 멤버 상수 : 값 변경 불가능
	private static final int CONST = 1;  
	
	//final method : 상속시 재정의(Override) 불가능
	final public void method() {
		
		//final 지역 변수 :  값 변경 불가능
		final double PI = 3.14; 
	}
}

