<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>add.jsp</h1>
	
	<h2>단일 데이터</h2>
	<form method="POST" action="/spring/addok">
		<input type="text" name="num">
		<input type="submit" value="보내기">
	</form>
	
	<h2>다중 데이터</h2>
	<form method="POST" action="/spring/addok">
		<input type="text" name="name">
		<input type="text" name="age">
		<input type="text" name="address">
		<input type="submit" value="보내기">
	</form>

	<h2>다중 데이터</h2>
	<form method="POST" action="/spring/addok">
		<input type="checkbox" name="cb" value="1">사과
		<input type="checkbox" name="cb" value="2">딸기
		<input type="checkbox" name="cb" value="3">오렌지
		<input type="checkbox" name="cb" value="4">바나나
		<input type="checkbox" name="cb" value="5">파인애플
		<input type="submit" value="보내기">
	</form>
	
	
</body>
</html>