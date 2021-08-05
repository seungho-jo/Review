<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import = "project6.page.Board"
	import = "project6.page.Dao"
	import = "project6.page.Collections"
	import = "java.util.*"
%>
<%
	String id = request.getParameter("id");
	Dao dao = new Dao();
	ArrayList<Board> list = dao.boardList(id);
	ArrayList<Collections> clist = dao.colList(id);
	ArrayList<Board> taglist = dao.tagBoard("@조승호");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mypage.css"/>
<style>
button {
    color: #22FF7B;
    background: none;
    border: 1px solid #22FF7B;
    padding: 4px 10px;
}
button:hover{
	cursor: pointer;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".content").hide(); //Hide all content
	$("ul li:first").addClass("active").show(); //Activate first tab
	$(".content:first").show(); //Show first tab content

	//On Click Event
	$("ul li").click(function() {
		$("ul li").removeClass("active"); //Remove any "active" class
   	 	$(this).addClass("active"); //Add "active" class to selected tab
    	$(".content").hide(); //Hide all tab content

    	var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
    	$(activeTab).fadeIn(); //Fade in the active ID content
    	return false;
	});

});

</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="body">
		<section>
			<div id="shotBoard">

			</div>
			<div id="board">
				<div id="list">
					<ul>
						<li><a href="#tab1"><img src="img/게시물.PNG"></a></li>
						<li><a href="#tab3"><img src="img/태그됨.PNG"></a></li>
					</ul>
				</div>
				<div id="tab1" class="content">
					<% 
						for(Board b:list){
					%>
					<div>
						<div class="morediv">
							<div class="more"></div>
						</div>
						<div class="up_del">
							<a href="update.jsp?bcode=<%=b.getBcode()%>">수정</a><br><span>삭제</span>
						</div>
						<a href="#"><img class="picture" src="img/<%=b.getImg()%>"></a>
						<input type="hidden" value="<%=b.getBcode()%>">
					</div>
					<%}%>
				</div>
				
				<div id="tab3" class="content">
					<% 
						for(Board tb:taglist){
					%>
					<div>
						<a href="#"><img class="picture" src="img/thumb02.jpg"></a>
						<input type="hidden" class="del" value="<%=tb.getBcode()%>">
					</div>
					<%}%>
				</div>
			</div>
		</section>
		<nav>
			<div>
				<table>
					<tr>
						<td colspan="2"><h4>bangbang23</h4> &nbsp;&nbsp;<button name="follow" onclick="follow()">팔로우</button></td>
					</tr>
					<tr>
						<td>FOLLOWER</td>
						<td>FOLLOWING</td>
					</tr>
					<tr>
						<td id="follower">320</td>
						<td id="follwing">285</td>
					</tr>
				</table>
				<div class="box">
    				<img class="profile" src="img/cat.jpeg">
				</div>
			</div>
			<hr>
			<p>현직 웹 개발자 밤에 잠 좀 자고 싶습니다!!</p>
		</nav>
		<div style="clear:both;"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
var isFollow = true;
function follow(){
	var button = document.querySelector("[name=follow]");
	var follower = document.querySelector("#follower");
	if(isFollow){
		button.innerText = "팔로잉";
		button.style.background = "#22FF7B";
		button.style.color = "white";
		follower.innerText = "321";
	}else{
		button.innerText = "팔로우";
		button.style.background = "none";
		button.style.color = "#22FF7B";
		follower.innerText = "320";
	}
	isFollow = !isFollow;
}
var span = document.querySelector("span");
span.onclick = function(){
	var code = document.querySelector(".del").value;
	var rel = confirm("삭제하시겠습니까?");
	if(rel){
		location.href="delete.jsp?bcode="+code;
	}
}
function mv(num){
	var frm = document.querySelectorAll("#frm");
	frm[num].submit();
}
</script>
<script type="text/javascript" src="js/mypage.js"></script>
</html>