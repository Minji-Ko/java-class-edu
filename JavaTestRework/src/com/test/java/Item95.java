package com.test.java;

public class Item95 {

	public static void main(String[] args) {
		
		//[SUMMARY] 메소드 오버라이드하기(Override) (2022. 3. 28. 오후 10:26:03)
		
		Child child = new Child();
		
		child.name = "홍길동";
		child.hello();
		
	}	
}

class Parent {
	public String name;
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.", this.name);
	}
}

class Child extends Parent {
	public void hello() {
		System.out.printf("하이~ 난 %s이야", this.name);
	}
}
