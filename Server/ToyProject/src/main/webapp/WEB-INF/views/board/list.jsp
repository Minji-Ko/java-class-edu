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
			
			<table>
			</table>
			
			<div class="btns">
				<input type="button" value="글쓰기" class="btn btn-primary"
					onclick="location.href='/toy/board/add.do';">
			</div>
		</section>
	</main>
	<script>
	
	</script>
	
</body>
</html>