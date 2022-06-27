<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String todo = request.getParameter("todo");	
	String priority = request.getParameter("priority");	
	
	
	Connection conn = null;
	PreparedStatement pstat = null;
	int result = 0;
	
	try {
		
		conn = DBUtil.open();
		
		String sql = "insert into tblTodo(seq, todo, priority) values (seqTodo.nextVal, ?, ?)";
		
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, todo);
		pstat.setString(2, priority);
		
		result = pstat.executeUpdate();
		
	} catch (Exception e) {
		System.out.println(e);	
	}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<script>
		<% if (result > 0) { %>
			location.href = 'list.jsp';
		<% } else { %>
			alert("등록 실패;;");
			history.back();
		<% } %>
	</script>

</body>
</html>
