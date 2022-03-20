package com.test.java;

import java.util.Arrays;

public class Item59 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 정렬하기(버블 정렬) (2022. 3. 21. 오전 1:18:56)
		
		int[] nums = { 5, 3, 1, 4, 2 };
		
		
		for (int i=0; i<nums.length-1; i++) { 		//N cycle
			
			for (int j=0; j<nums.length-i-1; j++) { //N step
				
				if(nums[j] > nums[j+1]) {   //오름차순 { 1, 2, 3, 4, 5 } 
				//if(nums[j] > nums[j+1]) { //내림차순 { 5, 4, 3, 2, 1 }
					
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	
	
	}
}
