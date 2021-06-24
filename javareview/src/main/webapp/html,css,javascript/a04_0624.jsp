<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
form태그를 이용하여 데이터 전송시 서버에 전송하여
페이지명?email=email값&pass=pass값 이런 형식의 url이 완성되고 해당 정보를 넘겨받는다
-->
<h2>넘겨받은 내용</h2>
이메일: <%=email %><br>
비밀번호: ${param.pass }
</body>
</html>