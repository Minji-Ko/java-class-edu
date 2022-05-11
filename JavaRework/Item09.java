package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Item09 {

	public static void main(String[] args) throws Exception {
		
		//[SUMMARY] 입력 받기(BufferedReader) (2022. 3. 13. 오후 8:07:21)
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력: ");
		String input = reader.readLine();
	
	}
}
