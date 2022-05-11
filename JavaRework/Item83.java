package com.test.java;

public class Item83 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 치환하기(replace) (2022. 3. 27. 오후 8:15:03)
		
		String content = "금지어를 마스킹 처리합니다. 바보야!!";
		String word = "바보";
		
		String s = content.replace(word, "**"); 
	}
	
}
