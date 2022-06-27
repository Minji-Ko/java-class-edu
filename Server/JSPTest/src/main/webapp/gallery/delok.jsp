<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String seq = request.getParameter("seq");
	
	int result = 0;
		
	try {
		
		Connection conn = null;
		PreparedStatement pstat = null;
	
		conn = DBUtil.open();
		
		String sql = "delete from tblGallery where seq = ?";
		
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, seq);
		
		result = pstat.executeUpdate();
		
	} catch(Exception e){
		System.out.println(e);
	}
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<%@ include file="/gallery/inc/asset.jsp" %>
<style>
</style>
</head>
<body>

	<div class="container">
		<h1>Image Gallery <small>Add</small></h1>
				
		<form>
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required class="form-control"></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="attach" required></td>
			</tr>
		</table>
		
		<div>
			<input type="button" value=" 돌아가기 "
				class="btn btn-secondary" onclick="location.href='list.jsp';">
				
			<input type="submit" value=" 이미지 업로드 "
				class="btn btn-success">
			
		</div>
		</form>
		
		
	</div>
	
	
	<script>
		<% if (result > 0) { %>
		
		location.href = 'list.jsp';
		
		<% } else { %>
		
		alert('삭제 실패;;');
		history.back();
		
		<% } %>  
	
	</script>
	
	
</body>
</html>