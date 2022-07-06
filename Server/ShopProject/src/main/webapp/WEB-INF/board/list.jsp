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
	.tbl-qna { text-align: center; }
	.tbl-qna th:nth-child(1) { width: 90px; }
	.tbl-qna th:nth-child(2) { width: auto; }
	.tbl-qna th:nth-child(3) { width: 130px; }
	.tbl-qna th:nth-child(4) { width: 150px; }
	.tbl-qna td:nth-child(2) { text-align: left; }
	.tbl-qna + div { float: right; }
	.tbl-qna + div input { margin-left: 10px; }
	.fa-n { color: cornflowerblue; }
	.tbl-qna .new {
		color: white; 
		background-color: skyblue;
		border-radius: 30%;		
		padding: 3px 5px;
		font-size: 10px;
		font-weight: bold;
	}
	.pagination { margin-top: 50px; }
	.pagination .page-item .page-link { color: #555; }
	.pagination .page-item.active .page-link { background-color: #eee; border-color: #AAA; }
	.search-qna.input-group { justify-content: center; margin-bottom: 30px; }
</style>
</head>
<body>
	
	 <main>
		<%@ include file="/WEB-INF/inc/header.jsp" %>
	 	<section>
			<h1>Board - Q&A</h1>
			
			<table class="table table-bordered tbl-qna">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
				</tr>	
				<c:forEach items="${list}" var="dto">	
				<tr>
					<c:if test="${dto.answerSeq == 0}">
					<td>${dto.seq}</td>
					</c:if>
					<c:if test="${dto.answerSeq > 0}">
					<td><i class="fa-solid fa-angles-right"></i></td>
					</c:if>
					
					<td>
						${dto.header}
						<c:if test="${dto.secret == 'Y'}">
						<i class="fa-solid fa-lock"></i>		
						</c:if>
						<c:if test="${dto.isNew == 'Y'}">
						<span class="new">N</span>
						</c:if>
					</td>
					<td>${dto.id}</td>
					<td>${dto.regdate}</td>
				</tr>		
				</c:forEach>
				<c:if test="${list == null}">
				<tr>
					<td colspan="4">Q&A 글 목록이 없습니다.</td>
				</tr>
				</c:if>
			</table>
			<div>
				<input type="button" value="나의 글" class="btn btn-secondary">
				<input type="button" value="글 쓰기" class="btn btn-dark">
			</div>
			
			
			<div class="input-group mb-3 search-qna">
			  	<div class="input-group-prepend">
				  	<select name="skey" class="form-control">
						<option value="subject" selected>제목</option>
						<option value="content">내용</option>
						<option value="id">작성자</option>
					</select>
			  	</div>
			  	<div class="col-sm-4">
		  			<input type="text" class="form-control" name="svalue">
				</div>
				<button class="btn btn-outline-secondary" type="button" onclick="search();">검색</button>
			</div>
			
			<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
			    <li class="page-item"><a class="page-link" href="/shop/board/list.do?page=1"><i class="fa-solid fa-angles-left"></i></i></a></li>
			    <li class="page-item"><a class="page-link" href="/shop/board/list.do?page=${page - 1}"><i class="fa-solid fa-angle-left"></i></a></li>
			   
			    <c:forEach var="i" begin="${pagebarBegin}" end="${pagebarEnd}">
			    <li class="page-item" id="page${i}"><a class="page-link" href="/shop/board/list.do?page=${i}">${i}</a></li>
			    </c:forEach>
			    
			    <li class="page-item"><a class="page-link" href="/shop/board/list.do?page=${page + 1}"><i class="fa-solid fa-angle-right"></i></a></li>
			    <li class="page-item"><a class="page-link" href="/shop/board/list.do?page=${lastPage}"><i class="fa-solid fa-angles-right"></i></a></li>
			</ul>
			</nav>
	 	</section>
	 </main>
	
	<script>
		$('#page${page}').addClass('active');
		
		function search() {
			location.href='/shop/board/list.do?skey='+  $('input[name=skey]').val() +'&svalue=' + $('input[name=svalue]').val();
		}
	</script>
	
</body>
</html>