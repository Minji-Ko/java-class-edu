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
	.btn { float: none;}
</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			<h2>Ajax</h2>
			
			<h4>동기 통신(직렬 통신)</h4>
			<input type="button" value="확인" class="btn btn-primary" id="btn1">
			<span id="msg1"></span>
			
			<hr>
			
			<h4>비동기 통신(병렬 통신)</h4>
			<input type="button" value="확인" class="btn btn-primary" id="btn2">
			<span id="msg2"></span>
			
			<hr>
			<input type="text">
			
			<hr>
			
			<h4>통신 패턴 3가지</h4>
			<input type="button" value="1. 서버로부터 데이터 가져오기" class="btn btn-primary" id="btn3" />
			<input type="button" value="2. 서버에게 데이터 보내기" class="btn btn-primary" id="btn4" />
			<input type="button" value="3. 서버에게 데이터 보내기 + 서버로부터 데이터 가져오기" class="btn btn-primary" id="btn5" />
			
			<hr>
			
			<h2>jQery Ajax</h2>
			<input type="button" value="데이터 가져오기" class="btn btn-primary" id="btn6" />
			<input type="button" value="데이터 보내기" class="btn btn-primary" id="btn7" />
			<div id="msg3">결과: <span></span></div>
			
		</section>
	</main>
	<script>
	
		let ajax;
		
		$('#btn1').click(function(){
			
			ajax = new XMLHttpRequest();
			ajax.onreadystatechange = m1;
			ajax.open('GET', '/toy/ajax/ex04data.do', false); //동기통신(사용안함) 
			ajax.send();
			
		})
		
		function m1() {
			if(ajax.readyState == 4 && ajax.status == 200){
				$('#msg1').text(ajax.responseText);
			}
		}
		
		$('#btn2').click(function(){
			
			ajax = new XMLHttpRequest();
			ajax.onreadystatechange = m2;
			ajax.open('GET', '/toy/ajax/ex04data.do'); //생략하면 비동기통신(true) **
			ajax.send();
			
		})
		
		function m2() {
			if(ajax.readyState == 4 && ajax.status == 200){
				$('#msg2').text(ajax.responseText);
			}
		}

		
		$('#btn3').click(function(){
			//데이터 가져오기
			ajax = new XMLHttpRequest();
			ajax.open('GET', '/toy/ajax/ex04data3.do');
			ajax.onreadystatechange = function(){ //데이터 수신을 위해서 이벤트 등록(***)
				if(ajax.readyState == 4 && ajax.status == 200){
					alert(ajax.responseText);
				}
			};
			ajax.send();
			
		});
		$('#btn4').click(function(){
			//데이터 보내기(GET, POST)
			ajax = new XMLHttpRequest();
			ajax.open('GET', '/toy/ajax/ex04data4.do?name1=aaa');
			ajax.send();
			//ajax.open('POST', '/toy/ajax/ex04data4.do');
			//ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			//ajax.send('name2=bbb');
			
		});
		$('#btn5').click(function(){
			//데이터 가져오기 + 데이터 보내기
			ajax = new XMLHttpRequest();
			ajax.open('GET', '/toy/ajax/ex04data5.do?name=hong'); //데이터 보내고
			ajax.onreadystatechange = function() { //데이터 수신을 위해서(***)
				if (ajax.readyState == 4 && ajax.status == 200) {
					alert(ajax.responseText);
				}
			};
			ajax.send();	
			
		});
		
		
		$('#btn6').click(function(){
			
			//ajax.send();
			$.ajax({
				//ajax.open('GET', 'URL') - 요청 주소
				type: 'GET',
				url: '/toy/ajax/ex04data3.do',
				
				success: function(result) {	//onreadystatechange
					//result == ajax.reponseText
					alert(result);
				},
				error: function(a, b, c){
					console.log(a, b, c);
				}
				
			}); 
		});
		
		$('#btn7').click(function(){
			
			$.ajax({
				//ajax.open('GET', 'URL') - 요청 주소
				type: 'GET',
				url: '/toy/ajax/ex04data4.do',
				data: 'name1=hong&name2=lee', //QueryString > key=value
				error: function(a, b, c){
					console.log(a, b, c);
				}
				
			}); 
		});
		
		
		
		//Thread, Socket
	</script>
	
</body>
</html>