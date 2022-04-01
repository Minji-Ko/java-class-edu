package com.test.java.question.collection;

import java.util.ArrayList;

public class Q01_ArrayList {
	
	public static void main(String[] args) {
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("2");
		list2.get(0);
		list2.remove(1);
		list2.size();
		list2.set(0, "33");
		list2.add(0, "22");
		list2.indexOf("22");
		list2.lastIndexOf("22");
		list2.trimToSize();
		System.out.println(list2.size());
		list2.clear();
		System.out.println(list2.get(0));
		
//========================================================================================================
		
		TArrayList list = new TArrayList();
		
		list.add("바나나");
		list.add("사과");
		list.add("포도");
		list.add("딸기");
		
		System.out.println(list);

		list.add("귤");
		
		System.out.println(list);
		
	
		//System.out.println(list.get(5));
		
//========================================================================================================

		//배열 생성
//		MyArrayList list = new MyArrayList();
//		
//		//추가
//		list.add("홍길동");
//		list.add("아무개");
//		list.add("하하하");
//		list.add(5, "하하하");
//
//		//읽기
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//
//		//개수
//		System.out.println(list.size());
//
//		//탐색 + 읽기
//		for (int i=0; i<list.size(); i++) {
//		      System.out.println(list.get(i));
//		}
//
//		//수정
//		list.set(0, "우하하");
//		System.out.println(list.get(0));
//
//		//삭제
//		list.remove(1);
//		for (int i=0; i<list.size(); i++) {
//		      System.out.println(list.get(i));
//		}
//
//		//삽입
//		list.add(1, "호호호");
//		for (int i=0; i<list.size(); i++) {
//		      System.out.println(list.get(i));
//		}
//
//		//검색
//		if (list.indexOf("홍길동") > -1) {
//		      System.out.println("홍길동 있음");
//		} else {
//		      System.out.println("홍길동 없음");
//		}
//
//		//초기화
//		list.clear();
//		System.out.println(list.get(0));
//		System.out.println(list.size());
//	
	}
}
