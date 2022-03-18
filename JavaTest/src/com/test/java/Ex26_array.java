package com.test.java;

import java.util.Arrays;

public class Ex26_array {

	public static void main(String[] args) {

		//정렬, Sort
		//1. 오름차순 정렬
		//2. 내림차순 정렬

		//배열 = 순서가 있는 집합
		
		//정렬하는 방법
		//1. 직접 구현
		//	- 수많은 정렬 알고리즘 > 10여가지
		//	- 버블정렬 
		// 	- 선택정렬, 삽입정렬, 병합정렬.. > 속도가 중요한 업무에서는 여러가지 정렬을 모두 비교하여 가장 속도가 빠른 것을 채택
		
		//2. 구현된 기능 활용(JDK)
		// 	- 실무에서는 직접구현하기 보다는 구현된 기능을 활용!
		//	- Quick Sort

		//m1();
		//m2();
		//m3();
		m4();
		
	} //main

	private static void m4() {
		
		int[] nums = { 5, 3, 1, 4, 2 };
	
		String[] names = { "유재석", "정형돈", "노홍철", "하하", "박명수" };
		
		//오름차순 정렬 > 공식적 메소드O
		//내림차순 정렬 > 공식적 메소드X > 2~3주 후 수업	
		System.out.println(Arrays.toString(nums)); //정렬적
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums)); //정렬적

		System.out.println(Arrays.toString(names)); //정렬적
		Arrays.sort(names);
		System.out.println(Arrays.toString(names)); //정렬적
	}

	private static void m3() {
		
		String[] name = { "유재석", "정형돈", "노홍철", "하하", "박명수" };

		System.out.println(Arrays.toString(name)); //정렬적
		for(int i=0; i<name.length-1; i++) {
			
			for(int j=0; j<name.length-1-i; j++) {
				
				//** 비교?
				if(name[j].compareTo(name[j+1]) > 0) {
					
					String temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;  
					
				}
			}
		}

		System.out.println(Arrays.toString(name));
	}

	private static void m2() {
		
		//정렬
		//1. 숫자 > 우위 비교
		//2. 문자(열) > 문자 코드값
		//3. 날짜 > 과거 vs 미래 > tick
		
		String[] name = { "유재석", "정형돈", "노홍철", "하하", "박명수" };
	
		//모든 참조형은 산술, 비교연산자의 피연산자가 될 수 없다.
//		if (name[0] > name[1]) {
//			
//		}
	
		System.out.println((int)name[0].charAt(0)); //유재석
		System.out.println((int)name[0].charAt(1));
		System.out.println((int)name[0].charAt(2));
	
		
		String name1 = "유재석";
		String name2 = "유형돈";
		
		//**** 문자열의 우위 비교는 문자열 내의 문자들의 문자코드값으로 비교한다.
		String result = "";
		for (int i=0; i<3; i++) {
			
			char c1 = name1.charAt(i);
			char c2 = name2.charAt(i);
			
			if (c1 > c2) {
				result = name1;
				break; //for 탈출 > 다음 글자는 비교할 필요 없어서
			} else if (c1 < c2) {
				result = name2;
				break;
			}
			
		}
		
		name1 = "가가가";
		name2 = "하하하";
		
		//name1 > name2 : 양수 반환
		//name1 < name2 : 음수 반환
		//name1 == name2 : 0 반환
		System.out.println(name1.compareTo(name2)); //int
		
		
		
	}

	private static void m1() {

		int[] nums = { 5, 3, 1, 4, 2 };
		
		//오름차순 정렬 > { 1, 2, 3, 4, 5 } 재배치
		
		//버블 정렬
		System.out.println(Arrays.toString(nums)); //정렬 전
		for (int i=0; i<nums.length-1; i++) { //N cycle
			
			for (int j=0; j<nums.length-i-1; j++) { //N step
				
				if(nums[j] > nums[j+1]) {   //오름차순
				//if(nums[j] > nums[j+1]) { //내림차순
					
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
