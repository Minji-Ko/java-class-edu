package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/editcommentajaxok.do")
public class EditCommentAjaxOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String seq = req.getParameter("seq");
		String comment = req.getParameter("comment");
		
		//3.
		CommentDTO dto = new CommentDTO();
		dto.setSeq(seq);
		dto.setComment(comment);
		
		//4.
		BoardDAO dao = new BoardDAO();
		
		int result = dao.editComment(dto);
		
		
		//5.
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter(); 
		
		writer.printf("{ \"result\": %d }", result);
		
		writer.close();
		
		
	}

}

