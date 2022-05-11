package com.test.java;

public class Item55 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 복사하기(얕은 복사) (2022. 3. 21. 오전 1:08:32)
		
		int[] ns = { 10, 20, 30 }; 
		
		//int[] = int[]
		//참조형 복사 > 주소값 복사
		int[] copy = ns; 
		
		ns[0] = 100; 	 //copy[0] = 100
		
		
	}
}
