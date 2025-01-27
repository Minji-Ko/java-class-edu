package com.test.java.mvc;

/*
 
Java + JDBC + Oracle

 
 
주소록 관리 프로그램
1. 등록하기
2. 읽기
3. 수정하기
4. 삭제하기
  
DB
- tblAddress

자바 계층 구조
<기존>
- 메인 클래스(main())
	1. 전체 흐름 통제 코드
	2. 업무 조작 코드
	3. JDBC
	4. 입력 코드
	5. 출력 코드

<앞으로>
- 메인 클래스(main())
	1. 전체 흐름 통제 코드
	2. 업무 코드 > 다른 클래스에게 위임
	
- 업무 클래스(Service)
	1. 업무 코드 담당
	2. 파츠별 실제 담당자 > 메뉴별 생성
		ex) MemberServic.java
			AdminstratorService.java
			AuthService.java
			BoardService.java
	3. 출력 업무 코드
	4. JDBC 업무 코드

- 출력 클래스(View)
	1. 화면 출력 코드 담당
	
- DB 클래스(DAO, Data Access Object)
	1. JDBC 코드 담당



파일 생성
1. Main.java
	- 전체 흐름 통제

2. Service.java
	- 주소록 관리 실제 담당자(실세)

3. View.java
	- 출력 담당
	
4.DAO.java
	- DB 담당

5.Address.java
	- DTO(Data Transfer Object), VO(Value Object)
	- 계층간의 데이터를 전달하는 용도

6.DBUtil.java
	- DB 연결


  

*/

























