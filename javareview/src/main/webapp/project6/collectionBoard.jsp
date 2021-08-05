<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"
    import = "project6.page.Dao"
    import = "project6.page.Collections"
    import = "project6.page.Board"
%>
<%
	request.setCharacterEncoding("utf-8"); // 요청값에대한 한글 encoding 처리
	String path = request.getContextPath(); // 기준 경로 설정
	//String id = (String)session.getAttribute("idKey");
	String colname = request.getParameter("colname");
	Dao dao = new Dao();
	String colcode = request.getParameter("colcode");
	ArrayList<Board> clist = dao.colBoard(colcode);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/collectionBoard.css"/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div id="top"><div class="back"></div>&nbsp;&nbsp;&nbsp;저장됨</div><br>
		<p><%=colname %></p>
		<div id="tab">
			<%for(Board c: clist){ %>
			<a href="#"><img class="picture" src="img/thumb02.jpg"></a>
			<input type="hidden" class="del" value="<%=c.getBcode()%>">
			<%} %>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="js/collectionBoard.js"></script>
</html>