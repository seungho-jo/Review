package javareview.project4;

public class MemberService {
	MemberDao dao = new MemberDao();
	   
	//회원가입
	public boolean joinmember(Member me) {
	   return dao.joinMember(me);
	}
	   
	//로그인
	public boolean login(String loginmail, String loginpass) {
		if(dao.login(loginmail, loginpass)) {
			System.out.println("로그인 성공");
	        return true;
		}else {
			System.out.println("로그인 실패");
	        return false;
	    }
	}
}
