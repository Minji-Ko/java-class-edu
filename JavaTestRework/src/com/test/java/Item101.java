package com.test.java;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;

public class Item101 {

	public static void main(String[] args) {
	
		//[SUMMARY] 함수형 인터페이스 Function 사용하기 (2022. 4. 11. 오후 10:27:39)
		
		Function<Integer, Boolean> f = num -> num > 0;
		boolean positive = f.apply(10);
		
		
		BiFunction<Integer, Integer, String> bf = (a, b) -> a > b? "크다" : "작다";
		String result = bf.apply(10, 5);  
		
		
		DoubleFunction<Boolean> df = (n1) -> n1 < 0;
		boolean negative = df.apply(-10.0);
		
		
	}
}


