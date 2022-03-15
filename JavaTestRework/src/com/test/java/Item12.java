package com.test.java;

public class Item12 {

	public static void main(String[] args) {
		
		//[SUMMARY] 문자열(String) 변환하기 (2022. 3. 13. 오후 8:38:25)
	
		//*** 형변환 불가능 
		//문자열 -> 값형
		Byte.parseByte("10");
		Short.parseShort("10");
		Integer.parseInt("10");
		Long.parseLong("10");

		Float.parseFloat("3.14");
		Double.parseDouble("3.14");

		Boolean.parseBoolean("true");	
		
		//문자열("A") -> 문자('A')
		"A".charAt(0);
		
		//값형 -> 문자열
		String.valueOf(100);	//"100"
		String.valueOf(3.14);	//"3.14"
		String.valueOf(true);	//"true"
	}
}
