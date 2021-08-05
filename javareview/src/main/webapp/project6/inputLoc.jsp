<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 요청값에대한 한글 encoding 처리
	String path = request.getContextPath(); // 기준 경로 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css">
</head>
<body>
	<h2>위치 입력</h2>
	<input id="loc" type="text">
	<input id="btn" type="button" value="추가">
</body>
<script type="text/javascript">
	var loc = document.querySelector("#loc");
	var btn = document.querySelector("#btn");
	var num = 0;
	btn.onclick = function(){
		localStorage.setItem(num, loc.value );
		loc.value="";
		window.close();
	}
	
</script>
</html>