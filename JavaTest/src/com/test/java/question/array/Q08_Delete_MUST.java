package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08_Delete_MUST {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 배열의 요소를 삭제하시오.
//		- 배열 길이: 10
//		- 마지막 요소는 0으로 채우시오.
	
//		int[] nums = { 5, 6, 1, 3, 2, 0, 0, 0, 0, 0 };
		int[] nums = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 };
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("삭제 위치 : ");
		int location = Integer.parseInt(reader.readLine());
		
		System.out.print("원본 : ");
		System.out.println(dump(nums));
		
		//삭제하기
		for(int i=location; i<nums.length-1; i++) {
			nums[i] = nums[i+1];
		}
		
		//마지막 요소 0으로 채우기
		nums[nums.length-1] = 0;
		
		System.out.print("결과 : ");
		System.out.println(dump(nums));
	
	}
	
	public static String dump(int[] nums) {

		String result = "[";
		
		for(int i=0; i<nums.length; i++) {
			result += String.valueOf(nums[i]) + ", ";
		}
		
		result += "\b\b]";
		
		return result;
		
	}
}
	
//		설계]
//		1. 배열 생성하기
//		2. 배열에 임의의 값 저장
//		3. 삭제위치 입력받기
//		4. 원본 출력하기 > dump
//		5. for문 > 
//			5.1 삭제위치에서 시작해서 i<length-1, i++
//			5.2 nums[i] = nums[i+1]
//		6. 마지막 자리에 0채우기
//		7. 결과 출력하기



