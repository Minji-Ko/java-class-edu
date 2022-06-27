<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	try {
		
		conn = DBUtil.open();
		
		String sql = "select * from tblTodo order by priority";
		
		stat = conn.createStatement();
		
		rs = stat.executeQuery(sql);
	
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

	<main>
		<h1>Todo <small>List</small></h1>
		
		<table class="table table-bordered list">
			<tr>
				<th>★</th>
				<th>할일</th>
				<th>날짜</th>
			</tr>
			<% while(rs.next()){ %>
			<tr data-seq="<%= rs.getString("seq") %>" data-complete="<%= rs.getString("complete") %>">
				<td><%= rs.getString("priority") %></td>
				<td><%= rs.getString("todo") %></td>
				<td><%= rs.getString("regdate") %></td>
			</tr>
			<% } %>
		</table>
		
		<div class="btns">
			<input type="button" value="등록하기"
				class="btn btn-warning" onclick="location.href='add.jsp';">
		</div>
	</main>
	<% 
		} catch (Exception e) {
			System.out.println(e);	
		} 
	 %>
	
	
	<script>
		$('table tr[data-complete=y]').addClass('complete');
	
		$('table tr').click(function(){
			location.href='completeok.jsp?seq='+ $(this).data('seq');
		});	
	
	</script>

</body>
</html>
















