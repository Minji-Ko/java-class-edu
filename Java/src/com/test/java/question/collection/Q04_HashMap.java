package com.test.java.question.collection;

import java.util.HashMap;

public class Q04_HashMap {

	public static void main(String[] args) {
		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("아", "1");
//		System.out.println(map1.get("이"));
		
		long begin = System.nanoTime();
		
		MyHashMap map = new MyHashMap();
		for(int i=0; i<100000; i++) {
			map.put(String.valueOf(i), "o");
		
		}
		for(int i=0; i<100000; i++) {
			map.remove(String.valueOf(i));
		}
//		System.out.println(map.size());
//	
//		System.out.println(map.get(""));
//		map.put("3", "오");
//		map.remove("3");
//		map.put("10","십");
//		map.put("11","십일");
//		
//		System.out.println(map);
//		
//		map.trimToSize();
//		System.out.println(map);
//		
//		map.clear();
//		System.out.println(map.get("2"));
//		System.out.println(map.containsKey("1"));
//		System.out.println(map.containsKey("2"));
		
		long end = System.nanoTime(); 
		
		System.out.print(end - begin);  //(2)12368327500 << (1)11881667200
										//(2)42997738900 << (1)33456815300
		
//		//배열 생성
//		MyHashMap map = new MyHashMap();
//
//		//추가
//		map.put("국어", "합격");
//		map.put("영어", "불합격");
//		map.put("수학", "보류");
//
//		//읽기
//		System.out.println(map.get("국어"));
//		System.out.println(map.get("영어"));
//		System.out.println(map.get("수학"));
//
//		//개수
//		System.out.println(map.size());
//
//		//수정
//		map.put("영어", "합격");
//		System.out.println(map.get("영어"));
//
//		//삭제
//		map.remove("영어");
//		System.out.println(map.get("영어"));
//
//		//검색(key)
//		if (map.containsKey("국어")) {
//		      System.out.println("국어 점수 있음");
//		} else {
//		      System.out.println("국어 점수 없음");
//		}
//
//		//검색(value)
//		if (map.containsValue("합격")) {
//		      System.out.println("합격 과목 있음");
//		} else {
//		      System.out.println("합격 과목 없음");
//		}
//
//		//초기화
//		map.clear();
//		System.out.println(map.size());
		
	}
	
}
