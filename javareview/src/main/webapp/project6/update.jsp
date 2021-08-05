<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "project6.page.Dao"
	import = "project6.page.Board"    
	import = "java.util.*"
%>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("idKey");
	String bcode = request.getParameter("bcode");
	Dao dao = new Dao();
	Board blist = dao.setBoard(bcode, id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/update.css"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<form id="frm" action="updateProc.jsp">
			<h2>게시물 만들기</h2>
			<input id="btn" type="button" value="게시">
			<div id="clear"></div>
			<select name="pubRange">
				<option>선택하세요</option>
				<option value="모두 공개">모두 공개</option>
				<option value="친구만">친구만</option>
				<option value="비공개">비공개</option>
			</select>
			<hr>
			<textarea name="contents"><%=blist.getContents() %></textarea>
			<div id='View_area'></div>
			<hr>
			<label id="upload">업로드</label>
			<input type="file" name="profile_pt" id="profile_pt" onchange="previewImage(this,'View_area')">
			<hr>
			<label id="tag">친구 태그</label>
			<input type="button" value="clear" onclick="clears()">
			<input type="button" value="check" onclick="checkWin1()">
			<p class="value1"><%=blist.getTag() %></p>
			<input name="tag" type="hidden" value=<%=blist.getTag() %>>
			<hr>
			<label id="loc">위치</label>
			<input type="button" value="check" onclick="checkWin2()">
			<p id="value2"><%=blist.getLoc() %></p>
			<input name="loc" type="hidden" value="<%=blist.getLoc()%>">
			<input type="hidden" name="bcode" value="<%=bcode %>">
		</form>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	var sel = document.querySelectorAll("select option");
	if("<%=blist.getPubRange()%>" == sel[1].value){
		sel[1].selected = true;
	}else if("<%=blist.getPubRange()%>" == sel[2].value){
		sel[2].selected = true;
	}else if("<%=blist.getPubRange()%>" == sel[3].value){
		sel[3].selected = true;
	}
</script>
<script type="text/javascript" src="js/update.js"></script>
</html>