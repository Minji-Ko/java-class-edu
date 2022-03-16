package com.test.java;

public class Item40 {

	public static void main(String[] args) {
		
		//[SUMMARY] switch문 만들기(break 생략) (2022. 3. 17. 오전 1:43:47)
		int num = 1;
		
		switch (num) {
			case 1: // 1. 노트북 + 키보드 + 마우스
				System.out.println("마우스");
			case 2: // 2. 노트북 + 키보드
				System.out.println("키보드");
			case 3: // 3. 노트북
				System.out.println("노트북");
				break;
		}
	}
}
