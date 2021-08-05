<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 request.setCharacterEncoding("utf-8");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = stylesheet href = "css/login_CSS.css"/>
</head>
<body>
	<section>
		<form action="loginProc.jsp" name = "loginInfo" onsubmit = "return checkValue()"> 
		<div id = "divScrollMain">
		<img src = "img/ScrollBook.png" width=250px height = 100px>
			<div class = "IdPass">
				<div class = "id"><input type="text" name = "id" placeholder="이메일 또는 휴대전화를 입력" maxlength="50">
				</div>
				<div class = "pass"><input type="password" name="pass" placeholder = "비밀번호를 입력" maxlength="50">
				</div>
			<div><input id="button" type="submit" value="로그인"></div>
			</div>
			<div class = "SchPart">
			<a class = "idSch" href ="idSch.jsp" >아이디찾기</a> 
			<a class = "pwSch" href ="pwSch.jsp">비밀번호찾기</a>
			</div>
			
			<div class = "OR">
				<div class = "orLineor">또는</div>
			</div>
			
			<div class = "joinPart">
				<div> 계정이없으면 <a class="joinSch" href ="Join.jsp"> 회원가입하러가기</div>
			</div>
			</div> 
		</form>
		</section>
<%
	String id[] = {"himan"};
	String pass[] = {"7777"};
%>
</body>
<script type="text/javascript" src = "js/login.js"></script>
</html>