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
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>Board</h2>
			
			<c:if test="${map.isSearch == 'y'}">
			<div style="text-align: center; margin-bottom: 10px; color: gray;">
				'${map.word}'으로 검색한 결과 총 ${list.size()}개의 게시물이 발견되었습니다. 
			</div>
			</c:if>
			
			<table class="table table-bordered horizontal">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>이름</th>
					<th>날짜</th>
					<th>읽음</th>
				</tr>
				<c:forEach items="${list}" var="dto">
				<%-- <c:if test="${dto.readcount < 10}"> --%>
				<tr>
				<%-- </c:if>
				<c:if test="${dto.readcount >= 10}">
				<tr style="font-color: gold;">
				</c:if> --%>
					<td>${dto.seq}</td>
					<td>
						<c:if test="${dto.depth > 0}">
						<i class="fa-solid fa-circle-chevron-right" style="margin-left:${dto.depth * 20}px;"></i>
						</c:if>
						
						<a href="/toy/board/view.do?seq=${dto.seq}&column=${map.column}&word=${map.word}">${dto.subject}</a>

						<c:if test="${not empty dto.filename}">
						<i class="fa-solid fa-floppy-disk"></i>
						</c:if>
						<c:if test="${dto.commentcount > 0}">
						<span class="badge badge-pill badge-secondary">${dto.commentcount}</span>
						</c:if>
						
						<c:if test="${dto.isNew * 24 < 3}">
						<span style="color:cornflowerblue;">new</span>
						</c:if>
					</td>
					<td>${dto.name}</td>
					<td>${dto.regdate}</td>
					<td>${dto.readcount}</td>
				</tr>
				</c:forEach>
				<c:if test="${empty list}">
				<tr>
					<td colspan="5">게시물이 없습니다.</td>
				</tr>
				</c:if>
			</table>
			
			
			<div style="text-align: center;">
				<%-- <select id="pagebar">
					<c:forEach var="i" begin="1" end="${totalPage}">
					<option value="${i}">${i}페이지</option>
					</c:forEach>
				</select> --%>
				${pagebar}
			</div>
			
			
			<div>
				<form method="GET" action="/toy/board/list.do">  <!-- 검색 용도의 form은 주로 GET방식으로! -->
				<table class="search">
					<tr>
						<td>
							<select name="column" class="form-control">
								<option value="subject">제목</option>
								<option value="content">내용</option>
								<option value="name">이름</option>
							</select>
						</td>
						<td>
							<input type="text" name="word" class="form-control" required>
						</td>
						<td>
							<c:if test="${map.isSearch == 'y'}">
							<input type="button" class="btn btn-secondary" onclick="location.href='/toy/board/list.do';" value="초기화">
							</c:if>
							<button class="btn btn-primary">검색하기</button>
						</td>
					</tr>
				</table>
				
				<c:if test="${not empty auth}">
				<div class="btns">
					<button class="btn btn-primary" onclick="location.href='/toy/board/add.do';">
						<i class="fas fa-pen"></i> 글쓰기
					</button>
				</div>
				</c:if>
				</form>
			</div>
			
		</section>
	</main>
	<script>
		<c:if test="${map.isSearch == 'y'}">
			$('select[name=column]').val('${map.column}');
			$('input[name=word]').val('${map.word}');
		</c:if>
		
		$('#pagebar').change(function(){
			location.href='/toy/board/list.do?page=' + $(this).val() + "&column=${map.column}&word=${map.word}";			
		})
		
		$('#pagebar').val('${page}');
		
	</script>
	
</body>
</html>