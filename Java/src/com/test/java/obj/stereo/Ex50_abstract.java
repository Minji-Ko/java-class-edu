package com.test.java.obj.stereo;

public class Ex50_abstract {

	public static void main(String[] args) {

		/*
		 	1. 클래스
		 		- 실체화를 한다.
		 		- 구현된 멤버를 가진다. > 멤버 변수, 멤버 메소드({})
		 	2. 인터페이스
		 		- 실체화가 불가능하다. > 객체를 못 만든다.
		 		- 추상 멤버를 가진다. > 추상 메소드 > 자바는 다른 멤버도 가질 수 있지만 보편적으로는 추상메소드만!
		 		- 클래스의 부모 역할 > 표준화 역할(사용법 강제 통일) + 자격 부여
		 	
		 	3. 추상클래스
		 		- 클래스와 인터페이스의 중간
				- 실체화가 불가능하다. > 객체를 못 만든다.
				- 구현된 멤버를 가진다. > 멤버 변수, 멤버 메소드({})
				- 추상 멤버를 가진다. > 추상 메소드
		 
		 */
		
		//Keyboard k1 = new Keyboard();
		
		K8 k = new K8();
		k.color = "white"; 	//구현멤버 사용
		k.info();			//구현멤버 사용
		k.charge();			//추상멤버 구현
	}	
}

//추상 클래스
abstract class Keyboard {
	
	//구현 멤버
	private int price;
	public String color;
	
	public void info() {
		System.out.println(this.price);
		System.out.println(this.color);
	}
	
	//추상 멤버
	public abstract void charge();

}


class K8 extends Keyboard {
	
	@Override
	public void charge() {
		
	}
}

//사용 빈도
//- 인터페이스 >>> 추상 클래스(제약이 많아 다루기 힘듬;)
