package com.test.java;

import java.util.function.Predicate;

public class Item107 {

	public static void main(String[] args) {
	
		//[SUMMARY] 함수형 인터페이스 디폴트 메소드 사용하기(and, or, negate) (2022. 4. 11. 오후 11:50:39)
		
		Predicate<Integer> p1 = num -> num % 2 == 0;
		Predicate<Integer> p2 = num -> num % 3 == 0;
		
		
		boolean result;
		
		Predicate<Integer> p3 = p1.and(p2);
		result = p3.test(10); //false
		
		Predicate<Integer> p4 = p1.or(p2);
		result = p4.test(10); //true
		
		Predicate<Integer> p5 = p1.negate();
		result = p5.test(10); //false
	}
}