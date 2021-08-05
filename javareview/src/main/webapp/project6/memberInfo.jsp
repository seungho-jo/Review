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
			<div class = "profileMain">
				<div class = "changeUseProfile">
					<div class = "box"> 
						<img class = "userImage" src="img/bambi.jpg"/>
					</div>
					<div class = "profile">
						<a href = ""><span> 프로필 사진 바꾸기</span></a>
					</div>
				</div>
				<form action = "#" name= "retouchprofile" >
					<div class = "list">
						<table>
							<tr><th>이메일</th>
							<td><input type = "text" name = "email" value= "" placeholder="이메일을 입력하세요."></td>
						</tr>
						<tr><th>이름</th>
							<td><input type = "text" name = "name" value= "" placeholder="이름을 입력하세요."></td>
						</tr>
						<tr><th>비밀번호</th>
							<td><input type = "password" name = "password" value= "" placeholder="이전 비밀번호를 입력하세요."></td>
						</tr>
						<tr><th></th>
							<td><input type = "password" name = "newPassword" value= "" placeholder="새 비밀번호를 입력하세요."></td>
						</tr>
						<tr><th></th>
							<td><input type = "password" name = "reNewPassword" value= "" placeholder="새 비밀번호를 재 입력하세요."></td>
						</tr>
						<tr><th>전화번호</th>
							<td><input type = "text" name = "email" value= "" placeholder="전화번호를 입력하세요."></td>
						</tr>
						<tr><th>성별</th>
							<td><input type = "text" name = "email" value= "" placeholder="성별을 입력하세요."></td>
						</tr>
					</table>
					<div><input id = "button" type = "submit" value = "제출"></div>
					</div>
			</form>
		</div>
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
<script type = "text/javascript" src = "js/memberInfo.js"></script>
</html>