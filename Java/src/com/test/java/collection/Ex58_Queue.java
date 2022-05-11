package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Ex58_Queue {

	public static void main(String[] args) {
		
		//Queue
		//- 선입선출
		//- Queue는 인터페이스
		//- 자바는 Queue클래스는 만들지 않고, 자식 객체인 LikedList()를 생성함.
	
		Queue<String> queue = new LinkedList<String>();
	
		//1. 요소 추가하기
		//- boolean add(T value)
		queue.add("빨강"); //다른 언어에서는 주로 enque() > add()는 살짝 이해가 안가는 이름이기는 함
		queue.add("파랑");
		queue.add("노랑");
	
		
		//2. 요소 개수
		//- int size()
		System.out.println(queue.size());
		
		//3. 요소 읽기(=꺼내기)
		System.out.println(queue.poll()); //deque()
		System.out.println(queue.size());
		
		System.out.println(queue.poll()); 
		System.out.println(queue.size());
		
		System.out.println(queue.poll()); 
		System.out.println(queue.size());

		System.out.println(queue.poll()); //stack이랑 달리 empty이면 null을 반환
		System.out.println(queue.size());
		
		//4. 비었는지?
		System.out.println(queue.size() == 0);
		System.out.println(queue.isEmpty());
		
		//5. 요소 확인하기
		queue.add("주황");
		System.out.println(queue.peek());
		System.out.println(queue.size());

		//6. 
		queue.clear();
		System.out.println(queue.size());
	
	}
}

















