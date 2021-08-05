<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"
    import = "project6.page.*"
%>
<%
	request.setCharacterEncoding("utf-8"); // 요청값에대한 한글 encoding 처리
	String path = request.getContextPath(); // 기준 경로 설정
	String id = (String)session.getAttribute("idKey");
	String pubRange = request.getParameter("pubRange");
	String contents = request.getParameter("contents");
	String img = request.getParameter("profile_pt"); if(img==null) img="";
	String tag = request.getParameter("tag"); if(tag==null) tag="";
	String loc = request.getParameter("loc"); if(loc==null) loc="";
	Service sv = new Service();
	Board b = new Board();
	b.setPubRange(pubRange);
	b.setContents(contents);
	b.setImg(img);
	b.setTag(tag);
	b.setLoc(loc);
	b.setID(id);
	sv.writeBoard(b);
%>
<script>
	alert("등록완료");
	location.href = "mypage.jsp";
</script>