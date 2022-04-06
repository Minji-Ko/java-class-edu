package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	      3    홍길동     마우스          3    서울시 강동구 천호동
	 
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
			
			BufferedReader reader = new BufferedReader(new FileReader(memberFile));
			
			HashMap<String, String> Info = new HashMap<String, String>();
			
			if(memberFile.isFile()) {
				
				String line = null;
				
				while((line = reader.readLine()) != null) {
					
					String[] temp = line.split(",");
					
					if(temp[1].equals(name)) {
						Info.put("번호", temp[0]);
						Info.put("이름", temp[1]);
						Info.put("배송지", temp[2]);
						break;
					}
				}
					
				if(line == null) {
					System.out.println("회원 정보를 찾을 수 없습니다.");
				}
				
				reader.close();
				
				//3.
				reader = new BufferedReader(new FileReader(orderFile));
				
				if(line != null && orderFile.isFile()) {
					
					line = null;
					StringBuilder result = new StringBuilder("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]\n");
					
					while((line = reader.readLine()) != null) {
						
						String[] temp = line.split(",");
						
						if(temp[3].equals(Info.get("번호"))) {
							
							result.append(Info.get("번호"));
							result.append("\t");
							result.append(Info.get("이름"));
							result.append("\t");
							result.append(temp[1]); //상품명
							result.append("\t");
							result.append(temp[2]); //개수
							result.append("\t");
							result.append(Info.get("배송지"));
							result.append("\n");
						}
					}
						
				
					System.out.println(result);
					
				}
			}
			
			reader.close();

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