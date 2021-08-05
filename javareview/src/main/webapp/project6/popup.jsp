<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/popup.css"/>
</head>
<body>

	<div class="popup">
			<h4>SNS로 공유하기</h4>
		<ul class="shareicon">
			<li class="b"><img onclick="Sharefb()" src="img/icon-facebook.png"></li>
			<li class="c"><img onclick="Sharekk()" src="img/icon-kakao.png"></li>
			<li class="d"><img onclick="Sharett()" src="img/icon-twitter.png"></li>
		</ul>
	</div>
</body>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="js/popup.js"></script>

</html>