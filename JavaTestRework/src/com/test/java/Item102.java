package com.test.java;

import java.util.function.BinaryOperator;

public class Item102 {

	public static void main(String[] args) {
	
		//[SUMMARY] 함수형 인터페이스 Operator 사용하기 (2022. 4. 11. 오후 10:27:51)
	
		//BiFunction<Integer, Integer, Integer>
		BinaryOperator<Integer> bo = (a, b) -> a * b;
		int num = bo.apply(10, 20);
		
	}
}

