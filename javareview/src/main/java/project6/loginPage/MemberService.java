package project6.loginPage;
import java.util.Scanner;

public class MemberService {
	 //로그인
	
	Scanner sc = new Scanner(System.in);
	 MemberDao dao = new MemberDao();
    public boolean login(Member m) {
       if(dao.login(m)) {
          System.out.println("로그인 성공");
          return true;
       }else {
          System.out.println("아이디/비밀번호를 재확인해주세요.");
          return false;
       }
  }

    
    public boolean register(Member m) {
    	boolean memck = true;
    	
    	// 중복아이디 체크
    	while(memck) {
    		if (dao.crtId(m)) {
    			 System.out.println("중복되는 아이디가 있습니다.");
				 System.out.print("아이디: ");
				 m.setEmail(sc.nextLine());
    		}
    	// 중복 전화번호 체크
    		if(dao.crtPhone(m)) {
    			System.out.println("중복되는 전화번호가 있습니다.");
    			System.out.print("전화번호: ");
    			m.setPhone(sc.nextLine());
    		}else {
    			memck = false;
    			System.out.println("회원 정보 중복 체크 완료.");
    		}
    		
    	}
    	return dao.register(m);
    }
    
    public boolean deleteMember(Member m) {
    	System.out.print("아이디를 정말 삭제하십니까?");
    	System.out.print("비밀번호를 재 입력하세요 : ");
    	String pass = sc.nextLine();
    	if(m.getPass().equals(pass)) {
    		return dao.deleteMember(m);
    	}else {
    		System.out.println("비밀번호가 틀렸습니다. 다시 입력하세요.");
    		return false;
    	}
    }
}
