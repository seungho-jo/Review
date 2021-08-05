<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = stylesheet href = "css/login_CSS.css"/>
</head>
<body>
	<form method = "post" action="joinProc.jsp" name = "userInfo" onsubmit="return checkValue()">
		<div id = "divScrollMain">
		<img src = "img/ScrollBook.png" width=250px height = 100px>
			<div class = "IdPass">
				<div class = "id"><input type="text" name = "id" placeholder="이메일 또는 휴대전화를 입력" maxlength="50">
				</div>
				<div class = "pass"><input type="password" name="pass" placeholder = "비밀번호를 입력" maxlength="50">
				</div>
				<div class = "repass"><input type = "password" name = "repass" placeholder = "비밀번호 재입력" maxlength="50">
				</div>
				<div class = "pullname"><input type = "text" name = "name" placeholder = "사용자이름" maxlength="50">
				</div>
				<div><input id = "button" type = "submit" value = "회원가입"></div>
				
				<div class = "loginPart">
				<div> 계정이있다면 <a class = "loginSch" href ="login.jsp"> 로그인 하러가기</div>
			</div>
			</div>
			
		</div>
	</form>
</body>
<script type = "text/javascript" src = "join.js"></script>
</html>