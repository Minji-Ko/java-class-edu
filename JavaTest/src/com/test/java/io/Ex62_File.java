package com.test.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex62_File {
	
	//누적 변수
	private static int count = 0;

	public static void main(String[] args) {
		
		/*
		 	1. 파일/디렉토리 조작
		 		- 윈도우 탐색기로 하는 행동
		 		- 파일 > 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등
		 		- 폴더 > 정보 확인, 새로 만들기, 이름 바꾸기, 이동하기, 삭제하기 등  
		 		
		 	2. 파일 입출력
		  		- 파일 > 읽기/쓰기 
		  		- 텍스트 입출력
		  		- 메모장, 이클립스 등
		  
		 */
	
		//m1();
		//m2();
		
		//파일 조작 > 생성, 파일명 수정, 이동, 삭제, 복사(메소드 존재x)
		//m3();
		//m4();
		//m5();
		//m6();
		
		//디렉토리
		//m7();
		//m8();
		//m9();
		//m10();
		//m11();
		//m12();
		
		//m13();
		//m14();
		//m15();
		m16();
		

		//파일(폴더) > 생성, 이름 수정, 이동, 삭제
		//폴더 	> 내용보기(listFiles())
		//		> 재귀 호출(폴더 탐색)***

	}
	
	private static void m16() {
		//List -> 순서 존재 -> 루프 사용(방번호, Iterator)
		//Set -> 순서 없음 -> 루프 사용(Iterator)
		//Map -> 순서 없음 -> 루프 사용X
		
		//Map 루프 돌리는 방법
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		
		//HashSet(C) > Set(I)
		Set<String> set = map.keySet(); //HashMap의 key들로만 구성된 Set
		Collection<String> values = map.values(); //value들로만 구성된 Collection
		
		System.out.println(set);
		System.out.println(values);
		
		Iterator<String> iter = set.iterator();
		
		//향상된 for문 구조
		while(iter.hasNext()) {
			//System.out.println(iter.next()); //소비(Stack, Queue 유사)
			
			String key = iter.next();
			System.out.println(key + ":" + map.get(key));
		}
		
		
	}

	private static void m15() {

		//폴더의 내용 보기 + 업무 추가
		// > 특정 폴더의 모든 파일 개수 세기?
		
		//파일 12,136, 폴더 2,639, 크기 808,578,159 바이트
		
		String path = "C:\\class\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			countFile(dir);
			
			System.out.printf("총 파일 개수: %,d개\n", count);
		}
	}

	private static void countFile(File dir) {
		
		//파일 개수 누적
		//1. 목록 가져오기
		File[] list = dir.listFiles();
		
		//2. 파일개수
		for (File subfile : list) {
			if (subfile.isFile()) {
				count++;
			} 
		}
		
		//3. 자식 폴더를 대상으로 1~2번을 반복
		for(File subdir : list) {
			if (subdir.isDirectory()) {
				//1~3번까지 반복
				countFile(subdir);
			}
		}
		
//		//폴더 개수 누적
//		//1. 목록 가져오기
//		File[] list = dir.listFiles();
//		
//		//2. 자식 폴더를 대상으로 1~2번을 반복
//		for(File subdir : list) {
//			if (subdir.isDirectory()) {
//				count++;              //***
//				countFile(subdir);
//			}
//		}
		
//		//파일 크기 누적
//		//1. 목록 가져오기
//		File[] list = dir.listFiles();
//		
//		//2. 파일개수
//		for (File subfile : list) {
//			if (subfile.isFile()) {
//				count+= subfile.length();  //***
//			} 
//		}
//		
//		//3. 자식 폴더를 대상으로 1~2번을 반복
//		for(File subdir : list) {
//			if (subdir.isDirectory()) {
//				//1~3번까지 반복
//				countFile(subdir);
//			}
//		}
		
		
	
	}

	private static void m14() {
		
		//폴더의 내용 보기 + 업무 추가
		// > 특정 폴더의 모든 파일 개수 세기?
		
		//파일 12,136, 폴더 2,639, 크기 808,578,159 바이트
		
		String path = "C:\\class\\eclipse";
		File dir = new File(path);
		
		int count = 0; //누적 변수
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for(File subfile : list) {
				if(subfile.isFile()) {
					count++;
				}
			}
			
			//자식 폴더 접근
			for(File subdir : list) {
				
				//자식 폴더의 내용물
				if(subdir.isDirectory()) {
					File[] sublist = subdir.listFiles();
					
					for(File subsubfile : sublist) {
						if(subsubfile.isFile()) {
							count++;
						}
					}
					
					//자식의 자식 폴더 접근
					for (File subsubdir : sublist) {
						if(subsubdir.isDirectory()) {
							
							//손자 폴더의 내용물
							File[] subsublist = subsubdir.listFiles();
							
							for (File subsubsubfile : subsublist) {
								if(subsubsubfile.isFile()) {
									count++;
								}
							}
						}
					}
					
				}
			}
			
			
			System.out.printf("총 파일 개수: %,d개\n", count);
		}
		
		
		
	}

	private static void m13() {
		
		//폴더의 내용 보기
		
		File dir = new File("C:\\class\\eclipse");
		
		if(dir.exists()){
			
			//자식 파일명 + 자식 폴더명
//			String[] list = dir.list();
//			
//			for(String f : list) {
//				//이름 사용 > File 객체 생성 > isFile(), isDirectory()
//				System.out.println(f);
//				
//				File file = new File(dir.getAbsolutePath() + "\\" + f);
//				System.out.println(file.isFile());
//				System.out.println();
//			}
		
			//자식 파일 + 자식 폴더 -> File 배열
//			File[] list = dir.listFiles();
//			
//			for(File f : list) {
//				System.out.println(f.isDirectory());
//				System.out.println(f.getName());
//				System.out.println();
//			}
		}
		
		
		//탐색기 느낌
		File[] list = dir.listFiles();
		
		for(File d: list) {
			if(d.isDirectory()) {
				System.out.printf("[%s]\n", d.getName());
			}
		}
		
		for (File f : list) {
			if(f.isFile()) {
				System.out.printf("%s\n", f.getName());	
			}
		}
	}

	private static void m12() {

		//폴더 삭제하기
		//- 빈폴더만 삭제 가능하다.
		File dir = new File("C:\\class\\java\\file\\aaa");
		
		if(dir.exists()) {
			System.out.println(dir.delete());
		}
	}

	private static void m11() {
		
		//폴더 이동하기
		File dir = new File("C:\\class\\java\\file\\todo");
		File dir2 = new File("C:\\class\\java\\move\\todo");
		
		if(dir.exists()) {
			System.out.println(dir.renameTo(dir2));
		}
		
	}

	private static void m10() {

		//폴더명 바꾸기
		File dir = new File("C:\\class\\java\\file\\할일");
		File dir2 = new File("C:\\class\\java\\file\\todo");
		
		if(dir.exists()) {
			System.out.println(dir.renameTo(dir2));
		}
		
	}

	private static void m9() {
		
		//요구사항] 할일 > 날짜별 폴더 > "2022-01-01"~"2022-12-31"
		Calendar c1 = Calendar.getInstance();
		c1.set(2022, 0, 1);
		
//		System.out.println(c1.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		for(int i=0; i<c1.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			String path = String.format("C:\\class\\java\\file\\할일\\%tF", c1);
			
			File dir = new File(path);
			
			System.out.println(dir.mkdir());
			
			c1.add(Calendar.DATE, 1);
			
		}
		
		System.out.println("종료");
	} 

	private static void m8() {
		
		//요구사항] 회원 > 회원명으로 개인 폴더 생성
		String[] member = { "홍길동", "아무개", "하하하", "호호호","후후후" };
		
		for(int i=0; i<member.length; i++) {
			
			String path = String.format("C:\\class\\java\\file\\회원\\[개인폴더]%s님", member[i]);
		
			File dir = new File(path);
			
			System.out.println(dir.mkdir()); //log..
		}
	
	}

	private static void m7() {

		//폴더 생성하기
		
//		File dir = new File("C:\\class\\java\\file\\aaa");
//		
//		if(!dir.exists()) {
//			System.out.println(dir.mkdir());
//		} else {
//			System.out.println("이미 같은 이름의 폴더가 존재함.");
//		}
		

		File dir = new File("C:\\class\\java\\file\\bbb\\ccc");
		
		if(!dir.exists()) {
			//System.out.println(dir.mkdir()); //false
			System.out.println(dir.mkdirs()); 
			
		} else {
			System.out.println("이미 같은 이름의 폴더가 존재함.");
		}
		
	}

	private static void m6() {

		//파일 삭제하기
		File file = new File("C:\\class\\java\\file\\data.txt");
		
		if (file.exists()) {
			//휴지통 > 폴더이동
			System.out.println(file.delete());  //진짜 삭제 = 휴지통 비우기
		}
		
	}

	private static void m5() {

		//파일 이동하기
		//- file/hello.txt > move/hello.txt
		File file = new File("C:\\class\\java\\file\\hello.txt");  
		File file2 = new File("C:\\class\\java\\move\\hello.txt");  //가상의 경로
		
		if(file.exists()) {
			System.out.println(file.renameTo(file2));
		}
		
	}

	private static void m4() {
		
		//파일명 바꾸기
		//- hello.txt -> hi.txt
		File file = new File("C:\\class\\java\\file\\hello.txt");  
		File file2 = new File("C:\\class\\java\\file\\hi.txt");  
		
		if(file.exists()) {
			
			//file(hello.txt) -> file2(hi.txt)
			System.out.println(file.renameTo(file2));
		}
		
		
	}

	private static void m3() {
		
		//새파일 만들기
		File file = new File("C:\\class\\java\\file\\hello.txt");  //가상의 경로로 파일참조객체 생성

		if (!file.exists()) {
			try {
				//if(!file.exists())를 하지 않아도 > 동일한 파일이 존재하면 새로 만들기 실패(false)
				System.out.println(file.createNewFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("이미 동일한 파일이 존재합니다.");
		}
		
	}

	private static void m2() {

		//폴더 > 정보
		//- 폴더(Folder), 디렉토리(Directory)
		
		//경로
		final String PATH = "C:\\class\\java\\file";  
		
		//디렉토리 참조 객체
		//- 디렉토리(폴더)는 파일이다.
		File dir = new File(PATH);
		
		if (dir.exists()) {
			System.out.println("폴더 있음");
			
			//정보
			System.out.println(dir.getName());			//file
			System.out.println(dir.isFile());			//false > 파일이니?
			System.out.println(dir.isDirectory());		//true  > 디렉토리니?
			
			System.out.println(dir.length());			//0 > 폴더크기(byte) ***
			System.out.println(dir.getAbsolutePath()); 	//C:\class\java\file
			System.out.println(dir.getPath());			//C:\class\java\file
			
			System.out.println(dir.lastModified());		//1649031808609 > tick
			System.out.println(dir.isHidden());			//false
			
			System.out.println(dir.getParent());		//C:\class\java
			
			
		} else {
			System.out.println("폴더 없음");
		}
	}
	
	private static void m1() {
		
		//파일 > 정보
		
		//자바에서 외부의 파일을 접근!!
		//1. 외부 파일을 참조하는 참조 객체 생성 > 대리자, 위임자
		//2. 참조 객체 조작 > 외부 파일에 적용
		
		//경로
		final String PATH = "C:\\class\\java\\file\\data.txt";   //변경을 잘 안해서 상수로
		
		//파일 참조 객체 > java.io.File
		//	- file 객체 == data.txt
		File file = new File(PATH);
		
		//System.out.println(file.exists()); //외부에서 조작할 수 있기에 반드시 실제로 존재하는지 파악해야함!!
		
		if (file.exists()) {
			System.out.println("파일 있음");
		
			//정보
			System.out.println(file.getName());			//data.txt
			System.out.println(file.isFile());			//true  > 파일이니?
			System.out.println(file.isDirectory());		//false > 디렉토리니?
			
			System.out.println(file.length());			//67 > 파일크기(byte)
			System.out.println(file.getAbsolutePath()); //C:\class\java\file\data.txt
			System.out.println(file.getPath());			//C:\class\java\file\data.txt
			System.out.println(file.lastModified());	//1649031852450 > tick
			System.out.println(file.isHidden());		//false
		
			//tick -> 년월일시분초
			Calendar c1 = Calendar.getInstance();
			System.out.println(c1.getTimeInMillis());
			c1.setTimeInMillis(file.lastModified()); //c1를 수정
			
			System.out.printf("%tF %tT\n", c1, c1);

		
		} else {
			System.out.println("파일 없음");
		}
				
	}
}


















