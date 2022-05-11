package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09_PlusElement {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열 길이: ");
				
		//배열 생성하기
		int[] nums = new int[Integer.parseInt(reader.readLine())];
		
		//난수 생성하여 배열 요소 저장
		for(int i=0; i<nums.length; i++) {
			nums[i] = (int)(Math.random() * 9) + 1;
		}
		
		System.out.print("원본 : ");
		System.out.println(dump(nums));
		
		//새로운 배열 생성
		int[] halfNums = new int[(int)Math.ceil(nums.length / 2.0)];
		
		//배열 요소 저장 (마지막 배열요소 제외)
		for(int i=0; i<halfNums.length-1; i++) {
			halfNums[i] = nums[2*i] + nums[2*i + 1];
		}
		
		//배열 요소 저장 (마지막 배열 요소)
		if(nums.length % 2 == 0) {
			halfNums[halfNums.length - 1] = nums[2*(halfNums.length - 1)] + nums[2*(halfNums.length - 1) + 1];
		} else {
			halfNums[halfNums.length - 1] = nums[2*(halfNums.length - 1)];
		}
		
		System.out.print("결과 : ");
		System.out.println(dump(halfNums));
		
		
	} //main
	
	public static String dump(int[] nums) {
		
		String result = "[ ";
				
		for(int i=0; i<nums.length; i++) {
			result += String.valueOf(nums[i]) + ", ";
		}
		
		result += "\b\b ]";
		
		return result;				
	}

}

//		설계]
//		1. 배열길이 입력받기 > int length
//		2. 배열 생성하기 
//		3. 난수 1~9 생성하여 저장
//		4. 원본 출력 > int[] nums
//		5. 새로운 배열 생성 > int[] halfNums > 길이 nums.length/2
//		6. for문 
//			6.1 int i=0; i<nums.length/2; i++
//			6.2 halfNums[i] = nums[2i] + nums[2i+1]
//		7. 결과 출력 > int[] halfNums

