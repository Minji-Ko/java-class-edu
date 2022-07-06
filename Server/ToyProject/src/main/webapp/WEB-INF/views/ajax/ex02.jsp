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
			<h2>Ajax</h2>
			<h4>기존방식</h4>
			<div>
				<input type="text" id="txt1" value="${cnt}">
				<input type="button" value="확인" id="btn1" onclick="location.href='/toy/ajax/ex02data.do';">
			</div>
			<div>
				<input type="text">			
			</div>
			
			<hr>
			
			<h4>Ajax방식</h4>
			<div>
				<input type="text" id="txt2">
				<input type="button" value="확인" id="btn2" onclick="test();">
			</div>
			<div>
				<input type="text">			
			</div>

			<hr>
			
			<h4>Ajax방식</h4>
			<input type="button" value="확인" id="btn3" onclick="test2();">
			<span id="txt3"></span>			
			
		</section>
	</main>
	<script>
		let ajax;
		
		function test() {
			
			//Ajax 통신을 지원하는 자바스크립트 객체
			ajax = new XMLHttpRequest();
			
			alert(ajax);
			
			if (ajax != null) {
				ajax.onreadystatechange = m1; 	//데이터 수신
				ajax.open('GET', '/toy/ajax/ex02data2.do'); //<form method action>
				ajax.send(); //<input type="submit">
				
			} else {
				alert('접속한 브라우저 XMLHttpRequest를 지원하지 않습니다.'); //과거엔 검사를 했음
			}
			
		}
		
		function m1() {
			
			//브라우저 요청 > 코드 해석 후 출력
			//Ajax 요청(브라우저 내의 javascript객체 중 하나) > 코드 반환
			
			if(ajax.readyState == 4 && ajax.status == 200) {
				//alert(ajax.responseText);
				$('#txt2').val(ajax.responseText);
			}
		}
		
		function test2(){
			
			ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = m2;
			
			//ajax.open('GET', 'URL');
			ajax.open('GET', '/toy/data.txt');
			//ajax.open('GET', '/toy/data.xml');
			//ajax.open('GET', '/toy/data.json');
			//ajax.open('GET', '/toy/data.do');
			//ajax.open('GET', '/toy/ajax/ex02data2.do');
			
			ajax.send();
		}
		
		function m2() {
			console.log('ajax.readyState', ajax.readyState);
			console.log('ajax.status', ajax.status);

			
			//ajax.readyState == 4
			// - http://www.tcpschool.com/ajax/ajax_server_response
			/* 
			 1. UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨.
			 2. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨.
			 3. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.
			 4. LOADING (숫자 3) : 요청한 데이터를 처리 중임.
			 5. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
			*/
			//ajax.status == 200
			//- https://developer.mozilla.org/ko/docs/Web/HTTP/Status
			//- 200OK, 403, 404, 405, 500
			if (ajax.readyState == 4 && ajax.status == 200) {
				
				//ajax.responseText > 단일 데이터
				//ajax.resonseXML 	> 다중 데이터
				console.log(ajax.responseText);
				
				$('#txt3').text(ajax.responseText);
			}
			
			console.log('');
		}
		
		
	</script>
	
</body>
</html>