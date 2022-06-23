<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String txt = request.getParameter("txt");
	String bgcolor = request.getParameter("bgcolor");
	String color = request.getParameter("color");
	String fontsize = request.getParameter("fontsize");
	String num = request.getParameter("num");
	String marginleft = request.getParameter("marginleft");
	String margintop = request.getParameter("margintop");
	String icon = request.getParameter("icon");
	String sel = request.getParameter("sel");
	String thick = request.getParameter("thick");
	String bcolor = request.getParameter("bcolor");
	String style = request.getParameter("style");
	String radius = request.getParameter("radius");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>
<style>
	#main {
		border: 1px solid #999;
		text-align: center;
	}
	#main #result {
		border-top: 1px solid #999;
		padding: 30px;
	}
	#main #result input[type=button] {
		text-align: center;
		width:<%= width %>px;
		height: <%= height %>px;
		background-color: <%= bgcolor %>;
		color: <%= color %>;
		font-size: <%= fontsize %>px;
		margin: <%= margintop%>px <%=marginleft %>px;
	}
	
</style>
</head>
<body>
	<h1>결과</h1>
	<div id="main">
		<div>버튼</div>
		<div id="result"></div>
	</div>

	<script>

	for(let i=0; i<<%= num %>; i++){ 
		
		let btn = document.createElement('input');
		btn.setAttribute('type', 'button');
		btn.setAttribute('value', '<%= icon %> <%=txt %>'); 
		
		if('<%= sel %>' == '보이기') {
			
			btn.setAttribute('style', 'border: <%= thick %>px <%= style %> <%= bcolor %>; border-radius: <%= radius %>px;');
			
			
		} else {
			btn.setAttribute('style', 'border: 0px');
		}
		
		document.getElementById('result').appendChild(btn);
	}
	
	
	</script>

</body>
</html>






