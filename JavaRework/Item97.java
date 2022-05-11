package com.test.java;

public class Item97 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 정적생성자 만들기(static) (2022. 3. 28. 오후 10:35:20)
		
	}	
}

class Coffee {
	
	private static int beanUnitPrice;
	private static int waterUnitPrice;
	
	static {
		Coffee.beanUnitPrice = 2;
		Coffee.waterUnitPrice = 1;
	}
}
