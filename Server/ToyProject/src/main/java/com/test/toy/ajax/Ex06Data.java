package com.test.toy.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex06data.do")
public class Ex06Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String buseo = req.getParameter("buseo");
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<BuseoDTO> list = dao.listInsa(buseo);
		
		
		//ArrayList<BuseoDTO> -> JSON 변환
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ajax/ex06.jsp");

		dispatcher.forward(req, resp);
	}

}
