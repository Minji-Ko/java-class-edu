package com.test.java;

public class Item65 {

	public static void main(String[] args) {
		
		//[SUMMARY] 다차원 배열 만들기 (2022. 3. 21. 오후 11:56:01)
		
		int[][][] nums = new int[2][2][3]; //2(면), 2(행), 3(열)
		
		nums[0][0][0] = 10;
		nums[0][0][1] = 20;
		nums[0][0][2] = 30;
		//...
		nums[1][1][0] = 100;
		nums[1][1][1] = 110;
		nums[1][1][2] = 120;
	}
}
