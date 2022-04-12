package com.test.java;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Item103 {

	public static void main(String[] args) {
	
		//[SUMMARY] 함수형 인터페이스 Predicate 사용하기 (2022. 4. 11. 오후 10:28:01)
	
		//Function<Integer, Boolean>
		Predicate<Integer> p = num -> num > 0;
		boolean result = p.test(10);
		
		
		BiPredicate<String, String> bp = (s1, s2) -> s1.length() > s2.length();
		result = bp.test("가나다", "가나다라");
	}
}
