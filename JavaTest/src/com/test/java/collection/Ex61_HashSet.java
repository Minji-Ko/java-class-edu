package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ex61_HashSet {

	public static void main(String[] args) {
		
		/*
			
			1. List
				- 순서가 있는 데이터 집합 (******)
				- 첨자(방번호)
				- 데이터 중복을 허용한다.
				
			2. Set
				- 순서가 없는 데이터 집합
				- 식별자가 없다 > 방과 방을 구분할 수 없다.
				- 데이터 중복을 허용하지 않는다(************)
				
			3. Map
				- 순서가 없는 데이터 집합
				- 키 + 값 (*******)
				- 데이터 중복을 허용한다.
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}

	private static void m5() {
		
		//HashSet의 탐색(읽기)
		//- 방을 구분할 수 있는 방법이 없어서 > 식별자x
		//- Iterator 사용 > 컬렉션 탐색 도구의 일종
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("마우스");
		set.add("키보드");
		set.add("모니터");
		set.add("노트북");
		set.add("패드");  //TODO 내부적으로 어떻게 넣는지?
		System.out.println(set);
		
		Iterator<String> iter = set.iterator();
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());

//		System.out.println(iter.hasNext()); //set안에 가져올 데이터가 있나?
//		System.out.println(iter.next());	//가져와라
//		System.out.println(iter.hasNext()); //실제로 지워지진 않지만 한번 밖에 읽을 수 없음? TODO
//		System.out.println(iter.next());
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}

	private static void m4() {

		//p1과 p3의 상태가 동일함.
		// > 다른 사람!!
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("아무개", 25);
		Person p3 = new Person("홍길동", 20);
		Person p4 = new Person("홍길동", 25);
		
		//값형의 비교는 ==로 한다.
		//모든 참조형의 비교는 equals로 한다. > 문자열 포함
		System.out.println(p1.equals(p3)); //false
		
		System.out.println(p1.hashCode());
		System.out.println(p3.hashCode());
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p4));
		
		//** p1과 p3를 같은 사람으로 취급하고 싶다. > 어떻게 해야 하는지?
		//equals() >  hashcode비교
		//hashcode() > (name + age).hashcode
		
		
		//HashSet이 중복값을 체크할 때 equals()와 hashCode() 메소드를 사용한다.
		HashSet<Person> set = new HashSet<Person>();
		
		set.add(new Person("홍길동", 20)); //1.
		set.add(new Person("아무개", 25));
		set.add(new Person("테스트", 28));
		
		set.add(new Person("홍길동", 25)); //3.
		boolean result = set.add(new Person("홍길동", 20)); //3.
		System.out.println(result);
		
		System.out.println(set);
		
		
	}

	private static void m3() {
		
		HashSet<Person> set = new HashSet<Person>();
		
		set.add(new Person("홍길동", 20)); //1.
		set.add(new Person("아무개", 25));
		set.add(new Person("테스트", 28));

		set.add(new Person("홍길동", 25)); //2.
		set.add(new Person("홍길동", 20)); //3. 내부 데이터가 동일하지만 1번과는 다른 사람
		
		System.out.println(set); //1, 3 > HashSet의 반응? 모두 true

		
		
		//다른 객체 > hashCode가 다름
		Person p = new Person("하하하", 20);
		set.add(p);
		Person p2 = new Person("하하하", 20);
		set.add(p2);

		System.out.println(p.hashCode());
		System.out.println(p2.hashCode());

		
		//같은 객체 > hashCode가 같음
		String s1 = "홍";
		String s2 = "홍";
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		
		Person p3 = new Person("호호호", 25);
		set.add(p3);
		set.add(p3);  //중복 발생
		

		//하하하 vs 호호호
		//new의 호출 횟수!!! (객체생성 횟수 차이)
		//** Set은 객체를 취급할 때 > 메모리에 생성된 인스턴스를 구분한다.(주소값을 구분한다.)
		System.out.println(set); 
		
		
		
	}

	private static void m2() {

		//로또 번호 > 중복되지 않는 난수 발생
		
		//Case 1.
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		for(int i=0; i<6; i++) {
			boolean flag = false;
			int n = (int)(Math.random() * 45) + 1;
			
			for(int j=0; j<i; j++) {
				if(lotto.get(j) == n) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				i--; //중복O
			} else {
				lotto.add(n);
			}
		}
		
		System.out.println(lotto);
		
		
		//Case 2.
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		while(lotto2.size() < 6) { //회전수를 알 수 없음
			
			int n = (int)(Math.random() * 45) + 1;
			lotto2.add(n);
		}
		
		System.out.println(lotto2);
		
		
		
	}

	private static void m1() {
		
		//Collection > List, Set
		
		ArrayList<String> list = new ArrayList<String>();
		
		HashSet<String> set = new HashSet<String>();
		
		//요소 추가하기
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		
		set.add("사과");
		set.add("바나나");
		set.add("딸기");
	
		//요소 개수
		System.out.println(list.size());
		System.out.println(set.size());
		
		//덤프
		System.out.println(list);
		System.out.println(set);
		
		//요소 추가하기
		System.out.println(list.add("바나나"));
		System.out.println(list);
		
		System.out.println(set.add("바나나")); //Set은 중복값을 가질 수 없다.
		System.out.println(set);
		
		//요소 삭제
		list.remove(1);
		list.remove("바나나");
		
		set.remove("바나나");
		System.out.println(set);
	}
}

class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this("", 0);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		
		//원래 > 자신의 메모리 주소값을 반환
		
		//p1 > "홍길동", 20 > "홍길동20" > 100
		//p2 > "아무개", 25 > "아무개25" > 200
		//p3 > "홍길동", 20 > "홍길동20" > 100
		return (this.name + this.age).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
	
		//p1.equals(p3)
		//this == obj
		return this.hashCode() == obj.hashCode();
	}

}



