package com.test.java;

public class Item06 {

	public static void main(String[] args) {
	
		//[SUMMARY] 특수 문자(이스케이프 시퀀스) (2022. 3. 13. 오후 7:39:43)
		
		String s1;
	
		s1 = "\n"; 	//new line, line feed, 개행 문자
		s1 = "\r"; 	//carriage return, 커서의 위치를 현재 라인의 맨앞으로
		s1 = "\t"; 	//tap, 탭문자 
		s1 = "\b";	// BackSpace, *이클립스 콘솔에서 동작(x)
		
		s1 = "\'"; 	
		s1 = "\""; 	
		s1 = "\\"; 	
		
	}
}
