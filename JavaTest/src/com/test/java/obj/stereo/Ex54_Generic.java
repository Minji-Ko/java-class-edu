package com.test.java.obj.stereo;

public class Ex54_Generic {

	public static void main(String[] args) {
		
		//Item is a raw type. References to generic type Item<T> should be parameterized
		Item i1 = new Item();
		
		Item<String> i2 = new Item<String>();
		i2.c = "문자열";
		
		//*** 값형(int)을 사용할 수 없다. > 반드시 참조형(클래스)만 가능
		// byte -> Byte
		// short -> Short
		// int -> Integer
		// double -> Double
		Item<Integer> i3 = new Item<Integer>();		
		i3.c = 30;
		
		Pen<Boolean> p1 = new Pen<Boolean>();
		p1.a = true;
		p1.b = false;
		p1.c = true;
	
		Desk<String> d1 = new Desk<String>();
		d1.a = "10";
		d1.test("문자열");
		String result = d1.get();
	
		
		Cup<String, Integer> c1 = new Cup<String, Integer>("문자열", 100);
		Cup<Double, Boolean> c2 = new Cup<Double, Boolean>(3.14, true);
	
		System.out.println(c1.getA());
		System.out.println(c1.getB());
		
	}//main
	
}//Ex54

//int a = 10; > 데이터를 담는 공간
//T = int; > 자료형을 담는 공간
//T = String;
//T = boolean;

//제네릭 클래스
//제네릭 : 자료형이 컴파일 때가 아니라 런타임 때 결정됨(런타임때 타입 소거)
//- T : 타입 변수 > 자료형을 저장하는 변수 > 보편적으로 대문자 한 글자
//- < > : 인자리스트 역할 
class Item<T> {
	
	public int a;
	public int b;
	public T c;	//클래스 설계 당시에는 c의 자료형이 결정 되지 않음 > 나중에 결정 > 객체 생성할 때
}

class Pen<T> {
	
	public T a;
	public T b;
	public T c;
}

class Desk<T> {
	
	public T a; //멤버 변수의 자료형
	
	public void test(T a) { //메소드 매개변수의 자료형
		T b; //지역 변수로는 비권장..메소드 안은 블랙박스
	}
	
	public T get() { //메소드 반환타입
		return this.a;
	}
}

class Cup<T,U> { //인자로 보통 1개, 최대 2개정도 사용
	
	public T a;
	public U b;
	
	public Cup(T a, U b) {
		this.a = a;
		this.b = b;
	}
	
	public T getA() {
		return this.a;
	}
	
	public U getB() {
		return this.b;
	}
}






















