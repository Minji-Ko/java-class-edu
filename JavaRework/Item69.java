package com.test.java;

import java.util.Arrays;

public class Item69 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 요소 삽입하기 (2022. 3. 22. 오전 12:13:56)
	
		int[] nums = { 5, 6, 1, 3, 2, 0, 0, 0, 0, 10 };
		int index = 4; 	//삽입 위치
		int value = 100;//삽입 값
		
		
		//Right Shift, 우측 시프트 > for 감소
		for (int i=nums.length-2; i>=index; i--) {
			nums[i+1] = nums[i];
		}
		
		nums[index] = value;
		
	}
}
