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
	.table th, .table td { text-align: center; }
	.table td:nth-child(5) { text-align: left; }
	.table th:nth-child(1) { width: 80px; }
	.table th:nth-child(2) { width: 60px; }
	.table th:nth-child(3) { width: 60px; }
	.table th:nth-child(4) { width: 150px; }
	.table th:nth-child(5) { width: auto; }
	.table th:nth-child(6) { width: 60px; }
	
	form input, form select { margin: 10px 0; }
	form input[type=text] { width: 120px; }
	form input[type=text]:nth-child(4) { width: 200px; }
	form input[type=text]:nth-child(5) { width: 400px; }
	form select.form-control { width: 120px; }
	input[type=button] { float:none; }
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>
				주소록 
				<small>
					<input type="button" value="남자" class="btn btn-secondary" onclick="search('m')">
					<input type="button" value="여자" class="btn btn-secondary" onclick="search('f')">
					<input type="button" value="모두" class="btn btn-secondary" onclick="search('all')">
				</small>
			</h2>
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>이름</th>
						<th>나이</th>
						<th>성별</th>
						<th>전화</th>
						<th>주소</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.name}</td>
						<td>${dto.age}</td>
						<td>${dto.gender}</td>
						<td>${dto.tel}</td>
						<td>${dto.address}</td>
						<td><input type="button" value="삭제" class="btn btn-warning" onclick="del(${dto.seq});"></td>
					</tr>
					</c:forEach>
					<c:if test="${list == null}">
					<tr>
						<td colspan="6">직원이 없습니다.</td>
					</tr>
					</c:if>
				</tbody>
			</table>
			
			<form>
			<div>
				<input type="text" name="name" id="name" class="form-control" placeholder="이름">		
				<input type="text" name="age" id="age" class="form-control" placeholder="나이">		
				<select name="gender" id="gender" class="form-control" required>
					<option value="" selected>성별</option>
					<option value="m">남자</option>
					<option value="f">여자</option>
				</select>
				<input type="text" name="tel" id="tel" class="form-control" placeholder="전화">		
				<input type="text" name="address" id="address" class="form-control" placeholder="주소">		
			</div>
			<div>
				<input type="button" value="등록하기" class="btn btn-primary" onclick="add();">
			</div>
			</form>
			
			
		</section>
	</main>
	<script>
	
		function search(gender) {
			
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex07search.do',
				data: 'gender='+ gender,
				dataType: 'json',
				success: function(result) {
					
					$('table tbody').html('');
					
					$(result).each(function(index, item){
						
						let temp = '';
						temp += '<tr>';
						temp += '<td>' + item.name + '</td>'; 
						temp += '<td>' + item.age + '</td>'; 
						temp += '<td>' + item.gender + '</td>'; 
						temp += '<td>' + item.tel + '</td>'; 
						temp += '<td>' + item.address + '</td>'; 
						temp += '<td><input type="button" value="삭제" class="btn btn-warning" onclick="del('+ item.seq + ');"></td>';
						temp += '</tr>';
						
						$('table tbody').append(temp);
					});
					
					if(result.length==0){
						$('table tbody').html('<tr><td colspan="6">직원이 없습니다.</td></tr>');
					}
					
				},
				error: function(a, b, c){
					console.log(a, b, c);
				}
			});
			
		}
	
		function add(){
			$.ajax({
				type: 'POST',
				url: '/toy/ajax/ex07add.do',
				data: $('form').serialize(),
				dataType: 'json',
				success: function(result){
					if (result.result == 1) {

						search('all');
						
						/* let temp = ''; 
						temp += '<tr>'; 
						temp += '<td>' + $('#name').val() + '</td>'; 
						temp += '<td>' + $('#age').val()  + '</td>'; 
						temp += '<td>' + ($('#gender').val()=='f'? '여자' :'남자')  + '</td>'; 
						temp += '<td>' + $('#tel').val()  + '</td>'; 
						temp += '<td>' + $('#address').val()  + '</td>'; 
						temp += '<td><input type="button" value="삭제" class="btn btn-warning" onclick="del('+ result.seq + ');"></td>';
						temp += '</tr>'; 
						
						$('table tbody').append(temp);
						 */
						
						 $('form div:first-child').children().val('');
						 
					} else {
						alert('등록 실패;;');
					}
				},
				error: function(a, b, c){
					console.log(a, b, c);
				}
			});
			
		}

		
		function del(seq){
			
			let tr = $(event.target).parents('tr');
			
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex07del.do',
				data: 'seq='+seq,
				dataType: 'json',
				success: function(result){
					
					if(result.result == 1){
						tr.remove();
					} else {
						alert('삭제 실패;;');
					}
				},
				error: function(a, b, c){
					console.log(a, b, c);
				}
			});
		}
	</script>
	
</body>
</html>