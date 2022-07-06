<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	 		<h1>Profile</h1>
	 		
	 		<table class="table table-bordered tbl-profile">
	 			<tr>
	 				<th>
	 					아이디
	 				</th>
	 				<td>${dto.id}</td>
	 				
	 			</tr>
	 			<tr>
	 				<th>이름</th>
	 				<td>${dto.name}</td>
	 			</tr>
	 			<tr>
	 				<th>주소</th>
	 				<td>${dto.address}</td>
	 			</tr>
	 			<tr>
	 				<th>전화번호</th>
	 				<td>${dto.tel}</td>
	 			</tr>
	 			<tr>
	 				<th>문자 수신 동의여부</th>
	 				<td>
	 					<label><input type="radio" name="smsConsent" value="Y" class="form-check"  onclick="return(false)">동의</label>
	 					<label><input type="radio" name="smsConsent" value="N" class="form-check"  onclick="return(false)">비동의</label>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>이메일</th>
	 				<td>${dto.email}</td>
	 			</tr>
	 			<tr>
	 				<th>이메일 수신 동의여부</th>
	 				<td>
	 					<label><input type="radio" name="emailConsent" value="Y" onclick="return(false)">동의</label>
	 					<label><input type="radio" name="emailConsent" value="N" onclick="return(false)">비동의</label>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>생년월일</th>
	 				<td>
	 					<c:if test="${not empty dto.birthdate}">
	 					(${dto.solarLunar}) ${dto.birthdate}
	 					</c:if>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>발사이즈</th>
	 				<td>
	 					<c:if test="${not empty dto.footSize}">
	 					${dto.footSize} mm
	 					</c:if>
	 				</td>
	 			</tr>
	 		</table>
	 		<div class="div-profile">
		 		<a href="/shop/member/edit.do" class="btn btn-dark">Edit</a>
		 		<a href="/shop/member/editpw.do" class="btn btn-dark">Change password</a>
		 		<a href="/shop/member/del.do" class="btn btn-danger">Delete account</a>
	 		</div>
	 		</form>
	 	
	 	</section>
	 </main>
	
	<script>
		$(":radio[name='smsConsent'][value='${dto.smsConsent}']").attr('checked', true);
		$(":radio[name='emailConsent'][value='${dto.emailConsent}']").attr('checked', true);
	</script>
	
</body>
</html>