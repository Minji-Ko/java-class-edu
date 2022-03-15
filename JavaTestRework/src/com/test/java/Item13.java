package com.test.java;

public class Item13 {

	public static void main(String[] args) {
		
		//[SUMMARY] 논리 연산자(&&, ||, !) (2022. 3. 13. 오후 8:57:28)

		boolean t1 = true;
		boolean f1 = false;
		
		System.out.println(t1 && f1);	//false
		System.out.println(t1 || f1);	//true
		
		System.out.println(!t1);		//false
		System.out.println(!f1);		//true
	
	}
}
