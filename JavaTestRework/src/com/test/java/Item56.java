package com.test.java;

public class Item56 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 복사하기(깊은 복사) (2022. 3. 21. 오전 1:11:26)
		
		int[] ns = { 10, 20, 30 };
		
		int[] copy = new int[3]; 
	
		for (int i=0; i<ns.length; i++) {
			
			//값형 복사
			//int = int
			copy[i] = ns[i];
		}
		
		ns[0] = 100;	//copy[0] = 10
	}
}
