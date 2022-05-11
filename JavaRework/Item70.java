package com.test.java;

import java.util.Arrays;

public class Item70 {

	public static void main(String[] args) {
	
		//[SUMMARY] 배열 요소 삭제하기 (2022. 3. 22. 오전 12:15:12)
		
		int[] nums = { 5, 6, 1, 3, 2, 0, 0, 0, 0, 10 };
		int index = 2; 	//삭제 위치
		
		
		//Left Shift, 좌측 시프트 > for 증가
		for (int i=index; i<nums.length-1; i++) {
			nums[i] = nums[i+1];
		}

		nums[nums.length-1] = 0;
	}
}
