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

			<h2>데이터 포맷</h2>
			
			<fieldset>
				<legend>Text</legend>
				<input type="text" name="txt1" id="txt1" class="control-form"/>
				<input type="button" value="확인" id="btn1" class="btn btn-primary" />
				<div id="msg1"></div>
			</fieldset>

			<fieldset>
				<legend>XML</legend>
				<input type="text" name="txt2" id="txt2" class="control-form">
				<input type="button" value="확인" id="btn2" class="btn btn-primary" />
				<div id="msg2"></div>
			</fieldset>

			<fieldset>
				<legend>JSON</legend>
				<input type="text" name="txt3" id="txt3" class="control-form">
				<input type="button" value="확인" id="btn3" class="btn btn-primary" />
				<div id="msg3"></div>
			</fieldset>

			<fieldset>
				<legend>Text + XML + JSON</legend>
				<input type="text" name="txt4" id="txt4" class="control-form">
				<input type="button" value="확인" id="btn4" class="btn btn-primary" />
				<div id="msg4"></div>
			</fieldset>

			<fieldset>
				<legend>Text + XML + JSON</legend>
				<form id="form">
				<input type="text" name="subject" id="subject" class="control-form" placeholder="제목">
				<input type="text" name="content" id="content" class="control-form" placeholder="내용">
				<input type="text" name="id" id="id" class="control-form" value="hong">
				</form>
				<input type="button" value="쓰기" id="btn5" class="btn btn-primary" />
				<div id="msg5"></div>
			</fieldset>

		</section>
	</main>
	<script>
		/*
			$.ajax({
				type: 'GET',			//요청 메소드 방식
				url: '',				//응답 주소
				data: '',				//전송 데이터(줄 때)
				dataType: '',			//응답 데이터 타입(받을 때) > 'text', 'json', 'xml'
				success: function(){
					
				}, 						//응답 콜백 함수
				error: function(){
					
				}						//에러 처리 함수
			})
		*/
	
		$('#btn1').click(function(){
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex05text.do',
				dataType: 'text',
				success: function(result){
					
					//다중 데이터
					/* let temp = result.split(',');
					
				 	$('#msg1').append('<ul>');
					$('#msg1').append('<li>'+ temp[0] + '</li>');
					$('#msg1').append('<li>'+ temp[1] + '</li>');
					$('#msg1').append('<li>'+ temp[2] + '</li>');
					$('#msg1').append('</ul>'); */ 
					
					let temp = result.split('\r\n');
					
					temp.forEach(function(item, index){
						
						let temp2 = item.split(',');
						
						$('#msg1').append('<ul>');
						$('#msg1').append('<li>'+ temp2[0] + '</li>');
						$('#msg1').append('<li>'+ temp2[1] + '</li>');
						$('#msg1').append('<li>'+ temp2[2] + '</li>');
						$('#msg1').append('</ul>');
					})
				},
				error: function(a, b, c){
					console.log(a, b, c);
				}
			});
		});
		
		//다중데이터? xml이나 json으로 처리!
		$('#btn2').click(function(){
			$.ajax({ 
				type: 'GET',
				url: '/toy/ajax/ex05xml.do',
				dataType: 'xml',
				success: function(result) {
					
					//		 > DOM document 객체
					//result > XML 문서 객체
					
					//<name>홍길동</name>
					//alert(result);
					
					//단일데이터
					//$('#msg2').text($(result).find("name").text());
					
					//다중 데이터
					/* 
					let subject = $(result).find('subject').text();
					let content = $(result).find('content').text();
					let name = $(result).find('name').text();
					let regdate = $(result).find('regdate').text();
					
					$('#msg2').append('<ul>');
					$('#msg2').append('<li>' + subject + '</li>');
					$('#msg2').append('<li>' + content + '</li>');
					$('#msg2').append('<li>' + name + '</li>');
					$('#msg2').append('<li>' + regdate + '</li>');
					$('#msg2').appned('</ul>');
					$('#msg2').appned('<br>'); 
					*/

					$(result).find('item').each(function(index, item){
						
						let subject = $(item).find('subject').text();
						let name = $(item).find('name').text();
						let regdate = $(item).find('regdate').text();
						
						$('#msg2').append('<ul>');
						$('#msg2').append('<li>' + subject + '</li>');
						$('#msg2').append('<li>' + name + '</li>');
						$('#msg2').append('<li>' + regdate + '</li>');
						$('#msg2').append('</ul>');
						$('#msg2').append('<br>');
					}); 
					

				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});	
		});
		
		$('#btn3').click(function(){
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex05json.do',
				dataType: 'json',
				success: function(result) {
					
					//alert(result.name);
					//$('#msg3').text(result.name);
					
					//다중데이터
					//{
					//	"subject": "안녕하십니까",
					//	"content": "저는 권경환입니다. 이야이야요!",
					//	"name": "권경환",
					//	"regdate": "2022-06-29 22:22:14"
					//}
					
					/* 
					$('#msg3').append('<ul>');
					$('#msg3').append('<li>' + result.subject + '</li>');
					$('#msg3').append('<li>' + result.content + '</li>');
					$('#msg3').append('<li>' + result.name + '</li>');
					$('#msg3').append('<li>' + result.regdate + '</li>');
					$('#msg3').append('</ul>'); 
					*/
					
					$(result).each(function(index, item) {
						
						$('#msg3').append('<ul>');
						$('#msg3').append('<li>' + item.subject + '</li>');
						$('#msg3').append('<li>' + item.name + '</li>');
						$('#msg3').append('<li>' + item.regdate + '</li>');
						$('#msg3').append('</ul>'); 
					});
					                       
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		});
		
		
		$('#btn4').click(function(){
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex05data.do',
				data: 'txt4=' + $('#txt4').val(),
				dataType: 'json',
				success: function(result){
					$('#msg4').append('<div>status: '+ result.status + '</div>');
					$('#msg4').append('<div>value: '+ result.value +'</div>');
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
				
			});
		});

		$('#btn5').click(function(){
			
			$.ajax({
				type: 'POST',
				url: '/toy/ajax/ex05board.do',
//				data: 'subject='+$('#subject').val()+'&content='+$('#content').val()+'&id='+$('#id').val(),
				data: $('#form').serialize(),
				dataType: 'json',
				success: function(result){
					$('#msg5').text(result.result == '1'? '성공' : '실패');
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
				
		});
		
		
	</script>
	
</body>
</html>