<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "project6.loginPage.*"
%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pass");
	String url = "login.jsp";
	String msg = "로그인에 실패하였습니다.";
	
	MemberDao dao = new MemberDao();
	System.out.println(id);
	System.out.println(pwd);
	
	if( id !=null){
		Member m = dao.getMember(id,pwd);
		if(id.equals(m.getEmail())&&pwd.equals(m.getPass())){
		session.setAttribute("idKey",id);
		msg = "로그인에 성공하였습니다.";
		url = "main.jsp";
	}
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
