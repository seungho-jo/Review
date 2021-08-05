<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 	import = "project6.loginPage.*"
%>
<%
	request.setCharacterEncoding("utf-8");	//요청값에 대한 한글 encoding처리.
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String repass = request.getParameter("repass");
	String pullname = request.getParameter("name");
	MemberDao dao = new MemberDao();
	System.out.println(id);
	System.out.println(pass);
	System.out.println(repass);
	System.out.println(pullname);
	
	boolean inInsert = false;
	if(id!=null){
		inInsert = dao.register(new Member(id,pass,repass,pullname));
	}
	
%>

<script>
		var inInsert= <%=inInsert%>;
		if(inInsert){
			if(confirm("회원가입 성공했습니다. \n 로그인화면으로 이동하겠습니다.")){
			location.href = "login.jsp";
			}
		}else{
			if(confirm("회원가입 실패했습니다.")){
			location.href = "Join.jsp";
		}
		}
	</script>