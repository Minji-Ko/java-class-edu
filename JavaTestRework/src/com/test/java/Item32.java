package com.test.java;

public class Item32 {

	public static void main(String[] args) {
		
		//[SUMMARY] 시간 구하기(int 변수) (2022. 3. 17. 오전 1:25:40)
		
		//2시간 30분 + 40분 = 3시간 10분
		int hour = 2;
		int min = 30;
		
		min += 40;

		hour = (min >= 60) ? hour + (min / 60): hour; 
		min = (min % 60);  
		
	}
}
