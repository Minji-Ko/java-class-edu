package com.test.java;

public class Item54 {

	public static void main(String[] args) {
		
		//[SUMMARY] 각 자료형 배열 만들기 (2022. 3. 21. 오전 1:06:39)
		
		//정수 배열(byte, short, int, long)
		byte[] list1 = new byte[3];
		list1[0] = 10;
		
		long[] list2 = new long[3];
		list2[0] = 1000000000000L;
		
		//실수 배열(float, double)
		double[] list3 = new double[3];
		list3[0] = 3.14;

		//문자 배열(char)
		char[] list4 = new char[3];
		list4[0] = 'A';
		
		//논리 배열(boolean)
		boolean[] list5 = new boolean[3];
		list5[0] = true;

		//문자열 배열, 참조형 배열
		String[] list6 = new String[3];
		list6[0] = "홍길동";
	}
}
