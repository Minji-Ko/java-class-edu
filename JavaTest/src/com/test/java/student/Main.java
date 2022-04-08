package com.test.java.student;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		/*
		 
		 	학생 관리 프로그램
		 	- 프로젝트 가이드
		 	- 파일입출력 + 컬렉션
		 	- 기본 행동 : 생성하기, 읽기, 수정하기, 삭제하기 > CRUD
		 		- 학생 정보 추가하기(C)
		 		- 학생 정보 목록보기(R)
		 		- 학생 정보 상세보기(R)
		 		- 학생 정보 수정하기(U)
		 		- 학생 정보 삭제하기(D)
		 	- 업무별 > 클래스 분배 > 업무별 담당클래스
		 	
		 	- 데이터설계
				- 정보 수집 > 이름, 나이, 성별, 주소, 국어, 영어, 수학
				- 분류 > 신상(이름, 나이, 성별, 주소), 성적(국어, 영어, 수학)
				- 파일 > 학생.txt, 성적.txt
				- 학생.txt구조 
					번호, 이름, 나이, 성별, 주소
					1,홍길동,15,1,서울시 강남구 역삼동
		 		- 성적.txt구조
		 			학생번호, 국어,영어,수학
		 			1,100,80,90 -> 학생번호로 하는건 동명이인의 처리때문에
		 		- 학생.txt <-> (시험) <-> 성적.txt
		 	
		 	- 데이터 파일 + 데이터 생성
		 	
		 	- 클래스
		 		- 파일 경로 > DataPath.java
		 		
		 	- 순서도
		 		1. 타이틀
		 		2. 메인 메뉴
		 		3. 선택
		 			- 각각의 기능 실행
		 			- 종료 > 2번으로 돌아가기
		 		4. 종료
		 		
		 		
		 		공통코드 > 어디까지인지? 회의!!!
		 		
		 		수업 프로젝트 > 클래스 ?개
		 		
		 		1인 + 1일 7개
		 		
		 		클래스 N개 생성 > 7개 > 패키지 분리 관리
		 		
		 		
		 */
		
		//파일 데이터 -> 메모리
		Data.load();
		
		Work work = new Work();
		
		boolean loop = true;
		
		while(loop) {
			
			Output.title(); //관리차원에서 뺌
			Output.mainmenu();
			
			Scanner scan = new Scanner(System.in);
		
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				work.add(); //업무 위임
			} else if(input.equals("2")) {
				work.list();
			} else if(input.equals("3")) {
				work.search();
			} else {
				loop = false;
			}
		}
		
		Output.close();
		
		//메모리 > 파일 데이터
		Data.save();
	}

}
