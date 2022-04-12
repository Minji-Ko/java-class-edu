package com.test.java;

import java.util.function.Consumer;
import java.util.function.Function;

public class Item106 {

	public static void main(String[] args) {
		
		//[SUMMARY] 함수형 인터페이스 디폴트 메소드 사용하기(andThen, compose) (2022. 4. 11. 오후 11:49:36)
		
		//Consumer + Consumer = Consumer
		Time time = new Time(10, 30);
		
		Consumer<Time> c1 = ctime -> System.out.print(ctime.getHour() + "시 ");		
		Consumer<Time> c2 = ctime -> System.out.print(ctime.getMin() + "분 ");
		
		Consumer<Time> c3 = c1.andThen(c2);
		c3.accept(time);
		
		
		//Function + Function = Function
		Function<Integer, Boolean> f1 = num -> num > 0;
		Function<Boolean, String> f2 = result -> result? "양수" : "양수 아님";
		
		Function<Integer, String> f3 = f1.andThen(f2);	
		Function<Integer, String> f4 = f2.compose(f1);   
		
		String result;
		result = f3.apply(10);
		result = f4.apply(10);
		
		
		
	}
}