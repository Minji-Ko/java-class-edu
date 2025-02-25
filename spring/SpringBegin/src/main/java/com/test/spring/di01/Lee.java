package com.test.spring.di01;

public class Lee {

	private Brush brush;
	
	
	// DI 구현 (의존 주입 도구)
	// 1. 생성자
	// 2. Setter
	
	
	//다른 사람(외부)이 만들어서 제공 > 생성자(*****) 
	public Lee(Brush brush) {
		this.brush = brush;
	}
	
	//Setter(*****)
	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	
	public void run() {
		//의존 객체 생성x
		//Brush brush = new Brush(); //직접 생성
		brush.draw();
	}
}
