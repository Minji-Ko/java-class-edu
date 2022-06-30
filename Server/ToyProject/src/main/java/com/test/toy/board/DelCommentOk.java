package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delcommentok.do")
public class DelCommentOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. DB 작업
		//3. 결과
		//4. 피드백
		
		String seq = req.getParameter("seq");
		String pseq = req.getParameter("pseq");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		
		//2+3
		BoardDAO dao = new BoardDAO();
		
		int result = dao.delComment(seq);
		
		if(result == 1) {
			resp.sendRedirect(String.format("/toy/board/view.do?seq=%s&column=%s&word=%s", pseq, column, word, URLEncoder.encode(word, "UTF-8")));
		} else {
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<script>");
			writer.println("alert('failed');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body>");
			writer.println("</html>");
			
			writer.close();
		}
		
	}

}

