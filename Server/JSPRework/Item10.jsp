<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<p>요청 URi: <%= request.getRequestURI() %></p>		
	<p>요청 서버 도메인: <%= request.getServerName() %></p> <!-- naver.com -->
	<p>요청 쿼리 문자열: <%= request.getQueryString() %></p>
	<p>클라이언트 주소: <%= request.getRemoteAddr() %></p>  <!-- 172.30.1.9 -->
	<p>요청 방식: <%= request.getMethod() %></p>
	<p>컨텍스트 경로: <%= request.getContextPath() %></p>
	
	<p><%= request.getHeader("host") %></p>
	<p><%= request.getHeader("accept-language") %></p>
	
	<% 
		// request.getHeader("헤더명") 	
		Enumeration<String> e = request.getHeaderNames();
	
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name);
		}
	%>
	
</body>
</html>