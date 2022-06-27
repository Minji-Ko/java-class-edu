
<!-- [Summary] page 지시자 (오전 8:35:04)-->   
<!-- JSP 컨테이너(아파치 톰캣)에게 해당 페이지의 정보를 알려준다. --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
	1. `language="java"`
        - JSP 페이지에서 사용할 서버 프로그래밍 언어 지정
        
    2. `contentType="text/html; charset=UTF-8"`
        - JSP 페이지 콘텐츠에 대한 기술
        - text/html: MIME 타입 > HTML 문서
        - charset=UTF-8: 인코딩 > 톰캣이 JSP를 읽을 때 사용할 인코딩
        
        - contentType="text/html; charset=ISO-8859-1" > 기본값
        
    3. `pageEncoding="UTF-8"`
        - 브라우저에게 돌려주는 페이지의 인코딩
        - resp.setCharaterEncoding("UTF-8"); 
-->
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>


