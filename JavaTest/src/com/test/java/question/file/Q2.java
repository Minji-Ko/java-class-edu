package com.test.java.question.file;

import java.io.File;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
//		요구사항]	지정한 폴더의 특정 파일(확장자)만을 출력하시오.
//				> 확장자 대소문자 구분없이 검색 가능
//		입력]	폴더: C:\class\eclipse 
//			확장자: exe 
//		출력]	eclipse.exe 
//			eclipsec.exe
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("폴더: ");
		File dir = new File(scan.nextLine());
		
		System.out.print("확장자: ");
		String extension = scan.nextLine().toLowerCase(); //대소문자 구분없이!!
		
		
		if(dir.exists()) {

			boolean noFile = true;
			
			for(File f : dir.listFiles()) {
				if(f.isFile()) {
					if(f.getName().toLowerCase().contains("." + extension)) { //endsWith(extension)
						System.out.println(f.getName());
						noFile = false;
					}
				}
			}

			if(noFile == true) {
				System.out.println(extension + " 파일이 없습니다.");
			}
		} else {
			System.out.println("폴더를 찾을 수 없습니다.");
		}
		
	}
}
