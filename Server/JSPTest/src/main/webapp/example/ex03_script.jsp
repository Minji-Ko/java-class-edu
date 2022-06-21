<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--  
	JSP 페이지 + JSP 태그 > 자원 경로(URL)
	1.상대경로
	2.절대경로
		-'/' > webapp
-->
<%@ include file="/example/inc/asset.jsp" %>
</head>
<body>
	<div class="container">
		<h1>스크립틀릿 + 표현식</h1>
		<%
			int a = 10;
			int b = 10;
			int c = a + b;
			
		%>
		
		<div class="alert alert-primary">결과: <%= c %></div>
		
		<h1>구구단 5단</h1>
		<% 
			for(int i=1; i<=9; i++) {
		%>
				<div>5 x <%= i %> = <%= i*5 %></div>
		<%
			}
		%> <!-- 스파게티 코드 -->
		
	</div>
</body>
</html>