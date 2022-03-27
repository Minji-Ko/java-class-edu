package com.test.java;

public class Item82 {

	public static void main(String[] args) {

		//[SUMMARY] 문자열 검색하기(contains) (2022. 3. 27. 오후 8:13:00)
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		boolean b;
		b = txt.contains("홍길동");	//true
		b = txt.contains("아무개");	//false
		
	}
	
}
