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

<!--  
	id 중복검사 / 비밀번호 검사 / 주소 폼/
-->
	
	 <main>
		<%@ include file="/WEB-INF/inc/header.jsp" %>
	 	<section>
	 		<h1>Join us</h1>
	 		<h2>기본정보</h2>
	 		<form class="form-join" method="POST" action="/shop/member/joinok.do">
	 		<table class="table table-bordered tbl-join">
	 			<tr>
	 				<th>
	 					아이디
	 					<div>(영어 대소문자/숫자)</div>
	 				</th>
	 				<td>
	 					<input type="text" name="id" class="form-control" required>
	 					<input type="button" class="btn btn-dark" value="중복검사" onclick="checkId();">
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>
	 					비밀번호
	 					<div>(영문 대문자, 숫자 포함 10자 이상)</div>
	 				</th>
	 				<td>
	 					<input type="password" name="pw" class="form-control" required>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>비밀번호 확인</th>
	 				<td>
	 					<input type="password" name="checkPw" class="form-control" required>
	 					<span></span>
	 				</td>
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
	 		</table>
	 		<h2>추가정보</h2>
	 		<table class="table table-bordered tbl-join">
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
	 				<td><input type="number" name="footSize" maxlength="3" class="form-control">mm</td>
	 			</tr>
	 		</table>
	 		
	 		<input type="submit" value="submit" class="btn btn-dark" disabled>
	 		</form>
	 	
	 	</section>
	 </main>
	
	<script>
	
		$('input[name=email2]').next().change(function(){
			$('input[name=email2]').val($('input[name=email2]').next().val());
		})
		
		let ckId = false;
		let ckPw = false;
		
		//TODO
		function checkId() {
			alert($('input[name=id]').val() + ' 중복검사 미완성');
			ckId = true;
			submitOk();
			
		}
		
		$('input[name=checkPw]').focusout(function(){
			if($('input[name=checkPw]').val() == $('input[name=pw]').val()){
				ckPw = true;
				$('input[name=checkPw]').next().html('<i class="fa-solid fa-check"></i>');
				$('input[name=checkPw]').next().css('color', 'cornflowerblue');
			} else {
				ckPw = false;
				$('input[name=checkPw]').next().text('비밀번호가 일치하지 않습니다.');
				$('input[name=checkPw]').next().css('color', 'red');
			}
			submitOk();
		})
		
		
		function submitOk(){
			if (ckId && ckPw) {
				$('input[type=submit]').attr('disabled', false);
				$('input[type=submit]').css('cursor', 'pointer');
			} else {
				$('input[type=submit]').attr('disabled', true);
				$('input[type=submit]').css('cursor', 'default');
				
			}
		}
		
		
		
	</script>
	
</body>
</html>