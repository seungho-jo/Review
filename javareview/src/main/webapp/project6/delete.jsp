<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"
    import = "project6.page.*"
%>
<%
	request.setCharacterEncoding("utf-8"); // 요청값에대한 한글 encoding 처리
	String path = request.getContextPath(); // 기준 경로 설정
	String bcode = request.getParameter("bcode");
	String id = (String)session.getAttribute("idKey");
	Dao dao = new Dao();
	dao.deleteBoard(id, bcode);
%>
<script>
	alert("삭제완료");
	location.href="mypage.jsp";
</script>