package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09_PlusElement2 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 배열의 요소를 순차적으로 2개씩 더한 결과를 배열로 생성한 뒤 출력하시오.
//		- 원본 배열 길이: 사용자 입력
//		- 원본 배열 요소: 난수(1~9)
//		- 결과 배열 길이: 사용자 입력 / 2
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("배열 길이: ");
		int length = Integer.parseInt(reader.readLine());
		
		//배열 생성하기
		int[] nums;
		
		//배열 길이 정하기
		if(length % 2 == 0) {
			nums = new int[length];
		} else {
			nums = new int[length+1];
		}
		
		//난수 생성하여 배열 요소 저장
		for(int i=0; i<length; i++) {
			nums[i] = (int)(Math.random() * 9) + 1;
		}
		
		System.out.print("원본 : ");
		System.out.println(dump(nums));
		
		//새로운 배열 생성
		int[] halfNums = new int[nums.length / 2];
		
		//배열 요소 저장
		for(int i=0; i<halfNums.length; i++) {
			halfNums[i] = nums[2*i] + nums[2*i + 1];
		}
		
		System.out.print("결과 : ");
		System.out.println(dump(halfNums));
		
		
	} //main
	
	public static String dump(int[] nums) {
		
		String result = "[ ";
				
		for(int i=0; i<nums.length; i++) {
			result += String.valueOf(nums[i]) + ", ";
		}
		
		//사용자가 입력한 배열의 길이가 홀수일 때 마지막요소 0은 출력안함
		if(nums[nums.length-1] == 0) {
			result += "\b\b\b\b\b  ";
		}
		
		result += "\b\b ]  ";
		
		return result;				
	}
}

//		설계]
//		1. 배열길이 입력받기 > int length
//		2. 배열 생성하기 
//			2.1 짝수일 때 length만큼
//			2.2 홀수일 때 length+1만큼
//		3. 난수 1~9 생성하여 저장
//		4. 원본 출력 > int[] nums
//		5. 새로운 배열 생성 > int[] halfNums > 길이 nums.length/2
//		6. for문 
//			6.1 int i=0; i<nums.length/2; i++
//			6.2 halfNums[i] = nums[2i] + nums[2i+1]
//		7. 결과 출력 > int[] halfNums


