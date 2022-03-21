package com.test.java;

public class Item76 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 검색하기(indexOf) (2022. 3. 22. 오전 12:33:24)
		
		String txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 네 홍길동입니다.";
		
		int index = -1;
		
		index = txt.indexOf('홍'); 
		index = txt.indexOf("홍길동"); //첫번째 홍길동
		index = txt.indexOf("홍길동", index + "홍길동".length()); //두번째
		index = txt.indexOf("홍길동", index + "홍길동".length()); //세번쨰
	}
	
}
