<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- [Summary] 데이터 수신하기 (오후 10:35:56)-->
<%

	//1. 수신되는 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8"); //request.getParameter()가 UTF-8로 동작

	
	//2. 데이터 수신하기 > 내부적으로 doGet, doPost 처리가 되어있음
	String txt = request.getParameter("txt"); 
	String num = request.getParameter("num"); //value = request.getParameter("name");
	
	String[] checks = request.getParameterValues("checks");
	String[] selections = request.getParameterValues("selections");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
</body>
</html>