package com.test.java;

public class Item99 {

	public static void main(String[] args) {
	
		//[SUMMARY] 참조형 형변환하기(업캐스팅) (2022. 4. 3. 오후 11:27:36)
		
		Parent p;
		Child c = new Child();
	
		p = c; //p = (Parent)c;
	}
}