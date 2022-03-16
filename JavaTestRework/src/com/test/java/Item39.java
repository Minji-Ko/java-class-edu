package com.test.java;

public class Item39 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] switch문 만들기 (2022. 3. 17. 오전 1:41:20)
		
		int num = 5;
		
		switch (num) {	//조건으로 값을 사용한다.
			case 1: 	
				System.out.println("하나");
				break;	//switch문을 탈출해라
			case 2:
				System.out.println("둘");
				break;	
			case 3:
				System.out.println("셋");
				break;
			default:
				System.out.println("나머지 숫자");
				break;
		}
	}
}
