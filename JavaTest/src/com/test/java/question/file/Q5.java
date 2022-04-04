package com.test.java.question.file;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Q5 {

	public static void main(String[] args) {
		
//		요구사항]	이미지 파일이 있다. 확장자별로 파일이 몇 개 있는지 세시오.
//				> 새로운 확장자 파일이 추가돼도 동작이 가능하게 구현하시오.
//				> 'mouse.bmp' 추가를 하면.. 소스 수정 없이도 *.bmp : 1개 출력이 되게 하시오.
//		리소스]	폴더 > 확장자별 카운트
//		출력]		*.gif : 10개 
//				*.jpg : 5개 
//				*.png : 3개 

		String path = "C:\\class\\확장자별 카운트";
		File dir = new File(path);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		
		for(File f : dir.listFiles()) {
			String extension = f.getName().substring(f.getName().lastIndexOf(".") + 1);
			if(map.containsKey(extension)) {
				int value = map.get(extension) + 1;
				map.put(extension, value);
			} else {
				map.put(extension, 1);				
			}
		}
		
		Set<String> set = map.keySet();

		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.printf("*.%s : %d개\n", key, map.get(key));
		}
		
	}
}

//		설계]
//		1. 파일 객체만들기
//			1.1. listFiles()
//		2. 모든 파일의 확장자 추출
//			2.1. lastIndexOf() + substring()
//			2.2. hashset에 저장(x) -> hashMap(key:value)
//		3. 확장자별 카운트