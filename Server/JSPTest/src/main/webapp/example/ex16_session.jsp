<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	session.setAttribute("name", "홍길동");
	application.setAttribute("age", 20);
	
	
	//페이지 방문 횟수
	if (session.getAttribute("count") == null) {
		//count = 0;
		session.setAttribute("count", 1); //초기화
	} else {
		//count = count + 1;
		session.setAttribute("count", (int)session.getAttribute("count") + 1);
	}

	if (application.getAttribute("count") == null) {
		//count = 0;
		application.setAttribute("count", 1); //초기화
	} else {
		//count = count + 1;
		application.setAttribute("count", (int)application.getAttribute("count") + 1);
	}
	

%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<div class="container">
		<h1>application & session</h1>
		<div>이름: <%= session.getAttribute("name") %></div>
		<div>나이: <%= application.getAttribute("age") %></div>
			
		<h1>방문 횟수</h1>
		<div>session: <%= session.getAttribute("count") %></div> <!-- 굉장히 좋지만 메모리 점유율이 높음  -->
		<div>application: <%= application.getAttribute("count") %></div>
	</div>
	
	<script>
	
	</script>
	
</body>
</html>