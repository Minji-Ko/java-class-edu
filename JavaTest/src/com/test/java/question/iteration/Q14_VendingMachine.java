package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14_VendingMachine {

	public static void main(String[] args) throws Exception {
		
//		요구사항] 자판기 프로그램을 구현하시오.
		
		String enter = "";
		
		while(enter.equals("")) {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("=====================");
			System.out.println("        자판기");
			System.out.println("=====================");
			System.out.println("1. 콜라 :\t\t700원");
			System.out.println("2. 사이다 :\t600원");
			System.out.println("3. 비타500 :\t500원");
			System.out.println("---------------------");
			System.out.print("금액 투입(원) : ");
			int money = Integer.parseInt(reader.readLine());
			
			System.out.println("---------------------");
			System.out.print("음료 선택(번호) : ");
			String sel = reader.readLine();
			
			while(!(sel.equals("1") || sel.equals("2") || sel.equals("3"))) {
				System.out.println("**원하시는 음료의 번호를 정확히 선택해주세요.**\n");
				System.out.print("음료 선택(번호) : ");
				sel = reader.readLine();
			}
			
			//음료와 거스름돈 제공하기
			provide(reader, sel, money);
			
			System.out.print("계속하시려면 엔터를 입력하세요.");
			enter = reader.readLine();
			System.out.println();
		}
	}
								

	public static void provide(BufferedReader reader, String sel, int money) throws Exception {
				
		if(sel.equals("1")) {
			
			// 투입 금액이 부족하다면 더 입력받기
			int price = 700;
			money = getMoney(reader, money, price);
			
			// 음료제공하기
			System.out.println("+ 콜라를 제공합니다.");
			System.out.printf("+ 잔돈 %d원을 제공합니다.\n", money - price);
		
				
		} else if (sel.equals("2")) {
			
			int price = 600;
			money = getMoney(reader, money, price);
			
			System.out.println("+ 사이다를 제공합니다.");
			System.out.printf("+ 잔돈 %d원을 제공합니다.\n", money - price);
			
			
		} else {
			
			int price = 500;
			money = getMoney(reader, money, price);
			
			System.out.println("+ 비타500을 제공합니다.");
			System.out.printf("+ 잔돈 %d원을 제공합니다.\n", money - 500);				
		}
	
		System.out.println();
		
	} //provide
	
	public static int getMoney(BufferedReader reader, int money, int price) throws Exception {
		
		while(money < price) {
			System.out.printf("**금액이 부족합니다. %d원을 더 넣어주세요**\n", price - money);
			System.out.println();
			System.out.print("금액 투입(원) : ");
			money += Integer.parseInt(reader.readLine());
		}
		System.out.println("---------------------");
		return money;
	
	} //getMoney

}

//		//TODO 음료수 안받고 돈 돌려받기 기능 (2022. 3. 17. 오후 6:10:47)

//		설계] 
//		1. 진행변수 선언 String enter= "\r\n" //윈도우 기준
//		2. 반복문 만들기 > while(enter )
//			2.1 자판기 메뉴
//			2.2 금액 투입 입력받기 > 500원 이상
//			2.3 음료 선택 입력받기
//			2.4 제공하기 출력
//			2.5 잔돈 계산하여 제공하기
//			2.6 엔터 안내메시지
//			2.7 엔터입력받기 > enter
//			2.8 공백 출력 > 1.1부터 반복
		