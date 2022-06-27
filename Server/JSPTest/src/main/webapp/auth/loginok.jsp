<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//1. 데이터를 가져오기
	//2. DB 작업 > select
	//3.1 있으면 > 인증 티켓 발급
	//3.2 없으면 > x
	//4. 피드백
	
	//1.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//2.
	Connection conn = null;
	PreparedStatement stat =null;
	ResultSet rs = null;
	
	conn = DBUtil.open();
	
	//로그인 처리 SQL
	String sql = "select * from tblUser where id= ? and pw = ?";

	stat = conn.prepareStatement(sql);
	
	stat.setString(1, id);
	stat.setString(2, pw);
	
	rs = stat.executeQuery();
	
	String name = "";
	int lv = 0;
	
	if(rs.next()){
		//로그인 성공
		name = rs.getString("name");
		lv = rs.getInt("lv");
		
		//인증 티켓 발급!! > 세션
		session.setAttribute("auth", id);

		//계정 정보 > 사용 빈도에 따라 결정 > 메모리 점유
		session.setAttribute("name", name);
		session.setAttribute("lv", lv);
	} else {
		//로그인 실패
	}
	
	rs.close();
	stat.close();
	conn.close();
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/auth/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<div class="container">
		<h1>로그인</h1>
	
	</div>
	
	<script>
		
		<% if(session.getAttribute("auth") != null) { %>
			location.href = 'index.jsp';
		<% } %>
		
		
		<% if(session.getAttribute("auth") == null) { %>
			alert('인증 실패;;')
			history.back(); //login.jsp
		<% } %>
	</script>
	
</body>
</html>