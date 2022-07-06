<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
input[type=button] { float: none; }
</style>
</head>
<body>
	<main>
		<section>
			<h2>아이디 중복검사</h2>
			
			<form method="POST" action="/toy/ajax/idcheckok.do">
			<table class="table table-bordered" style="width: 320px;">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" id="id" value="${id}" class="form-control" style="width: 100px;">
					</td>
					<td>
						<input type="submit" value="중복 검사" class="btn btn-primary">
					</td>
				</tr>
				<tr>
					<td colspan="3" id="msg"></td>
				</tr>
			</table>
			</form>
			
			<div class="btns">
				<input type="button" value="닫기" class="btn btn-secondary"
					onclick="window.close();">
				<input type="button" value="사용하기" class="btn btn-primary" id="btnUse" disabled
					onclick="useId();">
			</div>
		</section>
	</main>
	<script>
	
		<c:if test="${result == 1}">
			$('#msg').text('이미 사용중인 아이디입니다.');
			$('#btnUse').prop('disabled', true);
		</c:if>
		<c:if test="${result == 0}">
			$('#msg').text('사용 가능한 아이디입니다.');
			$('#btnUse').prop('disabled', false);
		</c:if>
		
		function useId() {
			//opener.document.form1.txt1.value = window.document.form1.txt1.value();
			$(opener.document).find('#id').val($('#id').val());
			window.close();
		}
	
	</script>
	
</body>
</html>