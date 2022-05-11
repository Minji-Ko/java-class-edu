package com.test.java;

public class Item80 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 검색하기(lastIndexOf) (2022. 3. 27. 오후 8:05:29)
		
		String txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 네 홍길동입니다.";
		
		int index = -1;
		
		index = txt.lastIndexOf("홍길동"); //마지막 홍길동
		index = txt.lastIndexOf("홍길동", index - "홍길동".length()); //2번째 홍길동
		index = txt.lastIndexOf("홍길동", index - "홍길동".length()); //1번째 홍길동
	}
	
}
