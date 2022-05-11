package com.test.java;

public class Item90 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 생성자 만들기 (2022. 3. 27. 오후 9:23:37)
		
		Developer d1 = new Developer();
		Developer d2 = new Developer("홍길동");
		Developer d3 = new Developer("홍길동", "Java");
	}	
}

class Developer {
	
	private String name;
	private String language;
	
	
	public Developer() {
		this("익명", "없음");
	}
	
	public Developer(String name) {
		this(name, "없음");
	}
	
	public Developer(String name, String language) {
		this.name = name;
		this.language = language;
	}

}