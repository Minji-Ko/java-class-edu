package com.test.java;

public class Item74 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 추출하기(charAt) (2022. 3. 22. 오전 12:27:30)
			
		String txt = "안녕하세요. 홍길동입니다.";
		
		char c;
		c = txt.charAt(0); //'안'
		c = txt.charAt(3); //'세'
		c = txt.charAt(txt.length()-1); //'.'
	}
	
}
