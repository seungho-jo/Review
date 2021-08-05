package project6.loginPage;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
	Model d = new Model();
	Scanner sc = new Scanner(System.in);
	
	MemberController ctrl = new MemberController();
	Member m = new Member();
	// 사용자 아이디를 입력하시오.
	String id = "";
	String pass = "";
	System.out.print("#ScrollBook 로그인 페이지#");
      System.out.println("[1]로그인 [2]회원가입 ");
      System.out.print("선택: ");
      int num = Integer.parseInt(sc.nextLine());
      switch(num) {
      	case 1 :
      	  System.out.print("아이디 :");
	      id = sc.nextLine();
	      System.out.print("비밀번호는 : ");
	      pass = sc.nextLine();
	      Member m1 = new Member(id,pass);
	      ctrl.login(m1, d);
	      break;
      	case 2 : 
      	 String name = "";
   	     String phone = "";
      	 System.out.print("아이디 : ");
	     id = sc.nextLine();
	     System.out.print("비밀번호 : ");
	     pass = sc.nextLine();
	     System.out.print("이름 : ");
	     name = sc.nextLine();
	     System.out.println("휴대전화 : ");
	     phone = sc.nextLine();
	     Member m2 = new Member(id,pass,phone,name);
	     ctrl.register(m2, d);
	     break ;
      }
	/*
      //회원탈퇴;
      System.out.println("ScrollBook 회원탈퇴");
      System.out.println("아이디 : ");
      id = sc.nextLine();
      System.out.println("비밀번호 : ");
      pass = sc.nextLine();
      Member m3 = new Member(id,pass);
      ctrl.deleteMember(m3, d);
      */
}
}
