package com.test.java.collection;

import java.util.Arrays;
import java.util.Comparator;

public class Ex66_sort {

	public static void main(String[] args) {
		
		//배열 or 컬렉션(ArrayList)
		//- 오름차순 정렬, 내림차순 정렬
		//1. 직접 구현 > 정렬 알고리즘 구현
		//2. JDK 제공 기능

		Integer[] nums = { 1, 5, 2, 4, 3 };
		
		//오름차순
		//Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		//내림차순 > 지원 안함 > 직접 구현(반 조립) ******
		//> Comparator
		
		//인터페이스를 매개변수 요구? > 인터페이스를 구현한 객체를 달라는 뜻!!
		//Arrays.sort(Object[] a, Comparator<? super Object> c)
		Arrays.sort(nums, new MyComparator());
		System.out.println(Arrays.toString(nums));
		
		
		//??? > mc1의 가치?
		MyComparator mc1 = new MyComparator();
		System.out.println(mc1.compare(10, 20)); //이 메소드를 사용할 일이 있냐??? > 없다 > 익명객체!!
		
		
		Arrays.sort(nums, new Comparator<Integer>() {
			
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
		}); 
		//들어간 코드비용은 같은데, 클래스를 명시적으로 만들지 않음
														
		System.out.println(Arrays.toString(nums));
		
		
	}//main
}

class MyComparator implements Comparator<Integer> { //Comparator<Integer>는 양수일 경우 교환!

	@Override
	public int compare(Integer o1, Integer o2) {
		
		//o1 vs o2
		
		//오름차순
		//1. o1이 더 크면 > 양수 반환 
		//2. o2가 더 크면 > 음수 반환 
		//3. 같으면 > 0 반환 

		//내림차순
		//1. o1이 더 크면 > 음수 반환 
		//2. o2가 더 크면 > 양수 반환 
		//3. 같으면 > 0 반환 
		
		
//		if (o1 > o2) {
//			return 1;
//		} else if (o1 < o2) {
//			return -1;
//		} else {
//			return 0;			
//		}
		
		
		return o2 - o1; 
		
	}
	
	
	
}