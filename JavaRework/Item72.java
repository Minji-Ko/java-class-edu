package com.test.java;

public class Item72 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 요소 검색하기(index) (2022. 3. 22. 오전 12:17:44)
		
		String[] members = {"홍길동", "아무개", "박선녀"};
		
		String search = "홍길동";
				
		System.out.println(indexOf(members, search));
	}
	
	public static int indexOf(String[] members, String search) {
		
		for (int i=0; i<members.length; i++) {
			
			if(members[i].equals(search)) {
				return i;  
			}
		}
		return -1;
	}
}
