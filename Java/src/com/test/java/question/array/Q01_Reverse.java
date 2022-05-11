package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01_Reverse {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 숫자를 5개 입력받아 배열에 담은 뒤 역순으로 출력하시오.
//		- int[] nums = new int[5];
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		int[] nums = new int[5];
		
		for (int i=0; i<5; i++) {
			
			System.out.print("숫자 : ");
			nums[i] = Integer.parseInt(reader.readLine());
		}
		
		for (int i=4; i>=0; i--) {
			System.out.printf("nums[%d] = %d\n", i, nums[i]);
		}

	}
}
//		설계]
//		1. 입력받기 > for문 0;<5;
//		2. 값 저장하기 
//			2.1 nums[i] = Integer...(reader.readLine())
//			2.2 String 변수에 저장!!!****
//		3. 역순출력 > 새로운 for문 
