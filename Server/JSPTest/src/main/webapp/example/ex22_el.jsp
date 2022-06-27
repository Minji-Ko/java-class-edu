<%@page import="com.test.jsp.Student"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 


%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<div class="container">
	
		<h1>EL</h1>
	
		<%
			//자바 데이터
			int a = 10;
			
			//pageContext.setAttribute("a", 10); 
		
			
			
			//내장 객체 데이터
			pageContext.setAttribute("b", 20);
			
			request.setAttribute("c", 30);
			
			session.setAttribute("d", 40);
			
		%>
		
		<h2>표현식</h2>
		<div>a: <%= a %></div>
		<div>b: <%= pageContext.getAttribute("b") %></div>
		
		<h2>EL</h2>
		<div>a: ${a}</div>
   <%-- <div>b: ${pageContext.getAttribute("b")}</div> --%>
		<div>b: ${b}</div>
		<div>c: ${c}</div>
		<div>d: ${d}</div>
		
		<hr>
		
		<h2>EL 기능들</h2>
		
		<h3>EL 연산</h3>
		
		<div>a + 10 = <%= a + 10 %></div>
		<div>b + 10 = <%= (int)pageContext.getAttribute("b") + 10 %></div>
		<div>b + 10 = ${b} + 10</div>
		
		<div>b + 10 = ${b + 10}</div>
		<div>b - 10 = ${b - 10}</div>
		<div>b * 10 = ${b * 10}</div>
		<div>b / 10 = ${b / 10}</div>
		<div>b % 10 = ${b % 10}</div>
		<div>b mod 10 = ${b mod 10}</div>
		
		<hr>
		
		<div>b &gt; 10 = ${d > 10}</div>
		<div>b &lt; 10 = ${d < 10}</div>

		<div>b &gt; 10 = ${d gt 10}</div>
		<div>b &lt; 10 = ${d lt 10}</div>
		
		<div>b == 10 = ${b == 10}</div>
		<div>b != 10 = ${b != 10}</div>
		
		<hr>
		
		<div>${true && false}</div>
		<div>${true || false}</div>
		<div>${!true}</div>

		<hr>		
		
		<div> ${b > 0 ? "양수" : "음수" }</div>
		
		<hr>
		
		<%-- <div>${"홍길동".equals("홍길동")}</div> --%>
		<div>${"홍길동" == "홍길동"}</div>
		
		<% 
			HashMap<String, String> map = new HashMap<String, String>();
		
			map.put("name", "홍길동");
			map.put("age", "20");
			map.put("job", "학생");
			
			pageContext.setAttribute("map", map);
		%>
		
		<h2>HashMap 출력 지원</h2>
		
		<div>이름: <%= map.get("name") %></div>
		<div>나이: <%= Integer.parseInt(map.get("age")) - 1 %></div>
		<div>직업: <%= map.get("job") %></div>
		
		<div>이름: ${map.get("name")}</div>
		<div>나이: ${map["age"]}</div>
		<div>직업: ${map.job}</div>
	
		<div>나이: ${map.age -1}</div>
		
		<%
			Student s = new Student();
			
			s.setName("홍길동");
			s.setKor(100);
			s.setEng(90);
			s.setMath(80);
			
			request.setAttribute("s", s);
		%>
		
		<h2>자바 객체 출력 지원</h2>
		<div>이름: <%= s.getName() %></div>
		<div>총점: <%= s.getKor() + s.getEng() + s.getMath() %></div>
		
		<div>이름: ${s.getName()}</div>
		<div>이름: ${s["name"]}</div>
		<div>이름: ${s.name}</div> <!-- getName() -->
		
		<%-- <div>성별: ${s.gender}</div> --%>
		<div>${s.nick}</div>
		
		<div>총점: ${s.kor + s.eng + s.math}</div>
		
		<hr>
		
		<% 
			Student s2 = null;
		
			pageContext.setAttribute("s2", s2);
		%>
		
		<div><%= s2 == null %></div>
		<div>${s2 == null}</div>
		<div>${empty s2}</div> <!-- 권장 -->
		
		<%-- <div><%= s3 == null %></div> --%>
		<div>${s3 == null}</div> <!-- s3는 key > 없는 키를 불러도 null반환 -->
		<div>${empty s3}</div>
		
		<hr>
		
		<% 
			pageContext.setAttribute("color", "red");
			request.setAttribute("color", "gold");
			session.setAttribute("color", "cornflowerblue");
			application.setAttribute("color", "yellowgreen");
		%>
		
		<h2>내장 객체의 우선 순위</h2>
		<div style="background-color:<%= pageContext.getAttribute("color") %>">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo totam consequatur perferendis sed esse possimus molestiae non error illum officiis quia modi cumque delectus dolores enim aut numquam atque doloribus?</div> 
		<div style="background-color:${color}">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo totam consequatur perferendis sed esse possimus molestiae non error illum officiis quia modi cumque delectus dolores enim aut numquam atque doloribus?</div>
		<div style="background-color:${sessionScope.color}">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo totam consequatur perferendis sed esse possimus molestiae non error illum officiis quia modi cumque delectus dolores enim aut numquam atque doloribus?</div>
		
	</div>
	
	<script>
	
	</script>
	
</body>
</html>