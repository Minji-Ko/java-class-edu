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
		</section>
	</main>
	<script>
		<c:if test="${not empty auth}">  //${auty != null} 보다는 empty를 많이 사용함
			location.href = '/toy/index.do';
		</c:if>
		<c:if test="${empty auth}">
			alert('failed');
			history.back();
		</c:if>
	</script>
	
</body>
</html>