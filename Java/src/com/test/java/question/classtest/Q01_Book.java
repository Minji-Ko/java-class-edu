package com.test.java.question.classtest;

public class Q01_Book {

	public static void main(String[] args) {
		
//		요구사항] Book 클래스를 설계하시오.
//		- Book 객체의 정보  = 멤버 변수 > 제목, 가격, 저자, 출판사, 발행년도, ISBN, 페이지수
//		- 모든 멤버 변수의 접근 지정자는 private으로 한다.
//		- 멤버 접근을 위한 Setter와 Getter를 정의한다.
//			- 제목 : 읽기/쓰기, 최대 50자 이내(한글, 영어, 숫자)
//			- 가격 : 읽기/쓰기, 0 ~ 1000000원
//			- 저자 : 읽기/쓰기, 제한 없음
//			- 페이지수 : 읽기/쓰기, 1~무제한
//			- 출판사 : 쓰기 전용
//			- 발행년도 : 읽기 전용(2019년)
//			- ISBN : 읽기/쓰기
//		- Book 객체의 모든 정보를 "문자열"로 반환하는 메소드를 구현한다.
//			- String info()
		
//		출력]	제목: 자바의 정석
//			가격: 45,000원
//			저자: 남궁성
//			출판사: 도우출판
//			발행년도: 2019년
//			ISBN: 8994492038         
//			페이지: 1,022장
		
		Book b1 = new Book();
		
		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1022);
		
		System.out.println(b1.info());
		
		
	}
}

class Book {
	
	private String title;
	private	int price; 
	private String author;
	private String publisher;
	private String pubYear = "2019"; //int? String? -> String
	private String isbn; //변수명을 첫글자를 소문자로!
	private int page;
	
	
	public String getTile() {
		return title;
	}
	public void setTitle(String title) {
		if(checkTitle(title)) {
			this.title = title;
		} else {
			System.out.println("올바른 제목이 아닙니다.");
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(0 <= price && price <= 1000000) {
			this.price = price;
		} else {
			System.out.println("잘못된 가격을 입력하셨습니다.");
		}
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubYear() {
		return pubYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page > 0) {
			this.page = page;
		} else {
			System.out.println("페이지수가 올바르지 않습니다.");
		}
	}
	
	private boolean checkTitle(String title) {
		if(title.length() > 50) {
			return false;
		}
		
		for(int i=0; i<title.length(); i++) {
			
			if(!('가'<= title.charAt(i) && title.charAt(i) <='힣') 
				&& !('0' <=title.charAt(i) && title.charAt(i) <= '9')
				&& !('a' <=title.toLowerCase().charAt(i) && title.toLowerCase().charAt(i) <='z')
				&& !(title.charAt(i) == ' ')) { //공백주의***
		
				return false;
			}
		}
		return true;
	}
	
	public String info() {
		
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append("제목: " + this.title);
//		sb.append("\r\n");
//		sb.append(String.format("가격: %,d원", this.price));
//		sb.append("\r\n");
//		sb.append("저자: " + this.author);
//		sb.append("\r\n");
//		sb.append("출판사: " + this.publisher);
//		sb.append("\r\n");
//		sb.append(String.format("발행년도: %s년", this.pubYear));
//		sb.append("\r\n");
//		sb.append("ISBN" + this.isbn);
//		sb.append("\r\n");
//		sb.append(String.format("페이지: %,d장", this.page));
//		sb.append("\r\n");
//		
//		return sb.toString(); //StringBuilder -> String
		
		return String.format("제목: %s\n가격: %,d원\n저자: %s\n출판사: %s\n발행년도: %s년\nISBN: %s\n페이지: %,d장"
								,this.title
								,this.price
								,this.author
								,this.publisher
								,this.pubYear
								,this.isbn
								,this.page);
	}
	
	
}
//		설계]
//		1. Book 클래스
//			1.1 private 멤버 변수 만들기 
//			1.2 getter setter 메소드 만들기
//			1.3 setter 내에서 유효성 검사 > 길다면 다른 메소드로 뺴서 
//			1.4 info메소드 구현
//		2. main 메소드
//			2.1 객체 생성하기
//			2.2 setter로 출력에 쓰인 정보 입력하기
//			2.3 info()로 반환하기
				