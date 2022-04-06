package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

public class Q13 {

	public static void main(String[] args) {
		
/*
	 	요구사항]	성적을 확인 후 합격자/불합격자 명단을 출력하시오.
				> 합격 조건: 3과목 평균 60점 이상
				> 과락 조건: 1과목 40점 미만
		리소스]	파일 > 성적.dat
		데이터]	[이름,국어,영어,수학]
				홍길동,50,60,70
				아무개,100,80,50
				하하하,98,48,56
		출력]		[합격자] 
				홍길동 
				하하하 
				아무개 
				[불합격자] 
				호호호 
				후후후  
*/
		
		
		File file = new File("C:\\class\\java\\파일_입출력_문제\\성적.dat");
		
		if(!file.exists()) {
			System.out.println("파일의 경로를 찾을 수 없습니다.");
			return;
		}
		
		try {
			
			if(file.isFile()) {
				
				HashSet<Student> pass = new HashSet<Student>();
				HashSet<Student> fail = new HashSet<Student>();

				
				//1. 파일 내용 확인 + 합격자 분류
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line = null;
				
				while((line = reader.readLine()) != null) {
					
					String name = line.split(",")[0];
					int kor = Integer.parseInt(line.split(",")[1]);
					int eng = Integer.parseInt(line.split(",")[2]);
					int math = Integer.parseInt(line.split(",")[3]);
					
					if(kor >= 40 && eng >= 40 && math >=40 && (kor+eng+math)/3.0 >=60) {
						pass.add(new Student(name, kor, eng, math));
					} else {
						fail.add(new Student(name, kor, eng, math));
					}
					
				}
				
				reader.close();	
			
				
				//2. 합격자 출력  TODO 코드리뷰때 결과 비교
				System.out.println("[합격자]");
				
				Iterator<Student> passIter = pass.iterator();
				
				while(passIter.hasNext()) {
					System.out.println(passIter.next().getName());
				}
				
				System.out.println();
				
				
				//3. 불합격자 출력
				System.out.println("[불합격자]");
				Iterator<Student> failIter = fail.iterator();
				
				while(failIter.hasNext()) {
					System.out.println(failIter.next().getName());
				}
				
				
			} else {
				System.out.println("파일이 아닙니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return name + "[kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	
}

/*
		설계] 
		1. 파일 내용 읽기
		2. 성적 확인하기
		3. set 생성하여 합격자와 불합격자 분류 
		2. 합격자 명단 출력
		3. 불합격자 명단 출력
*/