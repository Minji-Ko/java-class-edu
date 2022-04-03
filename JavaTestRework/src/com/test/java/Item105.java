package com.test.java;

public class Item105 {

	public static void main(String[] args) {
	
		//[SUMMARY] 열거형 만들기(enum) (2022. 4. 3. 오후 11:56:07)
		
		직급 position = 직급.과장;

	}
}

enum 직급 {
	사원,  //final static 상수
	대리,
	과장,
	부장
}