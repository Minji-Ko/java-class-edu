package com.test.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mylibrary.util.MyUtil;

public class Ex64_File {

	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}

	private static void m4() {
		
		ArrayList<User> list = new ArrayList<User>();
	
		//매개변수가 전달되는 방식
		//1. 값형 > Call by value
		//2. 참조형 > Call by reference
		load(list);
		
		for (User u : list) {
			System.out.printf("%s.%s(%d세)\n"
									, u.getNo()
									, u.getName()
									, u.getAge());
		}
		System.out.println();

		for (User u : list) {
			if(u.getAge() >= 22) {
				System.out.printf("%s.%s(%d세)\n"
									, u.getNo()
									, u.getName()
									, u.getAge());
			}
		}
	

		//데이터 수정
		//- 나이가 많은 사람을 표시
		//- 홍길동 > 홍길동(*)
		for (User u : list) {
			if(u.getAge() >= 22) {
				u.setName(u.getName() + "(*)");
			}
		}
		
		System.out.println(list);
		
		//데이터 삭제
		list.remove(2);
		
		
		//메모리(배열) > 텍스트 파일 반영
		save(list);
		
	
	}
	
	private static void save(ArrayList<User> list) {

		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.MEMBER));
			
			//User 1개 -> 1,홍길동,20 -> writer.write()
			for(User u : list) {
				writer.write(String.format("%s,%s,%d\n"
												, u.getNo()
												, u.getName()
												, u.getAge()));
			}
			
			writer.close();
			
		} catch (Exception e) {
			//handle exception
			System.out.println("Ex64_File.save");
			e.printStackTrace();
		}
	
	}

	private static void load(ArrayList<User> list) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				//1,홍길동,20
				String[] temp = line.split(",");
				
				//텍스트 파일 1줄 > User 객체 1개
				User user = new User(temp[0], temp[1], Integer.parseInt(temp[2]));
				
				list.add(user);
				
				
			}
			
		} catch (Exception e) {
			System.out.println("Ex64_File.load");
			e.printStackTrace();
		}
	}

	private static void m3() {
		
		//파일 읽기
		try {
		
			//데이터 파일 구조 > Scheme(스키마)
			//CSV, Comma-Separated Values
			//번호,이름,나이
			//1,홍길동,20
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				System.out.printf("%s.%s(%s세)\n", temp[0], temp[1], temp[2]);
			}
			System.out.println();
			
			reader.close();
			
			
			//22세 이상 목록 다시 출력
			//스트림 객체를 다시*** 생성 > 생성 직후 커서는 BOF에 위치
			//리더는 재사용이 불가능
			reader = new BufferedReader(new FileReader(Data.MEMBER));
						
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if(Integer.parseInt(temp[2]) >=22) {
					System.out.printf("%s.%s(%s세)\n", temp[0], temp[1], temp[2]);
				}
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex64_File.m3");
			e.printStackTrace();
		}
	}

	private static void m2() {
		
		//파일 수정
		//1. 기존 내용을 출력한다 > 읽기
		//2. 내용의 일부를 수정한다.
		//3. 저장한다.
		
		try {
			
			//1.
			BufferedReader reader 
				= new BufferedReader(new FileReader(Data.EDIT));
			
			System.out.println("[현재 내용]");
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			reader.close();
			
			
			//2.
			Scanner scan = new Scanner(System.in);
			
			System.out.println("[수정 내용]");
			String input = scan.nextLine();
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.EDIT));
			
			writer.write(input);
			writer.close();
			
			//자바에서 콘솔 수정 작업은 굉장히 불편함 > 일부 영역을 따로 수정하는 행동지원x
			//지구상의 모든 프로그램의 수정작업은 덮어쓰기!
			System.out.println("수정 완료"); 
			
		} catch (Exception e) {
			System.out.println("Ex64_File.m2");
			e.printStackTrace();
		}
	}

	private static void m1() {
		
		//읽고 쓰는 파일의 위치
		//1. 프로젝트 폴더 외부
		//2. 프로젝트 폴더 내부
		//- 관리 용이
		//- 프로젝트 위치 이동 > 파일 같이
		
		try {
			
			/*
			 	콘솔 명령어
			 	
				C:\Users\kohmi> _
				현재 위치> 프롬프트
			
			 	1. dir
			 		- 현재 디렉토리의 목록(내용물)을 보여주세요.
			 	2. cd
			 		- change directory
			 		- cd 자식폴더명		> 자식폴더로 이동
			 		- cd .. 		> 부모폴더로 이동
			  	
			  		
			  	자원 경로 표현법
			  	1. 절대 경로
			  		- 기준점: 절대 위치
			  		- ex) 홍길동, A5열에 앉아 있는 사람
			  		- C:\class\java\data.txt
			  		
			  	2. 상대 경로
			  		- 기준점: 상대 위치
			  		- ex) 나, 앞에 앉아 있는 사람
			  		- .\data.txt		> 시작을 .(현재 위치)으로
			  		- .\file\member.txt
			  		
			  		
			  	프로젝트 팀작업 (**** 혼동 주의) > 무조건 상대경로로!
			  	A팀원
			  	- C:
			  	- D:\java\data 폴더에 데이터 넣어서 관리
			  	
			  	B팀원
			  	- C:\java\data 폴더에 데이터 넣어서 관리
			  	
			  	C팀원
			  	- C:\Users\in\Downloads\data 관리..
			 */
				
			File file = new File("."); //현재 폴더
			System.out.println(file.getAbsolutePath()); //자바프로그램은 프로젝트 폴더를 현재 위치로 생각함
			System.out.println(file.getPath());			//File 생성때 표현을 그대로 반환

			
			//File projectFile = new File(".\\data\\data.txt"); //프로젝트 폴더 > 상대경로로!
			File projectFile = new File("data\\data.txt"); //프로젝트 폴더 > 상대경로로!
			
			
			//파일 수정하기(****)
			//- 파일 입출력(스트림)에는 수정이라는 행동이 없다.
			//- 덮어쓰기로 구현한다.
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(projectFile));
			
			writer.write("테스트");
			writer.close();
			
			System.out.println("종료");

			
		} catch (Exception e) {
			System.out.println("Ex64_File.m1");
			e.printStackTrace();
		}

	
	}

}

class User {
	
	//번호,이름,나이
	//1,홍길동,20
	
	private String no;
	private String name;
	private int age;
	
	
	
	public User(String no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
		return "User [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
