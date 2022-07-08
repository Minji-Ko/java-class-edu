package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delcommentajaxok.do")
public class DelCommentAjaxOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		String seq = req.getParameter("seq");
		
		
		//2+3. DB 작업 + 결과
		BoardDAO dao = new BoardDAO();
		
		int result = dao.delComment(seq);
		
		
		//4.
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter(); 
		
		writer.printf("{ \"result\": %d }", result);
		
		writer.close();
		
		
	}

}

