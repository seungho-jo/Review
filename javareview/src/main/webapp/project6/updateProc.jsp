<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"
    import = "project6.page.*"
%>
<%
	request.setCharacterEncoding("utf-8"); // 요청값에대한 한글 encoding 처리
	String path = request.getContextPath(); // 기준 경로 설정
	String id = (String)session.getAttribute("idKey");
	String bcode = request.getParameter("bcode");
	String pubRange = request.getParameter("pubRange");
	String contents = request.getParameter("contents");
	String img = request.getParameter("profile_pt");
	String tag = request.getParameter("tag");
	String loc = request.getParameter("loc");
	Service sv = new Service();
	Board bd = new Board();
	bd.setBcode(bcode);
	bd.setPubRange(pubRange);
	bd.setContents(contents);
	bd.setImg(img);
	bd.setTag(tag);
	bd.setLoc(loc);
	bd.setID(id);
	sv.updateBoard(bd);
%>
<script>
	alert("업데이트 완료");
	location.href = "mypage.jsp";
</script>