package com.test.java;

public class Item104 {

	public static void main(String[] args) {
	
		//[SUMMARY] 추상클래스 만들기 (2022. 4. 3. 오후 11:55:12)

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