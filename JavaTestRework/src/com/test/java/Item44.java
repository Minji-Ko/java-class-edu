package com.test.java;

public class Item44 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] for문 제어문 넘어가기(continue) (2022. 3. 17. 오전 1:54:50)
		
		for (int i=1; i<=10; i++) {
			System.out.println(i);
			
			if(i==5) {
				continue; //for문에 대해서 동작 -> 하던 일을 멈추고 제어의 처음으로 돌아감
			}
		}
	
	}
}
