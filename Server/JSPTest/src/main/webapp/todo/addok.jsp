<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//1.
	request.setCharacterEncoding("UTF-8");

	//2.
	String todo = request.getParameter("todo");
	String priority = request.getParameter("priority");
	
	
	int result = 0;
	
	try {
		//3.		
		Connection conn = null;
		PreparedStatement stat = null;
		
		conn = DBUtil.open();
				
		String sql = "insert into tblTodo (seq, todo, regdate, priority, complete) values (seqTodo.nextval, ?, default, ?, default)";
		
		stat = conn.prepareStatement(sql);
		
		stat.setString(1, todo);
		stat.setString(2, priority);
		
		result = stat.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println(e);
	}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<script>
		<% if (result > 0) { %>
		
		location.href = 'list.jsp';
		
		<% } else { %>
		
		alert('추가 실패;;');
		history.back();
		
		<% } %> 
	</script>

</body>
</html>
















