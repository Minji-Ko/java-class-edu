package com.test.java.question.array;

public class Q06_Lottery {

	public static void main(String[] args) {
		
//		요구사항] 중복되지 않는 임의의 숫자 6개를 만드시오.(로또)
//		- 숫자의 범위 : 1 ~ 45
//		- 오름차순 정렬
	
		int[] lottery = new int[6];
		
		//난수 생성후 저장
		for(int i=0; i<lottery.length; i++) {
			lottery[i] = (int)(Math.random() * 45) + 1;
		}
		
		//오름차순 정렬
		for(int i=0; i<lottery.length-1; i++) {
			for(int j=0; j<lottery.length-1-i; j++) {
				
				if(lottery[j] > lottery[j+1]) {
					int temp = lottery[j];
					lottery[j] = lottery[j+1];
					lottery[j+1] = temp;
				}
			}
		}
	
		//dump메소드 출력
		System.out.println(dump(lottery));
		
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
		
//		1. 길이 6 배열 생성
//		2. 난수 생성 후 저장 > 1~45
//		3. 오름차순 정렬
//		4. dump