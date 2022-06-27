package com.test.mvc;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//자바로 할일~ > 비즈니스 코드
		
		//모두 같은 행동(JSP는 servlet이다.)
		//- Servlet > Servlet
		//- Servlet > JSP
		//- JSP > Servlet
		//- JSP > JSP
		
		
		//JSP 호출하기
		//resp.sendRedirect("/jsp/mvc/hello.jsp");
		
		//사용중이던 request, response를 다음 페이지로 전달 가능
		//pageContext.forward();

		//DB > "홍길동"
		String name = "홍길동";
		
		req.setAttribute("name", name); //약간의 Model성격이 있기는 하지만 Model == DTO
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");
		dispatcher.forward(req, resp); //pageContext.forward()와 같은 기능 
	}
}
