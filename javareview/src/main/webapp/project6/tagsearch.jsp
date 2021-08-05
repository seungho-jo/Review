<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;	
}
body{
	color: #444444;
	font-family: "Roboto","Arial","Nanum Gothic","Malgun Gothic","맑은 고딕";
}
#top {
	height: 80px;
	border-bottom: solid 1px #e2e2e2;
}

#search {
	float: right;
	background-image: url("img/search.png");
	margin: -4px 0 0 10px;
	width: 233px;
	height: 54px;
}
#search input {
	margin: 21px 0 0 25px;
	border: 0;
}

li {
	list-style-type : none;
}

section {
	height: auto;
}
nav {
	width : 1320px;
	height : 200px;
	margin : 0 auto;
	padding : 30px 0 0 80px;
}
.hashtag img{
	margin-left : 50px;
	width: 200px;
	height: 200px;
	border-radius: 70%;
	overflow: hidden;
}
.clear{
	clear : both;
}
.a {
	float : left;
	margin-right : 30px;
}
.b {
	padding-top : 35px;
	font-size : 30px;
	font-family: "Nanum Gothic";
}
.c {
	margin-top : 30px;
	font-family: "Nanum Gothic";
}
#content_box {
	width: 1320px;
	height: 1500px; 
	margin: 0 auto;
	padding-top: 30px;
}
h3 {
	float: left;
	margin-left: 590px;
}
#content_box p {
	float: right;
}
.clear{
	clear : both;
}
.items {
	width: 950px;
	float: left;
	margin: 70px 0 0 100px;
}
.items li {
	margin : 10px;
	display : inline-block;
	width : 290px;
	list-style-type : none;
	
}

</style>
</head>
<body>
		<jsp:include page="header.jsp"></jsp:include>
	
	<nav id="main_menu">
		<div class="hashtag">
				<ul class="topimg">
					<li class="a"><img src="img/yellow_tulip.jpg"></li>
					<li class="b">#튤립</li>
					<li class="c">게시물 <span style="font-weight:bold">9</span></li>
					
				</ul>
		</div>
	</nav>
<section id="content_box">
		<div class="box">
			<div class="clear"></div>
			<ul class="items">
				<a href="post2.jsp"><li><img src="img/yellow_tulip.jpg" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립2.JPG" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립3.jpg" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립4.jpg" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립5.jpg" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립6.jpg" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립7.JPG" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립8.JPG" width="100%" height="100%"></li></a>
				<a href=""><li><img src="img/튤립9.JPG" width="100%" height="100%"></li></a>
			</ul>
			
		</div>
		
		<div class="clear"></div>
	</section>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>