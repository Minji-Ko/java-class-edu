package com.test.java.question.array;

public class Q03_Dump {
	
	public static void main(String[] args) {
		
//		요구사항] int 배열을 매개변수로 받아 내용을 문자열로 반환하는 dump 메소드를 구현하시오.
//		- String dump(int[] list)
	
		int[] list = new int[4];
		
		list[0] = 10;
		list[1] = 20;
		list[2] = 30;
		list[3] = 40;
		
		String result = dump(list);
		System.out.printf("lists = %s\n", result);
	}
	
	public static String dump(int[] nums) {
		
		String result = "[ ";
		
		for(int i=0; i<nums.length; i++) {
			result += nums[i] + ", ";
		}
		
		result += "\b\b ]";
		
		return result;
	}
}

		
				