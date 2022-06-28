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
	.btns {
		margin-top: 10px;
	}
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>Unregister</h2>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident nostrum fugit facere quae ipsum esse tempora culpa accusamus dolorem recusandae dicta aperiam optio minima quo animi atque magni aut eius! Atque vel cum temporibus reprehenderit error dolores magni voluptas omnis dolore fugit nobis enim velit praesentium animi consectetur labore ex ipsa minus quae doloribus assumenda architecto accusantium. Blanditiis eum animi eos accusamus consectetur accusantium ipsa quibusdam doloribus ratione quae earum praesentium laudantium rem. Eveniet quis dicta officiis incidunt ut molestiae sunt ipsa molestias blanditiis eaque numquam veritatis reprehenderit dolore porro repudiandae suscipit corporis soluta facere deleniti itaque exercitationem architecto optio.</p>
			
			<div class="btns">
				<input type="button" value="돌아가기" class="btn btn-secondary" 
					onclick="location.href='/toy/member/info.do';">
				<input type="button" value="탈퇴하기" class="btn btn-danger"
					onclick="location.href='/toy/member/unregisterok.do';">
			</div>
		</section>
	</main>
	<script>
	</script>
	
</body>
</html>