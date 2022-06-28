<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<style>
	.fas.fa-fire-alt {
		<c:if test="${not empty auth and lv == 1}">
		color: tomato;
		</c:if>
		<c:if test="${not empty auth and lv == 2}">
		color: cornflowerblue;
		</c:if>
		<c:if test="${empty auth}">
		color: black;
		</c:if>
	}
	
	header > h1 > span {
		margin-top: 15px;
		margin-right: 15px;
		float:right;
		font-size: 16px;
		color: #777;
	}
	
</style>

<header>
	<h1><i class="fas fa-fire-alt"></i> 
		Toy Project
		<c:if test="${not empty auth}">
		<span>by ${auth}(${name})</span>
		</c:if>
	</h1>
	<nav>
		<ul>
			<li><a href="/toy/index.do">Home</a></li>
			<li><a href="/toy/board/list.do">Board</a></li>
			<li><a href="/toy/etc">Etc</a></li>
			<li><a href="/toy/etc">Etc</a></li>
			
			<c:if test="${empty auth}">
			<li><a href="/toy/member/register.do" class="badge badge-pill badge-primary">Register</a></li>
			<li><a href="/toy/member/login.do" class="badge badge-pill badge-primary">Login</a></li>
			</c:if>

			<c:if test="${not empty auth}">
			<li><a href="/toy/member/info.do" class="badge badge-pill badge-secondary">Info</a></li>
			<li><a href="/toy/member/logout.do" class="badge badge-pill badge-secondary">Logout</a></li>
			</c:if>

		</ul>
	</nav>
</header>
