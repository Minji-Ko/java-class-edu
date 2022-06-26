<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- [Summary] 데이터 전송하기 (오전 9:33:27)-->


	<!-- 1. 폼태그 + POST 방식 -->
	<form method="POST" action="Item09.jsp">
		<input type="text" name="txt">
		<input type="submit" value="데이터 전송">
	</form>
	
	
	<!-- 2. 폼태그 + GET 방식 -->
	<form method="GET" action="Item09.jsp">
		<input type="text" name="txt">
		<input type="submit" value="데이터 전송">
	</form>
	
	
	<!-- 3. 링크 + GET 방식 -->
	<a href="Item09.jsp?txt=홍길동&num=11">데이터 전송</a>
	
	
	<!-- 4. location + GET 방식 -->
	<input type="button" value="데이터 전송" onclick="submit();">
	
	<script>
		function submit() {
			location.href = "Item09.jsp?txt=홍길동&num=11";
		}
	</script>
	
	
</body>
</html>