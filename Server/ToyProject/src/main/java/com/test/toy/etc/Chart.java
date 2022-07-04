package com.test.toy.etc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.board.BoardDAO;
import com.test.toy.etc.ChartDTO01;
import com.test.toy.etc.ChartDTO02;
import com.test.toy.etc.ChartDTO03;


@WebServlet("/etc/chart.do")
public class Chart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. DB작업
		//2. 결과
		//3. JSP 호출하기 + 결과 전달하기
		
		BoardDAO dao = new BoardDAO();
		
		ArrayList<ChartDTO01> list1 = dao.chart1();
		ArrayList<ChartDTO02> list2 = dao.chart2();
		ArrayList<ChartDTO03> list3 = dao.chart3();
		
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/etc/chart.jsp");

		dispatcher.forward(req, resp);
	}

}
