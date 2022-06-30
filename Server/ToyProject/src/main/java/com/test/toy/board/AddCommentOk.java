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

@WebServlet("/board/addcommentok.do")
public class AddCommentOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 인코딩
		//2. 데이터 가져오기
		//3. DB작업 > insert
		//4.
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		String comment = req.getParameter("comment");
		String pseq = req.getParameter("pseq");
		
		CommentDTO dto = new CommentDTO();
		dto.setComment(comment);
		dto.setPseq(pseq);
		dto.setId((String)session.getAttribute("auth"));
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.addcomment(dto);
				
		req.setAttribute("result", result);
		req.setAttribute("pseq", pseq);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/addcommentok.jsp");

		dispatcher.forward(req, resp);
		
//		if(result == 1) {
//			resp.sendRedirect(String.format("/toy/board/view.do?seq=%s&column=%s&word=%s", pseq, column, word, URLEncoder.encode(word, "UTF-8"));
//		} else {
//			PrintWriter writer = resp.getWriter();
//			
//			writer.println("<html>");
//			writer.println("<body>");
//			writer.println("<script>");
//			writer.println("alert('failed');");
//			writer.println("history.back();");
//			writer.println("</script>");
//			writer.println("</body>");
//			writer.println("</html>");
//			
//			writer.close();
//		}
		
	}

}
