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
	 		<h1>Edit Profile</h1>
	 		
	 		<form method="POST" action="/shop/member/editok.do">
	 		<table class="table table-bordered tbl-profile">
	 			<tr>
	 				<th>
	 					아이디
	 				</th>
	 				<td>${dto.id}</td>
	 			</tr>
	 			<tr>
	 				<th>이름</th>
	 				<td>
	 					<input type="text" name="name" class="form-control" required>
	 					(2~5자)
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>주소</th>
	 				<td>
	 					<div>기본주소 <input type="text" name="address1" class="form-control" required></div>
	 					<div>상세주소 <input type="text" name="address2" class="form-control" required></div>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>전화번호</th>
	 				<td>
	 					<input type="number" name="tel1" value="010" class="form-control" readonly>-
	 					<input type="number" name="tel2" maxlength="4" class="form-control" required>-
	 					<input type="number" name="tel3" maxlength="4" class="form-control" required>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>문자 수신 동의여부</th>
	 				<td>
	 					<label><input type="radio" name="smsConsent" value="Y" class="form-check" checked>동의</label>
	 					<label><input type="radio" name="smsConsent" value="N" class="form-check">비동의</label>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>이메일</th>
	 				<td>
		 				<input type="text" name="email1" class="form-control" required>@
		 				<input type="text" name="email2" class="form-control" required>
		 				<select class="form-control">
		 					<option value="" selected>직접 입력</option>
		 					<option value="naver.com">naver.com</option>
		 					<option value="daum.net">daum.net</option>
		 					<option value="hanmail.net">hanmail.net</option>
		 					<option value="gmail.com">gmail.com</option>
		 				</select>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>이메일 수신 동의여부</th>
	 				<td>
	 					<label><input type="radio" name="emailConsent" value="Y" checked>동의</label>
	 					<label><input type="radio" name="emailConsent" value="N" >비동의</label>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>생년월일</th>
	 				<td>
	 					<select name="solarLunar" class="form-control">
		 					<option value="양력" selected>양력</option>
		 					<option value="음력">음력</option>
		 				</select>
	 					<input type="date" name="birthdate" class="form-control">
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>발사이즈</th>
	 				<td><input type="number" name="footSize" maxlength="3" class="form-control"> mm</td>
	 			</tr>
	 		</table>
	 		<div class="div-profile">
		 		<input type="button" value="Back" class="btn btn-secondary" onclick='history.back();'>
		 		<input type="submit" value="Edit" class="btn btn-dark">
	 			<input type="password" class="form-control" placeholder="비밀번호를 입력하세요." required> <!-- (영문 대문자, 숫자 포함 10자 이상) -->
			</div>
	 		</form>
	 	
	 	</section>
	 </main>
	
	<script>
		$('input[name=name]').val('${dto.name}');
		$('input[name=address1]').val('${fn:split(dto.address, ',')[0]}');
		$('input[name=address2]').val('${fn:split(dto.address, ',')[1]}');
		$('input[name=tel1]').val('${fn:split(dto.tel,"-")[0]}');
		$('input[name=tel2]').val('${fn:split(dto.tel,"-")[1]}');
		$('input[name=tel3]').val('${fn:split(dto.tel,"-")[2]}');
		$('input[name=email1]').val('${fn:split(dto.email,"@")[0]}');
		$('input[name=email2]').val('${fn:split(dto.email,"@")[1]}');
		$('input[name=solarLunar]').val('${dto.solarLunar}');
		$('input[name=birthdate]').val('${dto.birthdate}');
		$('input[name=footSize]').val('${dto.footSize}');
		$(":radio[name='smsConsent'][value='${dto.smsConsent}']").attr('checked', true);
		$(":radio[name='emailConsent'][value='${dto.emailConsent}']").attr('checked', true);
		
		$('input[name=email2]').next().change(function(){
			$('input[name=email2]').val($('input[name=email2]').next().val());
		})
		
	</script>
	
</body>
</html>