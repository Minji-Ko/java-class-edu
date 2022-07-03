package com.test.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/joinok.do")
public class JoinOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String address = req.getParameter("address1") + " " + req.getParameter("address1");
		String tel = req.getParameter("tel1") + "-" + req.getParameter("tel2") + "-" + req.getParameter("tel3");
		String smsConsent = req.getParameter("smsConsent");
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		String emailConsent = req.getParameter("emailConsent");
		String solarLunar = req.getParameter("solarLunar");
		String birthdate = req.getParameter("birthdate");
		String footSize = req.getParameter("footSize");
		
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setAddress(address);
		dto.setTel(tel);
		dto.setSmsConsent(smsConsent);
		dto.setEmail(email);
		dto.setEmailConsent(emailConsent);
		dto.setSolarLunar(solarLunar);
		dto.setBirthdate(birthdate);
		dto.setFootSize(footSize);
		
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.join(dto);
		
		req.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/joinok.jsp");

		dispatcher.forward(req, resp);
	}

}
