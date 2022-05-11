package com.test.java;

import java.util.Arrays;

public class Item60 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 요소 우위비교하기(숫자) (2022. 3. 21. 오전 1:21:13)

		int[] nums = { 2, 1 };
		
		if(nums[0] > nums[1]) { 
			
			int temp = nums[0];
			nums[0] = nums[1];
			nums[1] = temp;
		}
	
	}
}
