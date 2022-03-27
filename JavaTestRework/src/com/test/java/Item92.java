package com.test.java;

public class Item92 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 정적멤버 활용하기(객체 개수 카운팅) (2022. 3. 27. 오후 9:37:00)
		
		Pen p1 = new Pen("Monami");
		Pen p2 = new Pen("Monami");
		
		System.out.println("볼펜 개수: " + Pen.count);
	}	
}

class Pen {
	
	private String model;
	public static int count = 0;   //count목적의 static변수
	
	public Pen(String model) {
		this.model = model;
		Pen.count++;
	}
}