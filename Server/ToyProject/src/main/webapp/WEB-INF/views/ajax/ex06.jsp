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
	input[type=button]{float:none;}
	.table th, .table td {
		text-align: center;
	}
	.table th:nth-child(1) {width: 80px;}
	.table th:nth-child(2) {width: 150px;}
	.table th:nth-child(3) {width: 150px;}
	.table th:nth-child(4) {width: auto;}
	.table th:nth-child(5) {width: 150px;}
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>직원</h2>
			
			<div class="well well-sm" style="margin-bottom:10px;">
				<c:forEach items="${blist}" var="buseo">
				<input type="button" value="${buseo}" class="btn btn-secondary btnBuseo">
				</c:forEach>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>직원</th>
						<th>연락처</th>
						<th>거주지</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="5">직원이 없습니다.</td>
					</tr>
				</tbody>
			</table>
		</section>
	</main>
	<script>
		$('.btnBuseo').click(function(){
			//$('.btnBuseo').removeClass('btn-primary');
			//$(this).addClass('btn-primary');
			$('.btnBuseo').attr('class', 'btn btn-secondary btnBuseo');
			$(this).attr('class', 'btn btn-primary btnBuseo');
			this.blur();
			
			let buseo = $(this).val();
			
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex06data.do',
				data: 'buseo=' + buseo,
				dataType: 'json',
				success: function(result){
					let temp = '';
					
					$(result).each(function(index, item){
						//직원 1명 > JSON 객체 1개
						temp += '<tr>';
						temp += '<td>'+ item.num +'</td>';
						temp += '<td>'+ item.name +'</td>';
						temp += '<td>'+ item.jikwi +'</td>';
						temp += '<td>'+ item.tel +'</td>';
						temp += '<td>'+ item.city +'</td>';
						temp += '</tr>';
					});
					
					$('table tbody').html('');
					$('table tbody').append(temp);
					
				},
				error: function(a, b, c){
					console.log(a, b, c);
				}
			});			
		})
	</script>
	
</body>
</html>