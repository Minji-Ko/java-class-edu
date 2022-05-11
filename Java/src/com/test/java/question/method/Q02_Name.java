package com.test.java.question.method;

public class Q02_Name {

	public static void main(String[] args) {
		
//		요구사항] 이름을 전달하면 이름 뒤에 '님'을 붙여서 반환하는 메소드를 선언하시오.
//		- String getNmae(String name)
//			- name : ㅇㅇㅇ(이름)
//			- return : ㅇㅇㅇ(이름)님
		String result;
		result = getName("홍길동");
		System.out.printf("고객: %s\n", result);
		
		result = getName("아무개");
		System.out.printf("고객: %s\n", result);
	
	}
	
	public static String getName(String name) {
		return name + "님";
	}
}

//		설계]
//		1. '님'붙여서 반환하는 메소드 선언하기 
//			- 메소드 인자는 String name
//			- return값으로 name + "님"
//		
//		2.String result 선언하기
//		
//		3. "홍길동"을 인자로 하는 메소드 호출하기
//		4. 호출된 값 result에 저장
//		5. printf()로 출력하기 
//		
//		6. "아무개"를 인자로 하는 메소드 호출하기
//		7. 호출된 값 String result에 저장
//		8. printf()로 출력하기 
