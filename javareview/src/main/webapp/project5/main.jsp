<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	width : 100%;
	height : 100%
}
a {
	text-decoration: none;
	color: black;
}

ul {
	list-style: none;
	padding-left: 0px;
}

header {
	margin: 10px 20px 0 20px;
	height: 50px;
	border-bottom: 3px solid rgba(0, 0, 0, 0.1);
}

header #title {
	line-height: 50px;
	float: left;
	padding-left : 50px;
}

header #title a {
	font-weight: bold;
	font-size: 40px;
}

header #right_side {
	float: right;
	padding-right: 30px;
	height: 50px;
	line-height: 50px;
}

header #right_side span {
	border-left: 1.5px solid rgba(0, 0, 0, 0.1);
	padding: 0 10px;
}

header #right_side a {
	border-left: 1.5px solid rgba(0, 0, 0, 0.1);
	padding: 0 10px;
}
nav {
	clear : both;
	margin: 0 20px;
	width: 10%;
	float : left;
}

nav ul li {
	background-color: rgba(0, 0, 0, 0.1);
	border: 1px solid white;
	border-radius: 10px/10px;
}

nav ul li h3 {
	margin: 0;
	padding: 7px 0 7px 20px;
	cursor : pointer;
}

nav ul li .body {
	display: none;
}

nav ul li .body a {
	display: block;
	padding-left: 30px;
}

nav ul li .body a:hover {
	font-weight: bold;
}

section{
	width: 87%;
	float : left;
	height : auto;
}
section iframe{
	display: block;
	width: 100vw;
	height: 100vh;
	overflow: auto;
}
footer {
	clear : both;
	height : 200px;
	margin-top: 10px;
	border-top: 1px solid rgba(0, 0, 0, 0.1);
}

footer .container {
	width: 1070px;
	height: 160px;
	margin: auto;
	display: flex;
}

footer .container h2 {
	color: rgba(0, 0, 0, 1);
}

footer .container div {
	font-size: 13px;
	padding: 20px 10px;
	width: 247.5px;
}

footer .container div:nth-child(1) {
	font-size: 30px;
}

</style>
<script type="text/javascript">
function resizeTopIframe(dynheight) {  
    document.getElementById("IframeId").style.height = parseInt(dynheight) + 'px';  
}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<header>
		<div id="title">
			<a href="main.jsp">SARUWA</a>
		</div>
		<div id="right_side">
			<span>홍길동님</span><a href="index.html">로그아웃</a>
		</div>
	</header>
	<nav>
		<ul>
			<li>
				<h3>회원관리</h3>
				<div class="body">
					<a href="memberStatistics.html" target="frame">- 통계</a> 
					<a href="memberLookup.html" target="frame">- 회원정보</a> 
					<a href="#">-탈퇴회원정보</a>
				</div>
			</li>
			<li>
				<h3>상품관리</h3>
				<div class="body">
					<a href="productStatistics.html" target="frame">통계</a> 
					<a href="insertProduct.html" target="frame">상품등록</a> 
					<a href="productList.html" target="frame">상품 수정/삭제</a> 
					<a href="#">상품 품절</a>
				</div>
			</li>
			<li>
				<h3>배송관리</h3>
				<div class="body">
					<a href="#">통계</a> <a href="#">리스트</a>
				</div>
			</li>
			<li>
				<h3>결제관리</h3>
				<div class="body">
					<a href="#">통계</a> <a href="#">리스트</a>
				</div>
			</li>
			<li>
				<h3>쿠폰관리</h3>
				<div class="body">
					<a href="#">통계</a> <a href="#">쿠폰생성</a> <a href="#">쿠폰삭제</a>
				</div>
			</li>
			<li>
				<h3>문의 및 답변</h3>
				<div class="body">
					<a href="#">통계</a> <a href="#">리스트</a> <a href="#">답변작성</a>
				</div>
			</li>
		</ul>
	</nav>
	<section>
		<iframe src="main.html" id="IframeId" name="frame" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
	</section>
	<footer>
		<div class="container">
			<div>
				<h2>SARUWA</h2>
			</div>
			<div>
				대표이사 : 홍길동<br> 주소: 서울특별시 강남구 강남역<br> Tel: 1234-5678<br>
				사업자등록번호 : 000-11-22256<br> 통신판매업신고 : 2018-서울중구-1445<br> <br>
				saruwa(주)는 통신판매중개자로서 오픈마켓 saruwa의 거래당사자가 아니며, 입점판매자가 등록한 상품정보 및 거래에 대해
				saruwa(주)는 일체 책임을 지지 않습니다.
			</div>
			<div>
				365고객센터 | 전자금융거래분쟁처리담당<br> 1578-1578<br> 서울특별시 강남구 강남역<br>
				Fax : 02-849-4962 / E-mail : customerservice@saruwa.co.kr
			</div>
			<div>우리은행 채무지급보증 안내 당사는 고객님이 현금 결제한 금액에 대해 우리은행과 채무지급보증 계약을
				체결하여 안전거래를 보장하고 있습니다.</div>
		</div>
	</footer>
</body>
<script type="text/javascript">
	$(function() {
		$("nav ul li h3").click(
				function() {
					$(this).next("div.body").slideToggle(300).siblings(
							"div.body").slideUp("slow");
					$(this).siblings("nav ul li h3");
				});
	});
</script>
</html>