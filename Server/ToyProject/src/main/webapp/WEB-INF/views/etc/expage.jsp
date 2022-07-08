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
			<h2>크롤링</h2>
		
			<div>이름: <span>${name}</span></div>

			<h2>크롤링</h2>
		
			<div>이름: <span id="name"></span></div>
		</section>
	</main>
	<script>
	
		$('#name').text('아무개');
	
		/* $.ajax({
			type: 'GET',
			url: '',
			dataType: 'json',
			success: function(result){
				$('#name').text(result.name);
			},
			error: function(a, b, c){
				console.log(a, b, c);
			}
		}); */
	</script>
	
</body>
</html>