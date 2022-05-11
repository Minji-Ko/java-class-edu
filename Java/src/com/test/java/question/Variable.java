package com.test.java.question;

public class Variable {

	public static void main(String[] args) {
		
//		1. 은행 업무
		String clientName = "고민지";
		
		byte   numOfAccount = 10;
		short  useDays = 210;
		int    memberNum = 12353356;
		long   totalBalance = 1324356789000L;
		
		float interestRate = 0.01f;
		double primeRate = 0.025;
		char creditRating = 'A';
		
		boolean vip = true;
		
		System.out.println("[은행 고객 상세정보]");
		System.out.println();
		System.out.println("고객명 : " + clientName);
		System.out.println("고객번호: " + memberNum);
		System.out.println("신용 등급: " + creditRating);
		System.out.println();
		System.out.println("총 계좌수: " + numOfAccount + "개");
		System.out.println("총 잔고: " + totalBalance + "원");
		System.out.println("사용일수: " + useDays + "일");
		System.err.println();
//		System.out.println("기본 금리: " + interestRate);
//		System.out.println("우대 금리: " + primeRate);
		System.out.printf("기본 금리: %.1f%%\n", interestRate * 100);
		System.out.printf("우대 금리: %.1f%%\n", primeRate * 100);
		System.err.println();
//		System.out.println("이 고객이 vip에 해당하는 것은 " + vip + "입니다.");
		System.out.printf("이 고객이 vip에 해당하는 것은 %b입니다.\n", vip);
		System.out.println("\n----------------------------");
	
		
//		2. 책 정보
		String bookName = "자바의 정석";
		
		byte   bookVersion = 3;
		short  pageNum = 1022;
		int    bookPrice = 30000;
		long   circulation = 24140243569798L;
		
		float  width = 18.4F;
		double height = 25.4;
		char bookState = '상';
		
		boolean onSale = true;
		
		
		System.out.println("[ " + bookName + " ] " + bookVersion + "Edition");
		System.out.println();
		System.out.println("가격\t: " + bookPrice + "원");
		System.out.println("페이지수\t: " + pageNum + "page");
		System.out.println("판매부수\t: " + circulation + "권");
//		System.out.println("크기: " + width + " * " + height + " cm");
		System.out.printf("크기\t: %.1f * %.1f cm\n", width, height);
		System.out.println("책 상태\t: " + bookState);
		System.out.println();
		System.out.println(bookName + "은 현재 판매 중인 상태인가? " + onSale);
		System.out.println("\n----------------------------");
		
		
//		3. 시험 출제
		String examSubject = "수학";
		
		byte   examinationNum = 10;
		short  questionsNum = 25;
		int    examTakersNum = 523240;
		long   printNum = 2000000L;
		
		float  scorePerQuestion = 4.0f;
		double totalScore = 100.0;
		char   examVersion= '가';
		
		boolean endExam = false;
		
		System.out.println("[ " + examSubject + " " + examVersion + "형 ]");
		System.out.println();
		System.out.println("문제 수: " + questionsNum + "문제");
		System.out.println("문제당 배점: " + scorePerQuestion + "점");
		System.out.println("총 배점: " + totalScore + "점");
		System.out.println();
		System.out.println("응시생 수: " + examTakersNum + "명");
		System.out.println("인쇄 부수: " + printNum + "부");
		System.out.println("검토 횟수: " + examinationNum + "회");
		System.out.println("시험이 종료되었는가? " + endExam);
		System.out.println("\n----------------------------");		
		
		
//		4. 해외 여행
		String destination = "미국"; 
		
		byte passengerNum = 89;
		short flightMinute = 420;
		int   ticketPrice = 2_240_000;
		long  distance = 10704L; 
		
		float planeLength = 66.65f;
		double wingLength = 97.54;
		char seatClass = 'F';  //window seat 
		
		boolean onBoard = true;
		
		System.out.println("[ " + destination + "으로의 비행 ]");
		System.out.println();
//		System.out.println("현재 탑승 중 : " + onBoard);
//		System.out.println("탑승 인원: " + passengerNum + "명");
//		System.out.println("비행 시간: " + flightMinute + "분");
//		System.out.println("티켓 값: " + ticketPrice + "원");
//		System.out.println("거리: " + distance + "km");
		System.out.printf("현재 탑승중: %10b\n", onBoard);
		System.out.printf("탑승 인원\t: %9d명\n", passengerNum);
		System.out.printf("비행 시간\t: %9d분\n", flightMinute);
		System.out.printf("티켓 값\t: %,d원\n", ticketPrice);
		System.out.printf("거리\t: %8dkm\n", distance);
		System.out.println();
		System.out.println("동체 길이: " + planeLength + "m");
		System.out.println("날개 길이: " + wingLength + "m");
		System.out.println("좌석 클래스: " + seatClass);
		System.out.println("\n----------------------------");	
		
		
//		5. 동물원
		String animalType = "호랑이";
		
		byte age = 3;
		short lifeExpectancy = 10;  
		int   visitorsNum = 2450000; 
		long  sales = 1234543234565400L;
		
		float animalWeight = 20.1f;
		double animalHeight = 60.23;
		char location = 'C';  
		
		boolean liveWithFamily = false;
		
		
		System.out.println("[ " + animalType + "에 대한 정보 ]");
		System.out.println();
		System.out.println("나이: " + age + "살");
		System.out.println("수명: " + lifeExpectancy + "년");
		System.out.println("위치: " + location + "구역");
		System.out.println("키 : " + animalHeight +"cm");
		System.out.println("무게: " + animalWeight + "kg");
		System.out.println();
		System.out.println("방문객 수: " + visitorsNum + "명");
		System.out.printf("매출: %,d원\n", sales);
		System.out.println("\n----------------------------");
		
		
//		6. 코로나 검사
		String name = "홍길동";
		
		byte isolationDays = 5;
		short contactNum = 125;
		int  supportFund = 1000000;  
		long totalPatient = 2456543234567876L;
		
		float temperature = 36.2f;  
		double temperatureFahrenheit = temperature * (9/5) + 32;
		char   testResult = '+';
		
		boolean isolationEnd = false;
		
		System.out.println("[ **코로나 관련 개인정보** ]");
		System.out.println();
		System.out.println("테스트 결과: " + testResult);
		System.out.println("접촉자 수: " + contactNum + "명");
		System.out.println("지원 금액: " + supportFund + "원");
		System.out.println("총 확진자 수: " + totalPatient + "명");		
		System.out.println();
		System.out.println("체온: " + temperature + "℃, (" + temperatureFahrenheit + "℉)" );
		System.out.println("자가격리 일수: " + isolationDays + "일");
		System.out.println("자가격리가 종료되었는가? " + isolationEnd);
		System.out.println("\n----------------------------");
		
		
//		7. 쌍용교육센터
		String className = "AWS Java"; 
		
		byte classNum = 1;
		short classDays = 160; 
		int   tuition = 5_800_000; 
		long  supportMoney = 100_245_000L;
		
		float participationRate = 98.99f;  
		double employmentRate = 88.88;
		char holiday = '토', holiday2 = '일';
		
		boolean inClass = true;
		
		System.out.println("[ " + className + " 과정 ]");
		System.out.println();
		System.out.println("교실: " + classNum + "강의실");
		System.out.println("수업일수: " + classDays + "일");
//		System.out.println("교육비: " + tuition);
//		System.out.println("지원금: " + supportMoney);
		System.out.printf("교육비: %,d원\n", tuition);
		System.out.printf("지원금: %,d원\n", supportMoney);
		System.out.printf("참여율: %.2f%%\n", participationRate);
		System.out.printf("취업률: %.2f%%\n", employmentRate);
		System.out.printf("휴일: %c요일, %c요일\n", holiday, holiday2);
		System.out.println();
		System.out.println("수업이 진행 중인 과정이라는 사실은" + inClass + "이다.");
		System.out.println("\n----------------------------");
		
		
//		8. 거주지
		String residenceType = "아파트";
		
		char  residenceName = 'A';

		byte  floors = 5;
		short householdsNum = 1000;
		int   managementFee = 125000;
		long  housePrice = 123456543200000000L;
		
		float  minTemperatureOfHouse = 15.0f;
		double maxTemperatureOfHouse = 40.0;
		
		boolean livingAll = true;
		
		System.out.println("[ " + residenceName + " " + residenceType + " 정보 ]");
		System.out.println();
		System.out.println("층수: " + floors + "층");
		System.out.println("세대수: " + householdsNum + "세대");
		System.out.println("관리비: " + managementFee + "원");
		System.out.printf("관리비: %,d원\n", managementFee);
		System.out.printf("집 값: %,d원\n", housePrice);
		System.out.println("온도 조절 가능범위: " + maxTemperatureOfHouse + " ~ " + minTemperatureOfHouse + "℃");
		System.out.println("모든 세대가 거주 중인가? " + livingAll);
		System.out.println("\n----------------------------");
		
		
//		9. 기업 정보
		String companyName = "카카오"; 
		
		byte  companyAge = 28;
		short companyEmployees = 3283;
		int   salary = 42000000;
		long  companySales = 1234567765432345654L; 
		
		float salesIncreasing = 0.18f;  
		double salesIncreasing2 = 50.19;
		char insurance = 'Y'; 
		
		boolean largecompany = true;
	
		System.out.println("[ (주) " + companyName + " ]");
		System.out.println();
		System.out.printf("설립 연차\t\t: %d년\n", companyAge);
		System.out.printf("사원 수\t\t: %d명\n", companyEmployees);
		System.out.printf("대졸 초임 연봉\t: %,d원\n", salary);
		System.out.printf("4대 보험\t\t: %b\n", insurance);
		System.out.println();
		System.out.printf("매출액\t\t\t: %,d원\n", companySales);
		System.out.printf("매출액 증가율(작년 대비)\t: %.0f%%\n", salesIncreasing * 100);
		System.out.printf("매출액 증가율(업계평균 대비)\t: %.0f%%\n", salesIncreasing2 * 100);
		System.out.println();
		System.out.println("-> 대기업이라는 것은 " + largecompany + "이다.");
		System.out.println("\n----------------------------");
		
		
//		10. 배터리
		String deviceType = "휴대폰";
		
		byte  batteryExpectancy = 2;
		short useTime = 200; 
		int   totalTime = 2000;
		long  batteryPrice = 1000000L; 
		
		float batteryVersion = 4.1f; 
		double batteryPercent = 90;
		char  batteryExpression = '%';
		
		boolean wirelessCharge = true;
		
		System.out.println("[ " + deviceType + "의 배터리 ]");
		System.out.println();
//		System.out.println(useTime + "분 동안 사용하여 " + batteryPercent + batteryExpression + " 남았습니다.");
//		System.out.println(totalTime - useTime + "분을 더 사용할 수 있습니다." );
//		System.out.println("* 이 배터리는 " + batteryVersion + "버전으로, 무선 충전 가능여부가 " + wirelessCharge + "입니다.");
//		System.out.println("* 이 배터리의 수명은 " +batteryExpectancy + "년이며, 새로 구매하게 되시면 가격이 " + batteryPrice + "원 입니다.");
		System.out.printf("%d분 동안 사용하여 %.0f%c 남았습니다.\n", useTime, batteryPercent, batteryExpression);
		System.out.printf("%d분을 더 사용할 수 있습니다.\n", totalTime - useTime);
		System.out.println();
		System.out.printf("* 이 배터리는 %.1f버전으로, 무선 충전 가능여부가 %b입니다.\n", batteryVersion, wirelessCharge);
		System.out.printf("* 이 배터리의 수명은 %d년이며, 새로 구매하게 되시면 가격이 %,d원 입니다.\n", batteryExpectancy, batteryPrice);
	
	}
}
