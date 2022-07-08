package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/addcommentajaxok.do")
public class AddCommentAjaxOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		String comment = req.getParameter("comment");
		String pseq = req.getParameter("pseq");
		
		CommentDTO dto = new CommentDTO();
		dto.setComment(comment);
		dto.setPseq(pseq);
		dto.setId((String)session.getAttribute("auth"));
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.addcomment(dto);
		
		CommentDTO temp = dao.getComment();
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		
		writer.print("{");
		writer.printf("\"result\": \"%s\",", result);
		writer.printf("\"seq\": %s,", temp.getSeq());
		writer.printf("\"id\": \"%s\",", temp.getId());
		writer.printf("\"name\": \"%s\",", temp.getName());
		writer.printf("\"regdate\": \"%s\",", temp.getRegdate());
		writer.printf("\"pseq\": %s", temp.getPseq());
		writer.print("}");
		
		writer.close();
		
		
		
		
	}

}















