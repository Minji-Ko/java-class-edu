package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05_MaxMin2 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 난수를 담고 있는 배열을 생성한 뒤 아래와 같이 출력하시오.
//		- 난수를 20개 발생 후 배열에 넣는다.
//		- 난수는 1 ~ 20 사이
//		- 배열을 탐색하여 범위에 만족하는 숫자만 출력한다.
	
		int[] nums = new int[20];
		
		//난수 생성 후 저장하고, 원본 출력
		System.out.print("원본 : ");
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = (int)(Math.random() * 20) + 1;
			System.out.print(nums[i] + ", ");
		}
		System.out.println("\b\b ");
		
		
		//최대, 최소 범위 입력받기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 범위 : ");
		int max = Integer.parseInt(reader.readLine());
		System.out.print("최소 범위 : ");
		int min = Integer.parseInt(reader.readLine());
		
		
		//결과 출력하기
		System.out.print("결과 : ");
		
		for(int i=0; i<nums.length; i++) {
			if(min <= nums[i] && nums[i] <= max) {
				System.out.print(nums[i] + ", ");
			}
		}	
		System.out.println("\b\b ");
			
	}
}

//		설계]
//		1. 배열 생성하기 > 길이 20
//		2. 난수 생성후 배열에 넣기 > 1~20
//		3. 원본 출력하기 
//		4. 최소범위와 최대범위 입력받기 > int max, min
//		5. 결과 출력하기 > min <= nums[i] <= max > 출력