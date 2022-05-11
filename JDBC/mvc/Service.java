package com.test.java.mvc;

import java.util.Scanner;

public class Service {

	public void start() {

		boolean loop  = true;
		Scanner scan = new Scanner(System.in);
		
		while(loop) {
			
			View view = new View();
			view.menu();
			
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				add();
			} else if (input.equals("2")) {
				list();
			} else if (input.equals("3")) {
				edit();
			} else if (input.equals("4")) {
				del();
			} else {
				loop = false;
			}
			
			
			
			
//			Scanner scan = new Scanner(System.in);
//			
//			int num1 = scan.nextInt();
//			System.out.println(num1);
//			
//			int num2 = scan.nextInt();
//			System.out.println(num2);
//			
//			//두번째 숫자를 입력 버퍼로부터 가져가고 입력 버퍼 안에는 \r\n이 남아있는 상태
//			scan.skip("\r\n");
//			
//			String txt = scan.nextLine(); //안멈춤?? > 공회전 > Skip
//			System.out.println(txt);
//			
//			System.out.println("종료");

		}
	}

	private void add() {

		System.out.println("[주소록 등록하기]");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		System.out.print("성별(m,f): ");
		String gender = scan.nextLine();
	
		System.out.print("전화: ");
		String tel = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
	
		//DB 담당자
		DAO dao = new DAO();
		
		int result = dao.add(); //1.성공 0.실패
		
		if(result == 1) {
			//성공
			System.out.println("주소록 등록을 완료했습니다.");
		} else {
			System.out.println("주소록 등록을 실패했습니다.");			
		}
		
		
	}

	private void list() {
		// TODO Auto-generated method stub
		
	}

	private void edit() {
		// TODO Auto-generated method stub
		
	}

	private void del() {
		// TODO Auto-generated method stub
		
	}

	private void pause() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
	}
}
