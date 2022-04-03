package com.test.java;

public class Item102 {

	public static void main(String[] args) {
	
		//[SUMMARY] 인터페이스 만들기 (2022. 4. 3. 오후 11:48:11)
	
	}
}


//인터페이스 == 제품의 규격 역할
interface Key {
	
	void test(); //public
	
	void click();
	
}

class G305 implements Key {
	private String type;
	private String color;
	private int dpi;
	
	@Override
	public void test() {
		
	}
	@Override
	public void click() {
		
	}
}