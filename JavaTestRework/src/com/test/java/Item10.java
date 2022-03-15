package com.test.java;

public class Item10 {

	public static void main(String[] args) {
		
		//[SUMMARY] 형변환(타입 변환) 하기 (2022. 3. 13. 오후 8:10:00)
	
		int i = 10;
		double d;
		
		d = i; 			//int -> double 암시적 형변환
		i = (int)d;		//double -> int 명시적 형변환
	}
}
