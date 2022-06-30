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
			
			<table class="table table-bordered horizontal">
				<tr>
					<th>번호</th>
					<td>${dto.seq}</td>
					<th>이름</th>
					<td>${dto.name}</td>
					<th>날짜</th>
					<td>${dto.regdate}</td>
					<th>조회수</th>
					<td>${dto.readcount}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="7">${dto.subject}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7" style="height:300px; vertical-aiign: middle;">${dto.content}</td>
				</tr>
			</table>
			
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary" 
					onclick="location.href='/toy/board/list.do?column=${column}&word=${word}';">
				<c:if test="${auth == dto.id || auth == 'admin'}"> 
				<button class="btn btn-primary" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}';">수정하기</button>
				<button class="btn btn-primary" onclick="location.href='/toy/board/del.do?seq=${dto.seq}';">삭제하기</button>
				</c:if> 
				<c:if test="${not empty auth}">
				<button type="button" class="btn btn-primary" 
					onclick="location.href='/toy/board/add.do?reply=1&thread=${dto.thread}&depth=${dto.depth}';">답변쓰기</button>
				</c:if>
			</div>
			
			<c:if test="${not empty auth}">
			<form method="POST" action="/toy/board/addcommentok.do">
			<table class="tblAddComment">
				<tr>
					<td>
						<textarea class="form-control" name="comment" required></textarea>
					</td>
					<td>
						<button class="btn btn-primary">쓰기</button>
					</td>
				</tr>
			</table>
			<input type="hidden" name="pseq" value="${dto.seq}">
			<input type="hidden" name="column" value="${column}">
			<input type="hidden" name="word" value="${word}">
			</form>
			</c:if>

			<table class="table table-bordered comment">
				<c:forEach items="${clist}" var="cdto">
				<tr>
					<td>
						<div>${cdto.comment}</div>
						<div>
							<span>${cdto.regdate}</span>
							<span>${cdto.name}(${cdto.id})</span>
							<c:if test="${cdto.id == auth}">
							<span class="btnspan"><a href="#!" onclick="delcomment(${cdto.seq});">[삭제]</a></span>
							<span class="btnspan"><a href="#!" onclick="editcomment(${cdto.seq});">[수정]</a></span>
							</c:if>
						</div>
					</td>
				</tr>
				</c:forEach>
			</table>			
		</section>
	</main>
	<script>
		$('.table.comment td').mouseover(function(){
			$(this).find('.btnspan').show();
		})
		$('.table.comment td').mouseout(function(){
			$(this).find('.btnspan').hide();
		})
		
		function delcomment(seq) {
			if(confirm('delete?')) {
				location.href ='delcommentok.do?seq=' + seq + '&pseq=${dto.seq}&column=${column}&word=${word}'; 
			}
		}
		
		let isEdit = false;
		
		function editcomment(seq) {
			
			if(!isEdit) {

				const tempStr = $(event.target).parents('div').prev().html();
				
				$(event.target).parents('tr').after(temp);
				isEdit = true;
				
				$(event.target).parents('tr').next().find('textarea').val(tempStr.replace(/<br>/gi, '\r\n'));
				$(event.target).parents('tr').next().find('input[name=seq]').val(seq);
				
								
			}
		}
		
		function cancelform () {
				$('#editRow').remove();
				isEdit = false;
		}		
		
		const temp = 
		`<tr id="editRow" style="background-color: #EFEFEF;">
			<td>
				<form method="POST" action="/toy/board/editcommentok.do">
				<table class="tblEditComment">
					<tr>
						<td>
							<textarea class="form-control" name="comment" required></textarea>
						</td>
						<td>
							<button class="btn btn-primary">수정하기</button>
							<button type="button" class="btn btn-secondary" onclick="cancelform();">취소하기</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="pseq" value="${dto.seq}">
				<input type="hidden" name="column" value="${column}">
				<input type="hidden" name="word" value="${word}">
				<input type="hidden" name="seq">
				</form>
			</td>
		</tr>`;
		
	</script>
	
</body>
</html>