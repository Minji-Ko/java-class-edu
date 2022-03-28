package com.test.java.obj.cast;

public class Ex46_Casting {

	public static void main(String[] args) {
		
		/*
	
			형변환, Type Casting
			1. 값형 형변환, ValueType Casting
				- 값형끼리 형변환(boolean 제외)
				- 값형과 참조형간의 형변환은 절대 불가 ***
				
			2. 참조형 형변환, ReferenceType Casting
				- 참조형끼리 형변환


			참조형 형변환
			- 상속관계의 클래스간의 형변환 > 직계끼리만 가능(방계는 불가능)
			- A클래스 > B클래스
			
			1. 업캐스팅, Up Casting
				- 암시적인 형변환
				- 자식 클래스 -> 부모 클래스
				
			2. 다운캐스팅, Down Casting
				- 명시적인 형변환
				- 부모 클래스 -> 자식 클래스
				
		*/
		
		//temp();
		
		
		
		
		
		
		
		
		
		
	}

	private static void temp() {
		System.out.printf("%s", "문자열");
		
		//자동으로 toString() 호출
		//1. Wrapper Class
		//2. 참조형 변환
		//3. toString() 호출 
		System.out.printf("%d", 10);
		System.out.printf("%s", 10);   //비추천!!
		
		System.out.printf("%b", true);
		System.out.printf("%s", false);
		
		System.out.printf("%c", 'A');
		System.out.printf("%s", 'Z');
	}
}
