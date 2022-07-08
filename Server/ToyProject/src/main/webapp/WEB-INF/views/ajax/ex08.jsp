<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script src="/toy/asset/js/jquery-ui.js"></script>
<style>

</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>jQuery + Ajax</h2>
	
			<img src="/toy/asset/images/catty01.png" class="drag" id="cat01">
			<img src="/toy/asset/images/catty02.png" class="drag" id="cat02">
			<img src="/toy/asset/images/catty03.png" class="drag" id="cat03">
	
		</section>
	</main>
	<script>

		$('.drag').draggable({
		  stop: function( event, ui ) {
			  let id = this.id;
			  let left = ui.position.left;
			  let top = ui.position.top;
			  
			  //alert(id + ',' + x + ',' + y);
			  
			  $.ajax({
				  	type: 'POST',
			  		url: '/toy/ajax/ex08data.do',
			  		data: 'id=' + id + '&left=' + left + '&top=' + top,
			  		dataType: 'json',
			  		success: function(result){
			  			
			  			if(result.result == '1'){
			  				console.log('성공');
			  			}
			  		},
			  		error: function(a, b, c) {
			  			console.log(a, b, c);
			  		}
			  	
			  })
		  }
		});
		$('.drag').mousedown(function(evt){
			
		});
		
		<c:forEach items='${list}' var="dto">
		$('#${dto.id}').css({
			left: '${dto.left}px',
			top: '${dto.top}px'
		});
		</c:forEach>
		
	</script>
	
</body>
</html>