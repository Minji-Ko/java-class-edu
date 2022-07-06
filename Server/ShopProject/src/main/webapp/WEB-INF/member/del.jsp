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
	 		<h1>Delete account</h1>
	 		
	 		<form method="POST" action="/shop/member/delok.do" class="form-delete-account">
	 		<h2>탈퇴 안내사항</h2>
	 		<div class='div-del-account'>
		 		<p>1. 현재 사용하고 계신 아이디로 탈퇴하실 경우 해당 아이디의 재사용 및 복구가 불가능합니다.</p>
		 		<p>2. 해당 아이디로 등록된 적립금 및 쿠폰은 소멸되며 사용하실 수 없습니다.</p>
		 		<p>3. 탈퇴 후 회원정보 및 서비스 이용기록은 완전히 삭제됩니다.</p>
		 		<p>4. 탈퇴시 할인 혜택, 이벤트 참여, 메일 서비스 등을 받으실 수 없습니다.</p>
	 		</div>
	 		<p><label><input type="checkbox" name="read" value="Y" required> 안내 사항을 모두 확인했으며, 이에 동의합니다.</label></p>
	 		
	 		<h2 class='del-account'>탈퇴정보 확인</h2>
	 		<table class="table table-bordered tbl-del-account">
	 			<tr>
	 				<th>아이디</th>
	 				<td>${id}</td>
	 			</tr>
	 			<tr>
	 				<th>비밀번호</th>
	 				<td><input type="password" name="pw" class="form-control" placeholder="비밀번호" required></td>
	 			</tr>
	 		</table>
	 		
	 		<p>그동안 MJSHOSE를 이용해주셔서 감사합니다.</p>
	 		<div class="div-del-account">
				<button class="btn btn-danger">탈퇴하기</button>	 		
				<button type="button"  class="btn btn-secondary" onclick="history.back();">돌아가기</button>	 		
	 		</div>
	 		</form>
	 	</section>
	 </main>
	
	<script>
		
	</script>
	
</body>
</html>