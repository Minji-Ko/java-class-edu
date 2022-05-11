package com.test.java;

public class Item61 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 요소 우위비교하기(문자, compareTo) (2022. 3. 21. 오전 1:21:13)
		 
		String[] names = { "하하하", "가가가" };
		
		//name[0] > name[1] : 양수
		//name[0] < name[1] : 음수
		//name[0] == name[1] : 0
		if(names[0].compareTo(names[1]) > 0) {
			
			String temp = names[0];
			names[0] = names[1];
			names[1] = temp;  
		}		
		
				
	}
}
