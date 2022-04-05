package com.test.java.question.file;

import java.io.File;
import java.util.HashMap;

public class Q8 {

	public static void main(String[] args) {
		
//		요구사항] 내용물이 있는 'delete' 폴더를 삭제하시오.
//				> 재귀 메소드 사용
//				> 삭제된 파일과 자식 폴더 개수를 출력하시오.
//		리소스] 	폴더 > 폴더 삭제
//		출력]		폴더를 삭제했습니다. 
//				삭제된 폴더는 3개이고, 파일은 6개입니다.
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("countFile", 0);
		map.put("countDir", 0);
		
		String path = "C:\\class\\java\\파일_디렉토리_문제\\폴더 삭제\\delete";
		
		String result = delete(map, path);
		
		System.out.println(result);
		
	}

	private static String delete(HashMap<String, Integer> map, String path) {
		
		File dir = new File(path);
		
		for(File subFile : dir.listFiles()) {
			if(subFile.isFile()) {
				subFile.delete();
				map.put("countFile", map.get("countFile") + 1);
			}
		}
		
		for(File subDir : dir.listFiles()) {
			if(subDir.isDirectory()) {
				delete(map, subDir.getAbsolutePath());
				subDir.delete();
				map.put("countDir", map.get("countDir") + 1);
			}
		}
		
		//dir.delete(); //subDir.delete() 대신 여기에서 dir 삭제!
		
		return String.format("삭제된 폴더는 %d개이고, 파일은 %d개입니다.\n", map.get("countDir"), map.get("countFile"));
	}
}
//		설계]
//		1. 객체 생성후 listFiles() 
//			1.1. 파일이면 삭제
//			1.2. 폴더면 반복
//		2. 삭제되는 파일 및 폴더 개수 count