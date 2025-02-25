package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex21_switch {

	public static void main(String[] args) throws Exception {
		
		/*
		 
		 	조건문
		 	1. if
		 	2. switch
		 	
		 	switch문, switch case문
			- 조건: 값 > 정수, 문자열, 열거형

		 	switch (조건) {
		 		case 값:
		 			실행문;
		 			break;
		 		[case 값:
		 			실행문;
		 			break;] x N
		 		[default:
		 			실행문
		 			break;]
		 			
		 	}
		 
		 */
		
		//m1();
		//m2();
		//m3();
		m4();
		
	} //main

	public static void m4() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
//		요구사항] 인터넷 쇼핑몰 > 옵션(패키지)
//		1. 노트북 + USB C타입 케이블 + 마우스패드
//		2. 노트북 + USB C타입 케이블
//		3. 노트북
		
		System.out.print("선택: ");
		
		String input = reader.readLine();
		
		switch (input) {
			case "1":
				System.out.println("마우스패드");
			case "2":
				System.out.println("노트북");
				System.out.println("USB C타입 케이블");
			case "3":
				System.out.println("노트북");
				break;
			
			
		}
	}

	public static void m3() throws Exception {

//		요구사항] 사용자가 월을 입력 > 해당월의 마지막 일?
		
		int lastDay = 0; // 마지막 일
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("월: ");
		
		String month = reader.readLine();

		switch (month) {
			case "1":
			case "3":
			case "5":
			case "7":
			case "8":
			case "10":
			case "12":
				lastDay = 31;
				break;
			case "2":
				lastDay = 28;
				break;
			case "4":
			case "6":
			case "9":
			case "11":
				lastDay = 30;
				break;
		}
		
		System.out.printf("입력한 %s월의 마지막 날짜는 %d일입니다.\n", month, lastDay);
	
	}

	public static void m2() throws Exception {
							//TODO throws Exception할 때는 import안해줘도 되나? (2022. 3. 16. 오전 9:36:35)
//		요구사항] 자판기
//		- 메뉴 출력 > 음료 선택 > 가격 출력
//		- 가격 인상 > 앞으로 평생 콜라와 사이다는 동일한 가격으로 판매
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("===================");		
		System.out.println("       자판기");
		System.out.println("===================");		
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 비타500");
		System.out.println("-------------------");
		System.out.print("선택(번호입력): ");  //사용자한테 음료수 이름을 입력하라고 하면 오류날 가능성이 높음 -> 사용자, 개발자 모두 편함
		
		String sel = reader.readLine();
		//int sel = Integer.parseInt(reader.readLine()); //연산을 하지 않는데 형변환 할 필요는 없음!!
	
		if (sel.equals("1") || sel.equals("2")) { //콜라 + 사이다
			System.out.println("800원입니다.");
		} else if (sel.equals("3")) {
			System.out.println("500원입니다.");
		}
		
		
		switch (sel) {
			case "1":
			case "2":
				System.out.println("800원입니다.");
				break;
			case "3":
				System.out.println("500원입니다.");
				break;
		}
	}	

	public static void m1() {
		
//		요구사항] 숫자를 1개 입력받아 한글로 출력하시오.
		int num = 4; //사용자 입력
		
		if(num == 1) {
			System.out.println("하나"	);
		} else if (num == 2) {
			System.out.println("둘");
		} else if (num == 3) {
			System.out.println("셋");
		} else {
			System.out.println("나머지 숫자");
		}
		//if조건식을 검사한 후 else if로, 그다음 else if로 순서대로 검사
		
		num = 5;
		
		switch (num) {	//조건으로 값을 사용한다.
			case 1: 	//Label(위치를 표시하는 역할, 1:)
				System.out.println("하나");
				break;	//switch문을 탈출해라
			case 2:
				System.out.println("둘");
				break;	
			case 3:
				System.out.println("셋");
				break;
			default:
				System.out.println("나머지 숫자");
				break;
		}
		//num에 해당하는 case 값 찾아서 바로 실행
	
	}
}























