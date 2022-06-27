
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>


<!-- [Summary] page 지시자, 에러 페이지 지정하기 (오전 8:46:55)-->
<!-- JSP 컨테이너(아파치 톰캣)에게 해당 페이지의 정보를 알려준다. --> 
 <%@ page errorPage="error.jsp" %>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		Random rnd = null;
		System.out.println(rnd.nextInt());  //NullPointerException
	%>
</body>
</html>
