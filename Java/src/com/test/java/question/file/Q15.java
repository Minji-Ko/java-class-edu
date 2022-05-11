package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q15 {

	public static void main(String[] args) {
/* 
	요구사항]	이름을 입력받아 회원 주문 정보를 검색 후 출력하시오.

	리소스]	파일 > 검색_회원.dat
			파일 > 검색_주문.dat
	입력] 	이름: 홍길동 
	출력]==== 구매내역 ==== 
		[번호]    [이름]    [상품명]    [개수]    [배송지]
	      3   	 홍길동     마우스       3       서울시 강동구 천호동
	 
*/		
		//1.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		scan.close();
		
		
		//2.
		File memberFile = new File("C:\\class\\java\\파일_입출력_문제\\검색_회원.dat");
		File orderFile = new File("C:\\class\\java\\파일_입출력_문제\\검색_주문.dat");
		
		if(!memberFile.exists() || !orderFile.exists()) {
			System.out.println("파일의 경로를 찾을 수 없습니다.");
			return;
		}
		
		try {

			ArrayList<String[]> orders = new ArrayList<String[]>();

			//1. 주문 정보 저장
			if(orderFile.isFile()) {	
				
				BufferedReader reader = new BufferedReader(new FileReader(orderFile));
				
				String line = null;
				
				while((line = reader.readLine()) != null) {
					orders.add(line.split(","));
				}
				
				reader.close();
			}
			
			
			//2. 회원 검색 -> 회원이 존재하면 주문 출력하기
			if(memberFile.isFile()) {
				
				BufferedReader reader = new BufferedReader(new FileReader(memberFile));

				String result = "";
				String line = null;
				
				while((line = reader.readLine()) != null) {
					
					String[] memberInfo = line.split(",");
					
					if(memberInfo[1].equals(name)) { //이름
						
						for(String[] order : orders) {
							if(order[3].equals(memberInfo[0])) { //회원번호
								result+= String.format("%s\t%s\t%s\t%s\t%s\n"
														, memberInfo[0]
														, name
														, order[1]
														, order[2]
														, memberInfo[2]);
							}
						}
						
					}
				}

				reader.close();
				
				
				if(result != "") {
					System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
					System.out.println(result);
				} else {
					System.out.println("정보를 찾을 수 없습니다.");
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}

/*
	설계]
	1. 이름을 입력받아 
	2. 회원 검색 
		2.1 이름 검색
		2.2 일치하면 정보 split하여 저장
	3. 주문 정보를 검색 
		3.1 번호일치하면 저장
	4. 출력하시오.


*/