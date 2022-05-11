package com.test.java.question.file;

import java.io.File;

public class Q6 {

	public static void main(String[] args) {
		
//		요구사항] 	파일의 크기가 0byte인 파일만 삭제하시오.

//		리소스] 	폴더 > 파일 제거
//		출력]		총 34개의 파일을 삭제했습니다.
		
		String path = "C:\\class\\java\\파일_디렉토리_문제\\파일 제거";
		File dir = new File(path);
		
		int count = 0;
		
		for(File f : dir.listFiles()) { //파일검사
			if(f.length() == 0) {
				f.delete();
				count++;
			}
		}
		
		System.out.printf("총 %d개의 파일을 삭제했습니다.", count);
	}
}
//		설계] 
//		1. 파일 객체 생성 후 listFiles()
//		2. 크기가 0byte인지 알아내기
//		3. 삭제하면서 count