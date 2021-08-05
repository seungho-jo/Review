package project6.loginPage;

public class MemberController {

	
	MemberService service = new MemberService();
	 public String login(Member m,Model d) {
	       
	      d.addAttribute("로그인결과", service.login(m));
	      return m.getEmail();
	   }
	
	 public String register(Member m, Model d) {
		 d.addAttribute("회원가입진행", service.register(m));
		 return "호출될 화면";
	 }
	 
	 public String deleteMember(Member m, Model d) {
		 d.addAttribute("회원탈퇴진행", service.deleteMember(m));
		 return "호출될 화면";
	 }
}
