package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Dummy {

	public static void main(String[] args) {
		//데이터 생성용
		try {
			createStudent();			
			createScore();
		} catch (Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
	}
	
	private static void createStudent() throws Exception {
		//1~10
		//System.out.println((int)(Math.random() * 10) +1);
		
		Random rnd = new Random();
		//System.out.println(rnd.nextInt()); //21억
		//System.out.println(rnd.nextInt(10)); //0~9
		
		
		//번호, 이름, 나이, 성별, 주소
		//1,홍길동,15,1,서울시 강남구 역삼동
		
		
		int size = 20;
		
		String[] name1 = { "김", "이", "박", "최", "정", "한", "유", "민", "고", "주" };
		String[] name2 = { "길", "동", "경", "지", "원", "미", "성", "민", "광", "연", "채", "수", "아", "진", "철", "석", "명", "형", "안", "인" };
		String[] address1 = { "서울시", "경기도", "제주시", "부산시", "울산시", "대구시" };
		String[] address2 = { "강남구", "강동구", "강서구", "강북구", "중구",};
		String[] address3 = { "역삼동", "대치동", "압구정동", "등촌동", "천호동" };
		
		File file = new File(DataPath.학생);
		System.out.println(file.exists());
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.학생));
		
		
		for (int i=0; i <size; i++) {
			int seq = i + 1;
			String name = name1[rnd.nextInt(name1.length)] 
						+ name2[rnd.nextInt(name2.length)] 
						+ name2[rnd.nextInt(name2.length)];
			int age = rnd.nextInt(3) + 14;
			int gender = rnd.nextInt(2) + 1;
			String address = address1[rnd.nextInt(address1.length)] + " "
							+ address2[rnd.nextInt(address2.length)] + " "
							+ address3[rnd.nextInt(address3.length)] + " "
							+ (rnd.nextInt(30) + 1) + "번지";

			//System.out.println(seq + "," + name + "," + address);
			
			writer.write(String.format("%d,%s,%d,%d,%s\n"
					, seq
					, name
					, age
					, gender
					, address));
		}
		
		writer.close();
		
		System.out.println("생성완료");
	
	}
	
	private static void createScore() throws Exception {
//		학생번호, 국어,영어,수학
//		1,100,80,90		
		
		//학생 20명 > 성적 3회 분량
		//학생번호는 다른 데이터파일과 연관되어 있어서 그 파일을 읽어야 함
		
		String temp = ""; //누적 변수
		
		Random rnd = new Random();

			for(int j=0; j<3; j++) {
				BufferedReader reader = new BufferedReader(new FileReader(DataPath.학생));
				
				String line = null;
				
				while((line = reader.readLine()) != null) {
					
					String seq = line.split(",")[0];
					
					int kor = rnd.nextInt(51) + 50;
					int eng = rnd.nextInt(51) + 50;
					int math = rnd.nextInt(51) + 50;
					
					temp += String.format("%s,%d,%d,%d\n", seq, kor, eng, math);
					System.out.print(temp);
				}

			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.성적));
			writer.write(temp);
			writer.close();
			
			System.out.println("등록 완료");
	}
}















