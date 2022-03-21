package com.test.java;

public class Item77 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 대소문자 변환하기 (2022. 3. 22. 오전 12:35:44)
		
		String txt = "오늘 수업하는 과목은 Java입니다.";
		String word = "JAVA";
		
		int index = -1;
		
		index = txt.toUpperCase().indexOf(word.toUpperCase());  //대문자로 변환
		index = txt.toLowerCase().indexOf(word.toLowerCase());  //소문자로 변환
	}
	
}
