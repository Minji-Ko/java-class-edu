package com.test.java.question.collection;


public class Q05_HashSet {

	public static void main(String[] args) {
		
		MySet list = new MySet();
		
		System.out.println(list.add("1"));
		System.out.println(list.add("2"));
		System.out.println(list.add("3"));
		System.out.println(list.add("4"));
		System.out.println(list.add("5"));
		
		System.out.println(list);
	
		System.out.println(list.next());
		System.out.println(list.next());
		System.out.println(list.next());
		System.out.println(list);

		list.add("6");
		list.remove("1");
		System.out.println(list);
		System.out.println(list.next());
		System.out.println(list);
		list.remove("5");
		System.out.println(list);
		list.add("7");
		list.add("8");
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.next());
		
		list.clear();
		System.out.println(list);
		System.out.println("================");
		System.out.println(list.hasNext());

		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");

		//개수
		System.out.println(list.size());

		//삭제
		list.remove("아무개");

		//개수
		System.out.println(list.size());

		//탐색 + 읽기
		while (list.hasNext()) {
		      System.out.println(list.next());
		}


		System.out.println(list);
		
		
	}
}
