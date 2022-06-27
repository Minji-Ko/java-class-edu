<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<% 
	//JDBC > select > 결과셋 > 화면출력
	ArrayList<String> list = new ArrayList<String>();
	
	list.add("홍길동");
	list.add("아무개");
	list.add("하하하");
	list.add("호호호");
	list.add("후후후");
	
	ArrayList<String> color = new ArrayList<String>();
	
	color.add("tomato");
	color.add("gold");
	color.add("cornflowerblue");
	color.add("yellowgreen");
	color.add("magenta");
%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    .item {
        border: 1px solid #aaa;
        border-radius: 5px;
        padding: 15px;
        width: 450px;
        margin-bottom: 5px
    }
    
</style>
</head>
<body>
	
	<h1>Member</h1>
	
	<% for(int i=0; i<list.size(); i++) { %>
	<div class="item" style="background-color: <%= color.get(i) %>">
	    <h2><%= list.get(i) %></h2>
	    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio nesciunt dolores excepturi possimus fuga libero consectetur fugit, nisi dolorem? Dolor rerum esse eum alias, officiis reiciendis labore, molestias pariatur asperiores eaque deserunt! Iusto, quas autem quo recusandae ab est! Deleniti adipisci aliquid rerum officiis laboriosam incidunt.</p>
	    <input type="button" value="자세히보기" class="btn" onclick="info('<%= list.get(i) %>');">
	</div>
	<% } %>
	
	<script>
		function info(name){
			alert('회원: ' + name);
			//alert(`회원`);
		}
	</script>

</body>
</html>