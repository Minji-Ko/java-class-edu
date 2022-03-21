package com.test.java;

public class Item67 {

	public static void main(String[] args) {
		
		//[SUMMARY] 다차원 배열 탐색하기(for문) (2022. 3. 22. 오전 12:01:33)
		
		int[][][] nums = new int[2][2][3];
		
		
		for(int i=0; i<nums.length; i++) {	//nums.length 면의 개수
			
			for(int j=0; j<nums[0].length; j++) {	//nums[0].length 행의 개수
				
				for(int k=0; k<nums[0][0].length; k++) {	//nums[0][0].length 열의 개수
					
					System.out.println(nums[i][j][k]);
					
				}
			}
		}
	

	
	}
}
