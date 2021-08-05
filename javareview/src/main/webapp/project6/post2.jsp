<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css"/>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="css/main.css">
<style>
.post_comment {
	margin-top:20px;
    display: flex;
    align-items: center;
}
[name=new_comment] {
    width: 450px;
    height: 20px;
    margin-left: 20px;
    font-size: 13px;
    outline: none;
    padding: 0;
    float: left;
    border: 0;
    resize: none;
    line-height: 18px;
    text-align: start;
    cursor: text;
    font: 400 13.3333px Arial;
}

[name=new_comment]:focus {
	text-align: left;
	outline: none;
	font-size: 13px;
	caret-color: #22FF7B;
}

[name=submit] {
	padding: 0 20px 0 20px;
	border:none;
	color: #22FF7B;
	background-color: transparent;
	font-weight: bold;
	font-size: 17px;
	float: right;
}

[name=submit]:hover {
	color: white;
	background-color: #22FF7B;
	border: 1.5px solid #22FF7B;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
		<jsp:include page="header.jsp"></jsp:include>
	<div class="main-wrap">
		<section>
			<div class="post_info">
				<div class="writer_img">
					<img src="img/summer.png">
					<div class="writer_id">
						<span>bangbang23</span>
					</div>
				</div>
				<div class="write_date">
					<span>2021.7.19&nbsp23:47</span>
				</div>
			</div>
			<div class="post_content">
				<img ondblclick="dblclick()" src="img/yellow_tulip.jpg">
				<div class="post_under_img">
					<div class="post_icons">
						<div class="like"  onclick="changeColor()">
							<i class="far fa-heart fa-lg"></i>
						</div>
						<div class="bookmark" onclick="fill()">
							<i class="far fa-bookmark fa-lg"></i>
						</div>
						<div class="share" onclick="showPopup()">
						<i class="fas fa-share-alt fa-lg"></i>
						</div>
					</div>
					<div class="post_likes">
						<span>좋아요&nbsp0개</span>
					</div>
					<div class="post_under_icon">
						<div class="post_writer">
							<span>bangbang23</span>
						</div>
						<div class="post_text">
							<span>#튤립 사왔다</span>
						</div>
					</div>
				</div>
				<div class="post_comment">
					<a href="mypage.jsp" id="comment_profile"><img
						src="img/bambi.jpg"></a>
					<div class="comment_content">
					<form id="frm01">
						<textarea name="new_comment" placeholder="댓글 달기.."
							onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
						<button type="submit" name="submit" onclick="warnEmpty()">게시</button>
					</form>
					</div>
				</div>
		</section>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	
</body>
<script type="text/javascript">
	var chImg = true;
	function changeColor(){
		var like = document.querySelector(".like");
		var cnt = document.querySelector(".post_likes");
		var full = '<i class="fas fa-heart fa-lg"></i>';
		var nfull = '<i class="far fa-heart fa-lg"></i>';
		var cnt1 = '<span>좋아요&nbsp1개</span>';
		var cnt0 = '<span>좋아요&nbsp0개</span>';
		if(chImg){
			like.innerHTML=full;
			cnt.innerHTML=cnt1;
		}else{
			like.innerHTML=nfull;
			cnt.innerHTML=cnt0;
		}
		
		chImg=!chImg;
		console.log(chImg);
	}
	var chFill = true;
	function fill() {
		var bookmark = document.querySelector(".bookmark");
		var full = '<i class="fas fa-bookmark fa-lg"></i>';
		var nfull = '<i class="far fa-bookmark fa-lg"></i>';
		if (chFill) {
			bookmark.innerHTML = full;
		} else {
			bookmark.innerHTML = nfull;
		}

		chFill = !chFill;
	}
	function dblclick(){
		changeColor();
	}
	function showPopup() {
		if(!confirm("해당 게시물을 SNS로 공유하시겠습니까? 취소를 누르면 URL이 복사됩니다.")){
			var url = '';
			var textarea = document.createElement("textarea");
			document.body.appendChild(textarea);
			url = window.document.location.href;
			textarea.value = window.location.href;
			textarea.select();
			document.execCommand("copy");
			document.body.removeChild(textarea);
			alert("URL이 복사되었습니다.")
			return false;
		} 
		window.open("popup.jsp","팝업테스트","width=260, height=160, top=10, left=10");
	}

	
</script>
</html>