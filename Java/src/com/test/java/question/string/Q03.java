package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자를 입력받아 각 자릿수의 수의 합을 구하시오.

//		입력] 숫자: 314
//		출력] 결과: 3 + 1 + 4 = 8
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자: ");
		String num = reader.readLine();
		
		char[] nums = num.toCharArray();
		
		int sum = 0;
		
		System.out.print("결과: ");
		
		for(int i=0; i<nums.length; i++) {
			System.out.printf("%c + ", nums[i]);
			sum += nums[i] - '0';
		}
		
		System.out.printf("\b\b= %d\n", sum);
		
	
	}
}

//		설계]
//		1. 입력받기
//		2. 요소하나씩 쪼개기 > toCharArray
//		3. int로 변환후 덧셈 > for
//		4. 출력