package com.test.java.collection;

import java.util.HashMap;
import java.util.TreeMap;

public class Ex71_TreeMap {

	public static void main(String[] args) {
		
		//Tree + Map
		//- 이진트리 구조의 Map
		//- 자동정렬 + 범위 검색(추출) 용이
		
		//TODO treemap, treeset이 더좋은거 같은데 왜 hashmap, hashset을 더 자주사용하지..? (2022. 4. 8. 오전 11:22:07)
		
		TreeMap<String, String> map = new TreeMap<String, String>(); 
//		HashMap<String, String> map = new HashMap<String, String>(); 
		
		map.put("while", "하양");
		map.put("black", "검정");
		map.put("yellow", "노랑");
		map.put("red", "빨강");
		map.put("blue", "파랑");
		
		System.out.println(map);
		
		System.out.println(map.firstKey());
		System.out.println(map.firstEntry()); //MyHashMap > key + value
		System.out.println(map.lastKey());
		System.out.println(map.lastEntry());
		
		System.out.println(map.headMap("r"));
		System.out.println(map.tailMap("r"));
		System.out.println(map.subMap("r", "w"));
		
		
		/*
		 	**** 길이 가변
		 	* 처음 선택(1,5,7) > 상황에 맞춰(2,3,4,6,8)
		 
			List
			1. ArrayList	> 배열이 필요할 때, 삽입/삭제(x)	(<-Vector(legacy)) 
			2. LinkedList	> ArrayList 대체제 + 삽입/삭제
			3. Stack		> 스택구조
			4. Queue		> 큐 구조
			
			Set
			5. HashSet	> 중복값 배제 집합이 필요할 때
			6. TreeSet	> 5 + 정렬
			
			Map
			7. HashMap	> 키/값의 배열이 필요할 때		(<-HashTable(legacy))
			8. TreeMap	> 7 + 정렬
			
			
		 */
		
		
		
		
	}
}







