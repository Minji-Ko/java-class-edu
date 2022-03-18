package com.test.java.question.array;

public class Q04_MaxMin {

	public static void main(String[] args) {
		
		//요구사항] 1~20 사이의 난수를 담고 있는 배열을 생성하고 최대값과 최소값을 출력하시오.
		//- 난수를 20개 발생 후 배열에 넣는다.
		//- 난수는 1 ~ 20 사이
		
		int[] nums = new int[20];
		
		System.out.print("원본 : ");
		
		//배열 요소에 난수를 저장하고 출력
		for(int i =0; i<nums.length; i++) {
			nums[i] = (int)(Math.random() * 20) + 1;
			System.out.print(nums[i] + ", ");					
		}
		
		System.out.println("\b\b ");
		
		
		//배열 오름차순 정렬
		for(int i=0; i<nums.length-1; i++) {
			for(int j=0; j<nums.length-1-i; j++) {
			
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		//최솟값 최대값 출력
		System.out.printf("최대값 : %d\n", nums[nums.length - 1]);
		System.out.printf("최소값 : %d\n", nums[0]);
		
	}
}

//		설계]
//		1. 배열 생성 > 길이 20
//		2. 배열 요소 > 난수를 생성하여 배열에 저장 > for문
//		3. 배열 요소 출력 > 메소드 String getarray()
//		4. 오름차순 정렬
//		5. 최솟값, 최댓값 출력