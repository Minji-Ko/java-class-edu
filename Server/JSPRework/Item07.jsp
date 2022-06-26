<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- [Summary] HTML영역에서 Java 사용하기(선언부) (오전 9:14:56)-->

<!-- 3. 선언부 : 클래스 영역, 선언부에서 선언된 메소드의 최대 영역은 해당 JSP 페이지 -->
<%!

	public int b = 20; //클래스 멤버 변수
	
	public int sum(int a, int b) {
		return a + b;
	} 
	
%> <!-- 잘 사용하지 않음 >> 대신, 일반 자바 클래스를 만들어서 page 지시자로 참조 -->

</body>
</html>