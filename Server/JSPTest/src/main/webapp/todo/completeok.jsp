<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	
	String seq = request.getParameter("seq");	
	
	
	Connection conn = null;
	PreparedStatement pstat = null;
	int result = 0;
	
	try {
		
		conn = DBUtil.open();
		
		String sql = "update tblTodo set complete = 'y' where seq = ?";
		
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, seq);
		
		result = pstat.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);	
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
	
	</div>
	
	<script>
		<% if (result > 0) { %>
			location.href = 'list.jsp';
		<% } else { %>
			alert("완료처리 실패;;");
			history.back();
		<% } %>
	</script>
	
</body>
</html>