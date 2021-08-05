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
#comments {
    font-size: 15px;
    margin: 10px;
    padding-left: 30px;
    padding-bottom: 15px;
    padding-right: 23px;
    line-height: 29px;
}
.com_id {
    font-size: 14px;
    font-weight: bold;
    margin-left: 30px;
}
.com_date {
	color: darkgray;
	font-size: 12px;
	float: right;
	font-weight: normal;
}

.like, .bookmark, .share, [name=submit], #comment_profile, .writer_img img, .writer_id {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	function resize(obj) {
		obj.style.height = "1px";
		obj.style.height = (12 + obj.scrollHeight) + "px";
	}
</script>
</head>
<body>
	<div class="main-wrap">
		<section>
			<%
			String[] ids = {"bangbang23", "jeoung_doo1", "J0_seunghoo", "0o_jin", "hihimanan", "ppaoppao", "catangel", "dogdogdog",
					"not_y0Lo"};
			String[] time = {"02:23", "23:47", "18:29", "00:23", "08:24", "10:01", "14:10", "17:58", "19:18"};
			String[] img = {"cat.jpeg", "catcat.jpeg", "bambi.jpg", "summer.jpg", "yellow_tulip.jpg", "튤립4.jpg", "summer.png",
					"튤립8.JPG", "튤립6.jpg"};
			String[] like = {"2521", "23", "5", "11", "1309", "34", "992", "3", "1"};
			int none = 0;
			for (int cnt = 0; cnt < 9; cnt++) {
			%>
			<div class="post_info">
				<div class="writer_img" onclick="move()">
					<img src="img/<%=img[cnt] %>">
					<div class="writer_id">
						<span><%=ids[cnt]%></span>
					</div>
				</div>
				<div class="write_date">
					<span>2021.7.19&nbsp<%=time[cnt]%></span>
				</div>
			</div>
			<div class="post_content">
				<img ondblclick="dblclick()" src="img/<%=img[cnt]%>">
				<div class="post_under_img">
					<div class="post_icons">
						<div class="like" onclick="changeColor()">
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
						<span>좋아요&nbsp<%=like[cnt]%>개
						</span>
					</div>
					<div class="post_under_icon">
						<div class="post_writer">
							<span>bangbang23</span>
						</div>
						<div class="post_text">
							<span>#게시글 내용</span>
						</div>
					</div>
				</div>

				<div id="comments">
					<span class="com_<%=none%>"></span>
				</div>
				<div class="post_comment">
					<a href="mypage.jsp" id="comment_profile"><img
						src="img/bambi.jpg"></a>
					<div class="comment_content">
						<textarea class="new_comment_<%=none %>" name="new_comment" id="text" placeholder="댓글 달기.."
							onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
						<button type="button" name="submit" onclick="warnEmpty(<%=none%>)">게시</button>
					</div>
				</div>
			</div>
			<%
			none++;
			}
			%>
		</section>
	</div>
</body>
<script type="text/javascript">
	function move(){
		location.href="mypage2.jsp?id=bangbang23"
	}
	function warnEmpty(idx) {
		console.log(idx);
		var content = document.querySelector(".new_comment_"+idx).value;
		if(document.getElementById("text").value==''){
			alert("댓글을 입력해주세요");
		}else{
		var com = document.querySelector(".com_"+idx);
		com.innerHTML += "<br><span class='com_id'>jsh95320</span>&nbsp&nbsp&nbsp&nbsp"+content+"<span class='com_date'>2021.7.30&nbsp14:20</span";
		document.getElementById("text").value='';
		}
	}
	var chImg = true;
	function changeColor() {
		var like = document.querySelector(".like");
		var cnt = document.querySelector(".post_likes");
		var full = '<i class="fas fa-heart fa-lg"></i>';
		var nfull = '<i class="far fa-heart fa-lg"></i>';
		var cnt1 = '<span>좋아요&nbsp2522개</span>';
		var cnt0 = '<span>좋아요&nbsp2521개</span>';
		if (chImg) {
			like.innerHTML = full;
			cnt.innerHTML = cnt1;
		} else {
			like.innerHTML = nfull;
			cnt.innerHTML = cnt0;
		}

		chImg = !chImg;
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
	function dblclick() {
		changeColor();
	}
	function showPopup() {
		if (!confirm("해당 게시물을 SNS로 공유하시겠습니까? 취소를 누르면 URL이 복사됩니다.")) {
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
		window.open("popup.jsp", "팝업테스트",
				"width=260, height=160, top=10, left=10");
	}
</script>
</html>