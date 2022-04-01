package com.test.java.question.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Q03_Queue {

	public static void main(String[] args) {
		
//		Queue<String> queue = new LinkedList<String>();
		
		//배열 생성
		MyQueue queue = new MyQueue();

		//추가
		queue.add("빨강");
		queue.add("노랑");
		queue.add("파랑");
		queue.add("주황");
		queue.add("검정");

		//읽기
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());

		//개수
		System.out.println(queue.size());

		//확인
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.size());

		//크기 조절
		queue.trimToSize();

		//초기화
		queue.clear();
		System.out.println(queue.size());
	}
}
