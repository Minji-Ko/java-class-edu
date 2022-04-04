package com.test.java.question.file;

import java.io.File;
import java.util.Scanner;

public class Q01 {

	public static void main(String[] args) {

//		요구사항] 	파일의 경로를 입력받아 파일 정보를 출력하시오.
//				> 파일 크기 단위 변환 출력(소수이하 1자리까지) : B, KB, MB, GB, TB
//		
//		입력]	파일 경로 : D:\class\java\file\test.txt 
//		출력]	파일명 : test.txt 
//			종류 : txt 파일 
//			파일 크기 : 45B 
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("파일 경로 : ");
		File file = new File(scan.nextLine());
		
		
		if(file.isFile()) {
			
			String name = file.getName();

			System.out.printf("파일명 : %s\n", name);
			
			if(name.contains(".")) {
				System.out.printf("종류 : %s 파일\n", name.substring(name.lastIndexOf(".") + 1));
			} else {
				System.out.println("종류 : 확장자 없음");
			}
			
			
			System.out.print("파일 크기 : ");

			long size = file.length();
			
			if (size < Math.pow(1024, 1)) {
				System.out.printf("%dB", size);
			} else if (size < Math.pow(1024, 2)) {
				double newSize = size / Math.pow(1024, 1);
				System.out.printf(newSize == (long)newSize ? "%dKB" : "%.1fKB"
																	, (long)newSize
																	, newSize);	
			} else if (size < Math.pow(1024, 3)) {
				double newSize = size / Math.pow(1024, 2);
				System.out.printf(newSize == (long)newSize ? "%dMB" : "%.1fMB"
																	, (long)newSize
																	, newSize);	
			} else if (size < Math.pow(1024, 4)) {
				double newSize = size / Math.pow(1024, 3);
				System.out.printf(newSize == (long)newSize ? "%dGB" : "%.1fGB"
																	, (long)newSize
																	, newSize);	
			} else {
				double newSize = size / Math.pow(1024, 4);
				System.out.printf(newSize == (long)newSize ? "%dTB" : "%.1fTB"
																	, (long)newSize
																	, newSize);	
			}
			
		} else {
			System.out.println("파일의 경로가 올바르지 않습니다.");
		}
		
	}
}
