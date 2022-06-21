package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

//1. 서블릿 클래스 선언
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//알바생 자격 취득!!!
public class Ex02 extends HttpServlet {
	
	//2. doGet/doPost 메소드 선언
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//한글 깨짐> UTF-8
		response.setCharacterEncoding("UTF-8");
		
		//3. 동적 HTML 페이지 작성 구현
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>서블릿</h1>");
		writer.println("<p>서블릿으로 만든 동적 웹페이지입니다.</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close(); //*** 이 작업을 안하면 웹페이지 생성이 안된다!!
		
		//4. 브라우저가 자바 파일(서블릿, 알바생)을 호출한다.
		//- http://localhost:8090/ServletTest/ex02.do
		//- http://localhost:8090/ServletTest/ex02
		//- http://localhost:8090/ServletTest/servlet/com.test.servlet.Ex02
		
		
		//이클립스
		//- 서블릿에서 Ctrl+F11을 누르면 해당 서블릿에 매핑되어 있는 가상 주소를 대신 브라우저를 통해서 호출해준다.
	}
	
	
}
