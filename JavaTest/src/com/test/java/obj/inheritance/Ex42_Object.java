package com.test.java.obj.inheritance;

public class Ex42_Object {

	public static void main(String[] args) {
		
		//Object 클래스
		//- 사용자가 만드는 모든 클래스는 자동으로 Object 클래스를 상속받는다.
		//- 모든 클래스의 근원 클래스, Root Class
		//- 모든 클래스는 Object 클래스로부터 파생된다. > 단군 할아버지 
		//- Object 멤버는 모든 클래스에게 상속된다. > 모든 클래스들에 필요하다고 생각하는 공통기능을 구현해놓음.
		
		//Class Object is the root of the class hierarchy.
		//Every class has Object as a superclass. 
		//All objects,including arrays, implement the methods of this class.
		Object o1 = new Object();  //object의 객체를 만들 일은 없음! > 자식을 위한 멤버 구현
		
		int[] list = new int[5];
		//list.
		
		Test t1 = new Test();
		
		
	} //main
} //Ex42

class Test {
	public int a;
	public int b;
}

class Other extends Test { //Object클래스를 직접 상속x, Object클래스를 상속받는 Test로부터 간접 상속o
	public int c;
	public int d;
}