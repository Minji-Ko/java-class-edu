package com.test.java;

public class Item43 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] for문 무한루프 탈출하기(break) (2022. 3. 17. 오전 1:54:50)
		
		for (int i=1; i<=10; i++) {
			System.out.println(i);
			
			if(i==5) {
				break; //if문을 제외한 나머지 제어문을 탈출
			}
		}
			
	}
}
