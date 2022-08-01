<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
	
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td><a href="/spring/view?seq=${dto.seq}">${dto.subject}</a></td>
			<td>${dto.id}</td>
			<td>${dto.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	
	<div>
		<input type="button" value="쓰기" class="btn btn-primary"
			onclick="location.href='/spring/add';">
	</div>
	
</section>