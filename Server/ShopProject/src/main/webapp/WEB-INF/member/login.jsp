<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MJSHOES</title>
<%@ include file="/WEB-INF/inc/asset.jsp" %>
<style>


</style>
</head>
<body>
	
	 <main>
		<%@ include file="/WEB-INF/inc/header.jsp" %>
	 	<section>
	 		<h1>login</h1>
	 		<form method="POST" action="/shop/member/loginok.do" class="form-login">
	 		<h2>MJSHOES</h2>
	 		<table class="table table-bordered tbl-login">
	 			<tr>
	 				<td>
	 					<i class="fa-solid fa-user"></i>
	 					<input type="text" name="id" class="form-control" placeholder="아이디" required>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>
	 					<i class="fa-solid fa-lock"></i>
	 					<input type="password" name="pw" class="form-control" placeholder="비밀번호" required>
	 				</td>
	 			</tr>
	 		</table>
			<input type="submit" value="login" class="btn btn-dark">
			</form>	 	
	 		<!-- //TODO --> 
	 		<div class="help-login">
	 			<a href="#!">아이디 찾기</a>
	 			<a href="#!">비밀번호 찾기</a>
	 			<a href="/shop/member/join.do">회원가입</a>
	 		</div>
	 	</section>
	 </main>
	
	<script>
		
	</script>
	
</body>
</html>