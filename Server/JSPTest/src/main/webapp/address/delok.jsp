<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
    
<% 
	/* 
	2. 데이터 가져오기
	3. DB 작업
		3.1. DB연결
		3.2. SQL
		3.3. 종료
	4. 마무리(feedback) */
	

	//2.
	String seq = request.getParameter("seq");

	int result = 0;
	
	try {
		//3.
		DBUtil util = new DBUtil();
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		conn = util.open();
		
		//System.out.println(conn.isClosed());
		
		String sql = "delete from tblAddress where seq = ?";
		
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
<title>주소록</title>
<%@ include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<main>
		<header>
			<%@ include file="inc/header.jsp" %>
		</header>
		<section>
		</section>
	</main>
	
	<script>
		//4.
		<% if (result > 0) { %>
		
		location.href = 'list.jsp';
		
		<% } else { %>
		
		alert('삭제 실패;;');
		history.back();
		
		<% } %> 
	</script>
	
</body>
</html>