<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/toy/asset/css/tagify.css" />
<script src="/toy/asset/js/jQuery.tagify.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=50afd7bb7d0ec954215a57b040f3f045"></script>
<style>
.tagify {
	border: 0px solid transparent;
}
tr:nth-child(5) td {
	padding: 5px;
}
tr:last-child from {
	margin-right: 5px;
}
#btngood.btn-secondary, #btnbad.btn-secondary {
	opacity: .5;
}
#map {
	width: 100%;
	height: 400px;
}
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
				<tr>
					<th>파일</th>
					<td colspan="7">
						<c:if test="${not empty dto.orgfilename}">
						<a href="/toy/board/download.do?filename=${dto.filename}&orgfilename=${dto.orgfilename}">${dto.orgfilename}</a>
						</c:if>
						<c:if test="${empty dto.orgfilename}">
						파일 없음
						</c:if>
					</td>
				</tr>
				<tr>
					<th>태그</th>
					<td colspan="7"><input type="text" name="tags" readonly></td>
				</tr>
				<c:if test="${not empty lat}">
				<tr>
					<th>위치</th>
					<td colspan="7"><div id="map"></div></td>
				</tr>
				</c:if>
			</table>
			
			<form method="GET" action="/toy/board/goodbad.do" class="goodbad">
				<button class="btn btn-secondary" style="float:left;" id="btngood">
					<i class="fa-solid fa-thumbs-up"></i>
					<span class="badge badge-pill  badge-light">${dto.good}</span>
				</button>
				<input type="hidden" name="seq" value="${dto.seq}">
				<input type="hidden" name="column" value="${column}">
				<input type="hidden" name="word" value="${word}">
				<input type="hidden" name="good" value="1">	
				<input type="hidden" name="bad" value="0">	
			</form>
			<form method="GET" action="/toy/board/goodbad.do" class="goodbad">
				<button class="btn btn-secondary" style="float:left;" id="btnbad">
					<i class="fa-solid fa-thumbs-down"></i>
					<span class="badge badge-pill badge-light">${dto.bad}</span>
				</button>
				<input type="hidden" name="seq" value="${dto.seq}">
				<input type="hidden" name="column" value="${column}">
				<input type="hidden" name="word" value="${word}">	
				<input type="hidden" name="good" value="0">	
				<input type="hidden" name="bad" value="1">	
			</form>
						
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary" 
					onclick="location.href='/toy/board/list.do?column=${column}&word=${word}';">
				<c:if test="${auth == dto.id || auth == 'admin'}"> 
				<button class="btn btn-primary" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}&column=${column}&word=${word}';">
					수정하기
				</button>
				<button class="btn btn-primary" onclick="location.href='/toy/board/del.do?seq=${dto.seq}&column=${column}&word=${word}';">
					삭제하기
				</button>
				</c:if> 
				<c:if test="${not empty auth}">
				<button type="button" class="btn btn-primary" 
					onclick="location.href='/toy/board/add.do?reply=1&thread=${dto.thread}&depth=${dto.depth}&column=${column}&word=${word}';">답변쓰기</button>
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
		 
		
		/* $('#imgAttach').ready(function(){
			if($('#imgAttach').width() > 610) {
				$('#imgAttach').width('610');
			}
			$('#imgAttach').show();
		}) */
		
		let tag = '';
		
		<c:forEach items='${dto.taglist}' var="tag">
			tag += '${tag},';
		</c:forEach>		
		
		$('input[name=tags]').val(tag);
		
		
		const tagify = new Tagify(document.querySelector('input[name=tags]'), {});
		
		tagify.on('click', test);
		
		function test(e) {
			//alert(e.detail.data.value);
			
			location.href = '/toy/board/list.do?tag=' + e.detail.data.value;
		}
		
		<c:if test="${dto.goodbad == 1}">
			$('#btngood').attr('class', 'btn btn-info');
		</c:if>
		<c:if test="${dto.goodbad == 2}">
			$('#btnbad').attr('class', 'btn btn-danger');
		</c:if>
		
		
		<c:if test="${not empty lat}">
			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(37.499321, 127.033220),
				level: 7
			};
	
			var map = new kakao.maps.Map(container, options);
			
			var m = new kakao.maps.Marker({
				position: new kakao.maps.LatLng(${lat}, ${lng})
			})
			
			m.setMap(map);
		</c:if>
		
	</script>
	
</body>
</html>