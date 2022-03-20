package com.test.java;

public class Item50 {

	public static void main(String[] args) {
		
		//[SUMMARY] for문 중첩하기 (2022. 3. 20. 오후 11:02:20)
		
		for (int i=0; i<12; i++) { //시침 : 대회전
			
			for (int j=0; j<60; j++) { //분침 : 중회전
				
				for (int k=0; k<60; k++) { //초침 : 소회전
					
					System.out.printf("%d시 %d분 %d초\n", i, j, k);
				}
			}
		}
		
		
	}
}
