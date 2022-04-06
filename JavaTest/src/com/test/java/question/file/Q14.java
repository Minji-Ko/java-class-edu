package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class Q14 {

	public static void main(String[] args) {

/*
 		요구사항]	이름을 입력받아 회원 정보를 검색 후 출력하시오.

		리소스]	파일 > 단일검색.dat > 1,유게무,광주시 강동구 다동, 010-3086-6664
		입력]		이름: 홍길동 
		출력]		[홍길동] 
				번호: 33 
				주소: 서울시 강남구 역삼동 
				전화: 010-2345-6789 
 */
		
		File file = new File("C:\\class\\java\\파일_입출력_문제\\단일검색.dat");
		
		if(!file.exists()) {
			System.out.println("파일의 경로를 찾을 수 없습니다.");
			return;
		}
		
		if(file.isFile()) {
		
			Scanner scan = new Scanner(System.in);
			
			System.out.print("이름: ");
			String name = scan.nextLine();
			
			scan.close();
			
			try {
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line = null;
				boolean find = false;
				
				while ((line = reader.readLine()) != null) {
					String[] data = line.split(",");
					
					if(data[1].equals(name)) {
						System.out.printf("[%s]\n번호: %s\n주소: %s\n전화:%s\n\n"
												, data[1]
												, data[0]
												, data[2]
						 						, data[3]);
						find = true;
					}	
				}
				
				if (find == false) {
					System.out.println("회원정보를 찾을 수 없습니다.");
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			

		}	
	}
}

/*
		설계]
		1. 이름을 입력받기
		2. 파일 내용 읽어보기
		3. 회원 정보를 검색 > split().[1]
		4. 바로 출력하기
			4.1 번호는 공백제거
		
		
*/