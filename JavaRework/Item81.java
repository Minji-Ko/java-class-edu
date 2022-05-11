package com.test.java;

public class Item81 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열 추출하기(substring) (2022. 3. 27. 오후 8:09:04)
		
		String txt = "가나다라마바사아자차카타파하";
		
		String s;
		s = txt.substring(0);		//txt[0] ~ txt[txt.length()-1]
		s = txt.substring(0, 3); 	//txt[0] ~ txt[2]*** 
	
	}
	
}
