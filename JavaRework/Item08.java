package com.test.java;

public class Item08 {

	public static void main(String[] args) {
		
		//[SUMMARY] 형식 문자(지시자) 출력하기 (2022. 3. 13. 오후 7:49:48)
	
//		1. %s -> String
//		2. %d -> Decimal(정수; byte, short, int, long)
//		3. %f -> Float(실수; float, double)
//		4. %c -> Char
//		5. %b -> Boolean
		System.out.printf("문자열: %s\n", "문자열");
		System.out.printf("정수: %d\n", 10);
		System.out.printf("실수: %f\n", 3.14);
		System.out.printf("문자: %c\n", 'A');
		System.out.printf("논리: %b\n", true);
		
		
//		1.%숫자d, %숫자f, %c숫자, %숫자s, %숫자b  -> 출력할 너비지정
		System.out.printf("%3d\n", 10); 	//우측정렬
		System.out.printf("%-3d\n", 10);	//좌측정렬
		System.out.printf("%03d\n", 10);	//0으로 채우기
		
//		2. %.숫자f -> 소수점 이하 출력 자릿수 지정
		System.out.printf("%.1f\n", 10.0/3);	
		
//		3. %,d, %,f -> 천단위 표기
		System.out.printf("%,6.1f\n", 10000.0/3);//천단위 표기
		
	}
}
