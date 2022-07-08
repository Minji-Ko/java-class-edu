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
	form {
		display: flex;
	}
	
	form input[name=query] {
		width: 300px;
		margin-right: 5px;
	}
	
	.table th { text-align: center; }
	.table th:nth-child(1) { width: 100px; }
	.table th:nth-child(2) { width: auto; }
	.table th:nth-child(3) { width: 200px; }
	.table td:nth-child(2), .table td:nth-child(3) { padding-left: 20px; }
	
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>Naver Books</h2>
			
			<div class="well well-sm">
				<form method="GET" action="/toy/etc/openapi02.do">
					<input type="text" name="query" class="form-control" placeholder="검색어를 입력하세요." value="${query}" required>
					<input type="submit" value="검색하기" class="btn btn-primary">
				</form>
			</div>
			
			
			<hr>
			
			<table class="table table-bordered">
				<c:if test="${not empty rdto}">
				<tr>
					<th>표지</th>
					<th>제목 / 저자 / 가격</th>
					<th>출판사 / 출판일</th>
				</tr>	
				<c:forEach items="${rdto.list}" var="dto">
				<tr>
					<td><img src="${dto.image}"></td>
					<td>
						<div>제목: <a href="${dto.link}">${dto.title}</a></div>
						<div>저자: ${dto.author}</div>
						<div>가격:
					 		<c:if test="${empty dto.discount}">
					 		<span>${dto.price}원</span>
							</c:if>
					 		<c:if test="${not empty dto.discount}">
					 		<span style="text-decoration:line-through;">${dto.price}원</span> ▶️ <span>${dto.discount}원</span> 
							</c:if>
						</div>
					</td>
					<td>
						<div>출판사: ${dto.publisher}</div>
						<div>출판일: ${dto.pubdate}</div>
					</td>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${empty rdto}">
				<tr>
					<td colspan="3">검색 결과가 없습니다.</td>
				</tr>
				</c:if>
			</table>
			
			<hr>
			
			<c:forEach var="i" begin="1" end="${rdto.totalPage}">
				<a href="/toy/etc/openapi02.do?page=${i}&query=${rdto.query}">${i}</a>
			</c:forEach>
			
		</section>
	</main>
	<script>
	
	</script>
	
</body>
</html>