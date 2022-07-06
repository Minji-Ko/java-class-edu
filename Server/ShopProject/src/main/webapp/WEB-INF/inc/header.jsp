<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<header>
	<nav class="nav-menu">
		<a href="/shop/index.do" class="brand">MJSHOES<a>
		<ul>
			<li><a href="#">New Arrivals</a></li>
			<li><a href="#">Best</a></li>
			<li><a href="#">Shop All</a></li>
			<li><a href="/shop/board/list.do">Board</a></li>
			<li><a href="#">About</a></li>
		</ul>
		<div class="search">
			<input type="text">
			<i class="fa-solid fa-magnifying-glass"></i>
		</div>
	</nav>
	<nav class="nav-mymenu">
		<ul>
			<c:if test="${empty auth}">
			<li><a class="badge badge-pill" href="/shop/member/login.do">login</a></li>
			<li><a class="badge badge-pill" href="/shop/member/join.do">join</a></li>
			</c:if>
			<c:if test="${not empty auth}">
			<li><a class="badge badge-pill" href="/shop/member/logout.do">logout</a></li>
			<li><a class="badge badge-pill" href="/shop/member/mypage.do">mypage</a></li>
			</c:if>
			<li><a class="badge badge-pill" href="#"><i class="fa-solid fa-cart-shopping"></i></a></li>
		</ul>
	</nav>
</header>