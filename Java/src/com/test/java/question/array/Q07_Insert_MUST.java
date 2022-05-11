package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07_Insert_MUST {

	public static void main(String[] args) throws Exception {
		 
//		요구사항] 배열에 요소를 삽입하시오.
//		- 배열 길이: 10
//		- 마지막 요소는 우측으로 옮겨질 공간이 없으면 삭제된다.
	
		int[] nums = { 5, 6, 1, 3, 2, 0, 0, 0, 0, 0 };
//		int[] nums = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 };
				
		//삽입 위치, 값 입력받기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삽입 위치 : ");
		int index = Integer.parseInt(reader.readLine()); 
		System.out.print("값 : ");
		int value = Integer.parseInt(reader.readLine()); 
		
		
		System.out.print("원본 : ");
		System.out.println(dump(nums));
		
		//입력받은 값 삽입전 자리만들기
		for(int i=nums.length-1; i>index; i--) {			
			nums[i] = nums[i-1];
		}
		
		//입력받은 값 삽입하기
		nums[index] = value;
		
		
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
//		1. 길이 10 배열생성
//		2. 배열에 임의로 값 저장
//		3. 입력받기 
//			3.1 삽입위치, 값 > int
//		4. 원본 출력 > dump메소드
//		5. 결과값 넣기
//			5.1 for() > int i=배열길이-2; i>= 삽입위치; i--
//			5.2 배열[i]자리에 배열[i-1] 값 저장하기 
//		6. 결과 출력 > dump



