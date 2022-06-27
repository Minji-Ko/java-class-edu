<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<div>
	<h1>조각 페이지</h1>

	조각 페이지 영역 
	
	<%-- <p>1. 지역 변수 a: <%= a %></p> --%>
	<%-- <p>2. 멤버 변수 b: <%= b %></p> --%>
	<p>3. pageContext c: <%= pageContext.getAttribute("c") %></p>  	<!-- ***자주 사용 -->
	<p>4. request d: <%= request.getAttribute("d") %></p> 	
	
</div>