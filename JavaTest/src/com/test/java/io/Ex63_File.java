package com.test.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ex63_File {

	public static void main(String[] args) {
		
		/*
		
			1. 파일/디렉토리 조작
			
			2. 파일 입출력
				- 자바 프로그램 <-> (데이터) <-> 저장 장치
				- 메모장
				
			3. 저장 장치(HDD, SSD)
				- 데이터 1,0으로 저장
				- 데이터의 자료형 존재X
				
				인코딩, Encoding
				- 문자 코드를(응용 프로그램의 데이터)를 부호화시키는 작업
				- 자바 프로그램("홍길동", String) -> 텍스트 파일("1010110101110")
				- ex)카톡메시지 전송 -> 인코딩 -> 디코딩 -> 카톡전송완료
				
				디코딩, Decoding
				- 부호 데이터를 문자코드로 변환하는 작업 
				- 텍스트 파일("1010110101110") -> 자바 프로그램("홍길동", String)
				
				인코딩/디코딩 규칙
				- 저장 장치 혹은 네트워크 상에서 데이터를 표현하는 규칙
				1. ISO-8859-1
				2. EUC-KR
				3. ANSI
				4. MS949
				5. UTF-8
				6. UTF-16
				
				ANSI(ISO-8859-1, EUC-KR, MS949) > 우리입장에서는 공통된 기능
				1. 영어(숫자, 특수문자, 서유럽): 1byte
				2. 한글(한자, 일본어 등): 2byte
				
				UTF-8 *** 이 인코딩을 사용한다.(국제 표준)
				1. 영어: 1byte
				2. 한글: 3byte   > 용량의 차이는 곧 비용발생!
				
				UTF-16
				1. 영어: 2byte
				2. 한글: 2byte
				
		*/

		//m1();
		//m2();
		//m3();
		//m4();
		
		//m5();
		//m6();
		//m7()
		//m8();
		
		String s;
		Integer n;
		
		
		//q07();
		//q08();
		//q09();
		q10();
		
		
	}//main
	
	private static void q10() {

		File dir = new File("C:\\class\\java\\file\\직원");
		
		File[] list = dir.listFiles();
		
		for(File file : list) {
			if(file.isFile()) {

				String filename = file.getName();
				
				//Parsing : 의미있는 부분들을 쪼개는 작업
				//"홍길동_2022_11.txt"; > 홍길동 : 2022 : 11
				//"홍길동_2022__11.txt"; > 홍길동 : 2022 : 빈방 : 11
				filename = filename.replace("__", "_");
				
				String[] temp = filename.split("_");
				//0 - 직원명
				//1 - 년도
				
				File newDirectory = new File(dir.getAbsoluteFile() + "\\" + temp[0] + "\\" + temp[1]);
				
				newDirectory.mkdirs();
				
				File moveFile = new File(dir.getAbsoluteFile() + "\\" + temp[0] + "\\" + temp[1] + "\\" + file.getName());
				
				file.renameTo(moveFile);
				
				
			}
		}
	}

	private static void q09() {
		
		File dir = new File("C:\\class\\크기 정렬");
		ArrayList<File> flist = new ArrayList<File>();
		
		searchFile(dir, flist);
		
		
		//크기순 정렬 > 버블 정렬
		for (int i=0; i<flist.size() -1; i++) {
			for (int j=0; j<flist.size()-i-1; j++	) {
				if(flist.get(j).length() < flist.get(j+1).length()) {
					
					File temp = flist.get(j);
					flist.set(j, flist.get(j+1));
					flist.set(j+1, temp);
				}
			}
		}
		
		for(File f : flist) {
			System.out.println(f.getName());
		}
	}

	private static void searchFile(File dir, ArrayList<File> flist) {

		File[] list = dir.listFiles();
		
		for(File f : list) {
			if(f.isFile()) {
				flist.add(f);
			}
		}
		
		for(File d : list) {
			if(d.isDirectory()) {
				searchFile(d, flist);
			}
		}
	}

	private static void q08() {

		File dir = new File("C:\\class\\폴더 삭제\\delete");
		
		//dir.delete();
		
		deleteDirectory(dir);
		
	}

	private static void deleteDirectory(File dir) {

		//1.
		File[] list = dir.listFiles();
		
		//2.
		for (File f : list) {
			if(f.isFile()) {
				f.delete();
			}
		}
		
		for (File d : list) {
			if(d.isDirectory()) {
				deleteDirectory(d);
				
			}
		}
		
		//여기까지 도달 > dir이 빈폴더가 되었음
		dir.delete();
		
	}

	private static void q07() {
		
		File dirA = new File("C:\\class\\동일 파일\\MusicA");
		File dirB = new File("C:\\class\\동일 파일\\MusicB");
		
		String[] listA = dirA.list();
		String[] listB = dirB.list();
		
		for (String s1 : listA) {
			for (String s2 : listB) {
				if(s1.equals(s2)) {
					System.out.println(s1);
					break;
				}
			}
		}
		
		//HashSet > 중복값
		//1. 수업 중
		//2. 안 배운 기능도 추가
		
		//Set > 집합 > 교집합, 합집합, 차집합..
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		
		set1.add("빨강");
		set1.add("주황");
		set1.add("노랑");
		set1.add("초록");
		set1.add("파랑");

		set2.add("빨강");
		set2.add("노랑");
		set2.add("파랑");
		set2.add("검정");
		set2.add("보라");
		
//		set1.addAll(set2); //set1 + set2 = 합집합
//		set1.retainAll(set2); //교집합
//		set1.removeAll(set2); //차집합
		
		HashSet<String> list1 = new HashSet<String>();
		HashSet<String> list2 = new HashSet<String>();
		
		for(String s: listA){
			list1.add(s);
		}
		for(String s: listB){
			list2.add(s);
		}
		
		list1.retainAll(list2);
		
		System.out.println(list1);
		
		
	}

	private static void m8() {

		
		try {
			
			File file = new File("C:\\Users\\kohmi\\git\\java-class-edu\\JavaTest\\src\\com\\test\\java\\Ex28_String.java");
			
			if (file.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line = null;
				int n = 1;
				
				
				while((line = reader.readLine()) != null) {
					System.out.printf("%3d|%s\n", n, line);
					n++;
				}
				
				reader.close();
				
				
				
			} else {
				System.out.println("읽을 파일이 존재하지 않습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m8");
			e.printStackTrace();
		}
		
		
		
	}

	private static void m7() {
		
		//파일쓰기
		//- FileWriter or BufferedWriter
		
		//파일 읽기
		//- BufferedReader > 대체제 없음
		
		try {
			//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //키보드 입력을 받는 부품
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\java\\file\\할일.txt")); //파일 입력을 받는 부품
			
			//int code = reader.read();
			
			//파일의 한줄을 읽기
//			String line = reader.readLine(); //사용자 경험 유지
//			System.out.println(line);
//			line = reader.readLine();
//			System.out.println(line);
//			line = reader.readLine();
//			System.out.println(line);
//			line = reader.readLine(); //읽을게 더이상 없으면 null
//			System.out.println(line); 
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			
			
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m7");
			e.printStackTrace();
		}
	}

	private static void m6() {
		
		//파일 읽기
		try {
			
		} catch (Exception e) {  //아무것도 안써놓으면 절대************* 안됌
			e.printStackTrace();
		}
		
		
		try {

			//FileWriter
			//FileReader
			
			FileReader reader = new FileReader("C:\\class\\java\\file\\할일.txt");
			
//			int code = reader.read();
//			System.out.println(code);
			
			int code = -1;
			
			while((code = reader.read()) != -1) {
				System.out.print((char)code);
			}
			
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m6");
			e.printStackTrace();
		}
		
		
	}

	private static void m5() {
		
		try {
			FileInputStream stream = new FileInputStream("C:\\class\\java\\file\\data.txt");
			
//			int code = stream.read();
//			System.out.println(code);
//			code = stream.read();
//			System.out.println(code);
//			code = stream.read();
//			System.out.println(code);
//			code = stream.read();
//			System.out.println(code);
//			code = stream.read();
//			System.out.println(code);
//			code = stream.read();
//			System.out.println(code); //-1
			
			int code = -1;
			
			while((code = stream.read()) != -1) {
				System.out.print((char)code);
			}
			
			
			
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m4() {
		
		//범용 도구
		//- 설정에 따라 다양한 소스를 입출력하는 도구
		//BufferedReader reader;
		//BufferedWriter writer;
	
		//전용 도구
		//- 파일을 대상으로 입출력하는 도구
		//- FileReader reader;
		//- FileWriter writer;
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\java\\file\\list.txt")); //범용도구는 손이 더 감
			
			writer.write("안녕하세요.");
			writer.newLine(); //writer.write("\n");
			writer.write("홍길동입니다.");
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		
		//메모장 쓰기 > 콘솔 버전
		try {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("저장할 파일명: ");
			String filename = scan.nextLine();
			
			FileWriter writer = new FileWriter("C:\\class\\java\\file\\" + filename + ".txt");
			
			boolean loop = true;
			
			while (loop) { //true로 적어도 되지만 boolean(불리언)변수를 만드는게 통제하기 더 쉬움
				
				System.out.print("입력: ");
				String line = scan.nextLine();

				if(line.equals("exit")) {
					loop = false;
				} else {
					writer.write(line); //한줄 입력 > 한줄 쓰기
					writer.write("\n");
				}
				
			}
			
			//자원 해제 코드, Clean-up Code > 은근히 성능차이를 가져옴
			scan.close();
			writer.close(); //****
			
			System.out.println("종료");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {

		//쓰기 스트림
		try {
//			FileWriter writer = new FileWriter("C:\\class\\java\\file\\data.txt");
			FileWriter writer = new FileWriter("C:\\class\\java\\file\\data.txt", true);
					
			writer.write("\n");
			writer.write("홍길동");		
			writer.write("\n");
			writer.write("아무개");		
			writer.write("\n");
			writer.write("하하하");		
			
			writer.close(); 
			
			//스트림은 닫으면 끝!!
			//java.io.IOException: Stream closed
			writer = new FileWriter("C:\\class\\java\\file\\data.txt", true);			
			writer.write("추가 기록");
			writer.close();
			
			System.out.println("종료");
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m1() {

		//파일 입출력
		
		//파일 쓰기 > 파일 출력
		//- 스트림 생성(도구)
		
		//쓰기 스트림 객체 
		//1. 생성 모드(=덮어쓰기), Create Mode > 더 많이 사용!!!
		//	- 기본방식
		//	a. 파일이 존재하지 않으면 자동으로 생성된다.
		//	b. 항상 파일을 덮어쓰기한다.
		
		//2. 추가 모드(=이어쓰기), Append Mode
		//	a. 파일이 존재하지 않으면 자동으로 생성한다.
		//	b. 파일이 존재하면.. 기존 내용을 그대로 두고, 추가로 데이터를 저장한다.
		try { 
			File file = new File("C:\\class\\java\\file\\data.txt"); 
			
			//스트림 열기
			//- 바이트 단위 쓰기(1byte)
			FileOutputStream stream = new FileOutputStream(file);
//			FileOutputStream stream = new FileOutputStream(file, true);
			
//			stream.write(65); //문자코드 
//			stream.write(66); 
//			stream.write(67); 
//			stream.write('가');
			
			String txt = "Hello~ Hong~";
			
			for(int i=0; i<txt.length(); i++) {
				stream.write(txt.charAt(i));
			}
			
			
			
			//스트림 닫기 ***
			//- 저장이 안된다.
			//- 잠긴 파일이 된다. (다른 프로그램이 건드릴 수 없음)
			stream.close(); 
			
			System.out.println("종료");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}//Ex63
