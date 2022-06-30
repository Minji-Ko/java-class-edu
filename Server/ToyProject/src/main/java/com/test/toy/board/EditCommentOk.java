package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/editcommentok.do")
public class EditCommentOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 인코딩
		//2. 데이터 가져오기
		//3. DB작업
		//4. 결과
		//5. 피드백
		
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String seq = req.getParameter("seq");
		String comment = req.getParameter("comment");
		
		String pseq = req.getParameter("pseq");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		//3.
		CommentDTO dto = new CommentDTO();
		dto.setSeq(seq);
		dto.setComment(comment);
		
		//4+5.
		BoardDAO dao = new BoardDAO();
		
		int result = dao.editComment(dto);
		
		
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
