package com.test.java;

public class Item100 {

	public static void main(String[] args) {
	
		//[SUMMARY] 참조형 형변환하기(다운캐스팅) (2022. 4. 3. 오후 11:27:36)
		
		Parent p1;
		Child c1 = new Child();
		
		p1 = c1; 		//업캐스팅
	
		
		Child c2;
		
		c2 = (Child)p1; //업캐스팅 -> 다운캐스팅 
		
	}
}