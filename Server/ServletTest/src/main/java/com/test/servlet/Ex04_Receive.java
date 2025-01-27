package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04_Receive extends HttpServlet {

	
	
	//서블릿
	//1. 해당 서블릿 > get 요청 > doGet() 호출
	//2. 해당 서블릿 > post 요청 > doPost() 호출
	
	//요청과 응답 방식은 일치해야한다. 그렇지 않으면 405에러!
	//GET > doGet()
	//POST> doPost()
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//<form> -> 현재의 서블릿에게 데이터를 전송 -> 수신
		
		//<input type='text' name='name'>		
		//<input type='text' name='age'>		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		
		System.out.println(name);
		System.out.println(age);
		
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>수신한 데이터</h1>");
		writer.println("<p>이름: " + name + "</p>");
		writer.println("<p>나이: " + age + "</p>");
		writer.println("<body>");
		writer.println("</html>");
		
		writer.close();
	}
	
}
