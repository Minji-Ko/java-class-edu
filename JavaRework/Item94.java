package com.test.java;

public class Item94 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 상속하기 (2022. 3. 28. 오후 10:19:50)
		
		CCC c1 = new CCC();

		c1.aaa();
		c1.bbb();
		c1.ccc();
		
	}	
}

class AAA {
	public void aaa() {
		
	}
}

class BBB extends AAA {
	public void bbb() {
		
	}
}

class CCC extends BBB {
	public void ccc() {
		
	}
}	
		
