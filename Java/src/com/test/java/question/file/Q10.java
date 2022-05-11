package com.test.java.question.file;

import java.io.File;

public class Q10 {

	public static void main(String[] args) {
		
//		요구사항]	아래의 조건에 따라 파일을 폴더별로 분류/이동하시오.
//				> 1차 : 직원 이름으로 폴더 생성
//				> 2차 : 년도별로 폴더 생성
//				> 3차 : 각 파일을 직원 > 년도 폴더에 이동
//		리소스] 	폴더 > 직원
//		출력]		분류가 완료되었습니다.
		
		
		String path = "C:\\class\\java\\파일_디렉토리_문제\\직원";
		File dir = new File(path);
		
		for(File file : dir.listFiles()) {
			if(file.isFile()) {
				String newPath = path + "\\" + file.getName().substring(0, file.getName().lastIndexOf("_")).replace("_", "\\"); //마지막"_"이전까지
			
				File subDir = new File(newPath);
				subDir.mkdirs();
				
				File newFile = new File(newPath + "\\" + file.getName());
				file.renameTo(newFile);
			}
		}
		
		System.out.println("분류가 완료되었습니다.");
	}
}
//		설계] 
//		파일 형식 : 아무게_2014_15
//		1. 파일명 얻기 
//		2. split(); 
//			2.1. 직원 이름으로 폴더 생성
//			2.2. 년도별로 폴더 생성
//			2.3. 각 파일을 직원 
//		3. 년도 폴더에 이동