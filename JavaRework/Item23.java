package com.test.java;

public class Item23 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] 메소드 오버로딩(Overload) (2022. 3. 15. 오전 12:24:24)
		
		info(10);
		info(10, "홍길동");
		info(10, "홍길동", true);
		
	} //main
	
	public static void info(int num) {
		//구현코드
	}
	
	public static void info(int num, String name) {
		//구현코드
	}
	
	public static void info(int num, String name, boolean b) {
		//구현코드
	}
}
