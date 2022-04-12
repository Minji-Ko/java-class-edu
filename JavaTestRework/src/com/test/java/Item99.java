package com.test.java;

import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

public class Item99 {

	public static void main(String[] args) {
	
		//[SUMMARY] 함수형 인터페이스 Consumer 사용하기 (2022. 4. 11. 오후 10:26:49)
		
		Consumer<Integer> c = num -> System.out.println(num * num);
		c.accept(3);
		
		
		BiConsumer<String, Integer> bc = (name, age) -> System.out.println(name + "("+ age + "세)");
		bc.accept("홍길동", 25);
		
		
		IntConsumer ic = num -> System.out.println(num * 2);
		ic.accept(100);
	
	}
}