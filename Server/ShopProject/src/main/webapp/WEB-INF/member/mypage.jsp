<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MJSHOES</title>
<%@ include file="/WEB-INF/inc/asset.jsp" %>
<style>
</style>
</head>
<body>
	
	 <main>
		<%@ include file="/WEB-INF/inc/header.jsp" %>
	 	<section>
	 		<h1>My Page</h1>
	 		<table class="table mypage-info">
	 			<tr>
	 				<td>
	 					<i class="fa-solid fa-circle-user"></i>
	 				</td>
	 				<td>
			 			<div>${auth.name}(${auth.id})님</div>
			 			<div>${grade} 회원 <i class="fa-solid fa-circle-question"></i></div>
			 			<a href="/shop/member/profile.do" class="badge badge-secondary">정보 수정</a>
	 				</td>
	 				<td>
		 				<div>
		 					쿠폰: 0
				 			<a href="#" class="badge badge-secondary">조회</a>
		 				</div>
	 					<div>
		 					적립금: ${point}
				 			<a href="#" class="badge badge-secondary">조회</a>
	 					</div>
	 				</td>
	 			</tr>
	 		</table>
	 		
	 		<table class="table table-bordered mypage-order">
	 			<tr>
	 				<th colspan="5" class="table-secondary">나의 주문 처리 현황(최근 3개월 기준)</td>
	 			</tr>
	 			<tr>
	 				<td>결제완료<div>${map.paid}</div></td>
	 				<td>배송준비중<div>${map.ready}</div></td>
	 				<td>배송중<div>${map.delivering}</div></td>
	 				<td>배송완료<div>${map.delivered}</div></td>
	 				<td>취소/반품/교환<div>${map.refund}</div></td>
	 			</tr>
	 		</table>
	 		
			<div class="row mypage-menu" >
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Order</h3>
			        <p class="card-text">주문내역</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Wish List</h3>
			        <p class="card-text">'좋아요'한 상품 목록</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Address</h3>
			        <p class="card-text">자주 사용하는 배송지</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Board</h3>
			        <p class="card-text">내가 쓴 게시물</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  </div>
			<div class="row mypage-menu">
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Profile</h3>
			        <p class="card-text">회원 정보</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Coupon</h3>
			        <p class="card-text">쿠폰</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Milege</h3>
			        <p class="card-text">적립금</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-3">
			    <div class="card">
			      <div class="card-body">
			      	<a href="#">
			        <h3 class="card-title">Cart</h3>
			        <p class="card-text">장바구니</p>
			        </a>
			      </div>
			    </div>
			  </div>
			  </div>
	 	</section>
	 </main>
	
	<script>
		
	</script>
	
</body>
</html>