<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
    	
<!-- [Summary] HTML영역에서 Java 사용하기(스크립틀릿, 표현식) (오전 9:14:56)-->

<!-- 1. 스크립틀릿, Scriptlet : 메소드 영역, Script + Applet -->
<% 
	int a = 10;
	int b = 10;
	int c = a + b;
	
	String color = "cornflowerblue";
	String txt = "<input type='text'>";
	
	Calendar now = Calendar.getInstance();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

        
<!-- 2. 표현식, Expression : 자바 값(변수, 메소드 반환값 등) 출력 -->
	<div style="color:<%= color %>"><%= c %></div>
	
	<%= txt %>


</body>
</html>