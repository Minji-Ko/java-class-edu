package com.test.toy.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 인코딩
		//2. 데이터 가져오기
		//3. DB 작업 > update
		//4. 결과
		//5. JSP 호출하기
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String path = req.getRealPath("/files");
		int size = 1024 * 1024 * 100;
		
		System.out.println(path);
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(
											req, 
											path, 
											size, 
											"UTF-8", 
											new DefaultFileRenamePolicy()
										);
			 
		} catch (Exception e) {
			System.out.println("EditOk.doPost");
			e.printStackTrace();
		}
		
		//2.
		String seq = multi.getParameter("seq");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String column = multi.getParameter("column");
		String word = multi.getParameter("word");
		
		//3.
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId((String)session.getAttribute("auth"));
		
		
		BoardDAO dao = new BoardDAO();
		
		//3.5 첨부파일 처리
		//3.5.1 
		//1) 기존 파일o > 교체 > 새로운 파일o
		//2) 기존 파일 x > 교체 > 새로운 파일o
		//3) 기존파일 o > 새로운 파일x
		//4) 기존파일 x > 새로운 파일x
		
		//새파일
		String filename = multi.getFilesystemName("attach");
		String orgfilename = multi.getOriginalFileName("attach");
		
		//기존파일
		BoardDTO tempdto = dao.get(seq);
		
		if(tempdto.getFilename() != null && filename != null) {
			File file = new File(path + "\\" + tempdto.getFilename());
			file.delete();
			
			dto.setFilename(filename);
			dto.setOrgfilename(orgfilename);

		} else if (filename == null && multi.getParameter("delfile").equals("y")) {
			File file = new File(path + "\\" + tempdto.getFilename());
			file.delete();
		} else if (filename == null) { //기존 파일 유무와 상관없이 새로운 파일x
			dto.setFilename(tempdto.getFilename());
			dto.setOrgfilename(tempdto.getOrgfilename());
			
		} else if(tempdto.getFilename() == null && filename != null){
			dto.setFilename(filename);
			dto.setOrgfilename(orgfilename);
		}
		
		
		
		int result = 0;
		
		if((dto.getId() != null && dto.getId().equals("admin")) || dao.check(dto)) {
			result = dao.edit(dto);
		}
		
		
		
		//4.
		req.setAttribute("seq", seq);
		req.setAttribute("result", result);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/editok.jsp");

		dispatcher.forward(req, resp);
	}

}

