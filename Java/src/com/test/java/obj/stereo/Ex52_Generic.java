package com.test.java.obj.stereo;

public class Ex52_Generic {

	public static void main(String[] args) {
		
		//클래스 종류
		//1. 클래스
		//2. 인터페이스
		//3. 추상 클래스
		//4. enum
		//5. 제네릭 클래스
		
		//제네릭, Generic
		//1. 제네릭 클래스 > O
		//2. 제네릭 메소드 
		
		
		//요구사항] 클래스 설계
		//1. 멤버 변수 선언 > int
		//2. 멤버 변수를 중심으로 여러가지 행동을 하는 메소드 선언
		
		//추가사항] String을 중심으로 하는 클래스를 추가 설계
		//추가사항] boolean을 중심으로 하는 클래스를 추가 설계
		//추가사항] double
		//추가사항] byte
		//추가사항] 무한대...
		
		//위의 문제점 > 해결 방안
		//1. Object 클래스 > 오래된 방식
		//2. 제네릭 클래스 > 최신 방식
		
		WrapperInt n1 = new WrapperInt(10);		//int
		System.out.println(n1.toString());
		System.out.println(n1.getData() * 2);
		System.out.println();
		
		WrapperObject n2 = new WrapperObject(10); 	//범용(만능) > 사용 + 다운캐스팅
		System.out.println(n2.toString());			//모든 것을 넣을 수 있지만, 한번 넣은 뒤에 자료형을 수정하면 복잡해짐
		System.out.println((int)n2.getData() * 2);
		System.out.println();
		
		Wrapper<Integer> n3 = new Wrapper<Integer>(10); //범용(만능) > 사용 + 바로 사용
		System.out.println(n3.toString());				//한번 넣은 뒤에는 자료형 고정 > Object의 단점 개선
		System.out.println(n3.getData() * 2);
		System.out.println();
		
		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1.toString());
		System.out.println(s1.getData().length());
		System.out.println();
		
		WrapperObject s2 = new WrapperObject("홍길동");
		System.out.println(s2.toString());
		System.out.println(((String)s2.getData()).length());
		System.out.println();
		
		Wrapper<String> s3 = new Wrapper<String>("홍길동");
		System.out.println(s3.toString());
		System.out.println(s3.getData().length());  	//범용 클래스 역할 + 전용 클래스 사용
		System.out.println();
		
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.toString());
		System.out.println(b1.getData() ? "참" : "거짓");
		System.out.println();

		WrapperObject b2 = new WrapperObject(false);
		System.out.println(b2.toString());
		System.out.println((boolean)b2.getData() ? "참" : "거짓");
		System.out.println();
		
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3.toString());
		System.out.println(b3.getData() ? "참" : "거짓");  //TODO boolean <-> Boolean? (2022. 3. 30. 오전 10:29:22)
		//제네릭의 장점을 써먹을 만한 업무가 실생활에 크게 없음 > 그러나 제네릭으로 만들어진 클래스(컬렉션)를 굉장히 많이 사용함
		
		

	}
}

class WrapperInt {
	private int data; //클래스의 중심이 되는 데이터!!!

	public WrapperInt(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "data=" + data;
	}
}

class WrapperString {
	private String data; //클래스의 중심이 되는 데이터!!!
	
	public WrapperString(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "data=" + data;
	}
}

class WrapperBoolean {
	private boolean data; //클래스의 중심이 되는 데이터!!!
	
	public WrapperBoolean(boolean data) {
		this.data = data;
	}
	
	public boolean getData() {
		return data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "data=" + data;
	}
}

class WrapperObject {
	private Object data; //클래스의 중심이 되는 데이터!!!
	
	public WrapperObject(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "data=" + data;
	}
}


class Wrapper<T> {
	private T data;
	
	public Wrapper(T data) { //생성자에 <T> 적으면 에러남
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "data=" + this.data;
	}
}

