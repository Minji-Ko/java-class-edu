package com.test.java;

public class Item62 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 요소 우위비교하기(문자, charAt) (2022. 3. 21. 오전 1:21:13)
 
		String[] names = { "하하하", "가가가" };
		
		
		for(int i=0; i<3; i++) {
			
			if(names[0].charAt(i) > names[1].charAt(i)) {
				
				String temp = names[0];
				names[0] = names[1];
				names[1] = temp; 
				break;
			
			} else if (names[0].charAt(i) < names[1].charAt(i)) {
				break;
			}
		}		
	
	
	}
}
