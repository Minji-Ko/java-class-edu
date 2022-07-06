package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/idcheckok2.do")
public class IdCheckOk2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		//2. db작업
		//3. 결과
		//4. 피드백

		String id = req.getParameter("id");
		
		//2.
		AjaxDAO dao = new AjaxDAO();
		
		int result = dao.checkid(id);
		
		
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		
		writer.close();
		
	}

}
