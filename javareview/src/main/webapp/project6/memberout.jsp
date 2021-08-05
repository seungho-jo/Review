<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Better late than Never</title>
<link rel ="stylesheet" href = "css/memberInfo.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
</head>
<body>
	<jsp:include page = "header.jsp"></jsp:include>
	<div id = "body">
	<section>
		<form action = "memberoutProc.jsp" name= "retouchprofile" onsubmit="return checkprof();">
					<div class = "list">
						<table>
						<tr><th>아이디</th>
							<td><input type = "text" name = "id" value= "" placeholder="아이디를 입력하세요."></td>
						</tr>
						<tr><th>비밀번호</th>
							<td><input type = "password" name = "pass" value= "" placeholder="비밀번호를 입력하세요."></td>
						</tr>
						<tr><th></th>
							<td><input type = "password" name = "newpass" value= "" placeholder="비밀번호를 한번 더 입력하세요."></td>
						</tr>
						</table>
						<div><input id = "button" type = "submit" value = "회원탈퇴"></div>
					</div>
		</form>
	</section>
	<nav>
		<div>
			<ul>
				<li id = "memberprofile">프로필 편집</li>
				<li>공개 범위 및 보안</li>
				<li>보안 설정</li>
				<li id = "memberout">회원 탈퇴</li>
			</ul>
		</div>
	</nav>
	
	
	
	<div style="clear:both;"></div>	 <%-- footer가 밑에 붙어버림. --%>
	
	</div>
	<jsp:include page = "footer.jsp"></jsp:include>
</body>
<script type = "text/javascript" src = "js/memberout.js"></script>
</html>