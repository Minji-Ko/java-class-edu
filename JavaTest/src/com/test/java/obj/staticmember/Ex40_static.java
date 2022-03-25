package com.test.java.obj.staticmember;

public class Ex40_static {

	public static void main(String[] args) {
		
//		요구사항]
//		1. 펜을 생산하시오.
//		2. 생산된 펜의 개수를 세시오.
		
		//Case 1.
		//- Pen과 count간의 관계 약함 > 가독성 낮음(count라는 이름이 Pen하고 아무 상관없음)
		//- 오차발생(count++ 누락)
//		int count = 0;
//		
//		Pen p1 = new Pen("Monami", "Black");
//		count++;
//	
//		Pen p2 = new Pen("Monami", "Black");
//		count++;
//		
//		Pen p3 = new Pen("Monami", "Black");
//		count++;
//	
//		System.out.println("볼펜 개수: " + count);
		
		
		//Case 2.
		//- count변수와 Pen의 관계를 강하게 연결 > 결합
		//- 소재가 불분명 > 어떤 객체의 변수에 저장되있는지 알기 어려움 > 최악의 방법
//		Pen p1 = new Pen("Monami", "Black");
//		p1.count++;
//		
//		Pen p2 = new Pen("Monami", "Black");
//		//p2.count++;
//		p1.count++;
//		
//		Pen p3 = new Pen("Monami", "Black");
//		//p3.count++;
//		p1.count++;
//		
//		System.out.println("볼펜 개수: " + p1.count);   //p1이라는 한낱 객체(개인)이 모든 펜들의 개수를 세는 공통적인 값을 대표로 저장할만한 이유가 없다.;;;;
		
		
		//Case 3.
		//- count변수와 Pen의 관계가 명확
		//- 소재 분명 > 여러 곳 > 유일!!! > 변수 딱 1개
		//- 여전히 오차발생 가능
//		Pen p1 = new Pen("Monami", "Black");
//		Pen.count++;
//		Pen p2 = new Pen("Monami", "Black");
//		Pen.count++;
//		Pen p3 = new Pen("Monami", "Black");
//		Pen.count++;
//
//		System.out.println("볼펜 개수: " + Pen.count);

		
		//Case 4.
		//- 이상적인 방법
		//- count++ 누락 방지
		Pen p1 = new Pen("Monami", "Black");
		Pen p2 = new Pen("Monami", "Black");
		Pen p3 = new Pen("Monami", "Black");
		
		System.out.println("볼펜 개수: " + Pen.count);
	
		
		
	
	}
}

class Pen {
		
	private String model;
	private String color;
	public static int count = 0;  //public  //공용데이터
	
	public Pen(String model, String color) {
		this.model = model;
		this.color = color;
		Pen.count++;
	}
	
	public String dump() {
		return String.format("{ model: %s, color: %s }"
								, this.model
								, this.color);
	}
}