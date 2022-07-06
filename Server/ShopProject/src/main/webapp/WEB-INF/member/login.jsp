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
	 		
	 		<!-- 임시start -->
	 		<form method="POST" action="/shop/member/loginok.do" style="display:inline">
				<input type="hidden" name="id" value="sineob7">
				<input type="hidden" name="pw" value="CkwPPWmoME%">
				<input type="submit" value="주유아(sineob7)" class="btn btn-primary">
			</form>	 	
	 		<form method="POST" action="/shop/member/loginok.do" style="display:inline">
				<input type="hidden" name="id" value="oepan">
				<input type="hidden" name="pw" value="iIuhZmLsHU20*">
				<input type="submit" value="김수기(oepan)" class="btn btn-primary">
			</form>	 	
	 		<form method="POST" action="/shop/member/loginok.do" style="display:inline">
				<input type="hidden" name="id" value="aekcyfm">
				<input type="hidden" name="pw" value="gJOQJqXlyiZ38&">
				<input type="submit" value="서유진(aekcyfm)" class="btn btn-primary">
			</form>	 	
	 		<form method="POST" action="/shop/member/loginok.do" style="display:inline">
				<input type="hidden" name="id" value="wolbt">
				<input type="hidden" name="pw" value="leYbnoiowK!">
				<input type="submit" value="이아설(wolbt)" class="btn btn-primary">
			</form>	 	
	 		<form method="POST" action="/shop/member/loginok.do" style="display:inline">
				<input type="hidden" name="id" value="bynja2">
				<input type="hidden" name="pw" value="NmBtpuqFK#">
				<input type="submit" value="박혜미(bynja2)" class="btn btn-primary">
			</form>	 	
	 	</section>
	 	<!-- 임시end -->
	 	
	 </main>
	
	<script>
		
	</script>
	
</body>
</html>