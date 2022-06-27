<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@page import="java.util.Random"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex02_page_directive.jsp -->
	
	<h1>페이지 지시자</h1>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quibusdam laboriosam magnam at cupiditate repellat iusto modi qui culpa fugit alias nemo rerum quo odit placeat itaque voluptatum delectus dolore nostrum.</p>
	<% 
	
		Random rnd = null;
		System.out.println(rnd.nextInt());  //NullPointerException
	
	%>
	<%@ include file="inc/copyright.jsp" %>

</body>
</html>