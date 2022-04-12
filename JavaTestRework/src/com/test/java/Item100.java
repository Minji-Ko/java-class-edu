package com.test.java;

import java.util.function.Supplier;
import java.util.function.DoubleSupplier;

public class Item100 {

	public static void main(String[] args) {
	
		//[SUMMARY] 함수형 인터페이스 Supplier 사용하기 (2022. 4. 11. 오후 10:27:29)
	
		Supplier<Integer> s = () -> 10;
		int inum = s.get();
		
		
		DoubleSupplier ds = () -> 10.0;
		double dnum = ds.getAsDouble();
		
	}
}