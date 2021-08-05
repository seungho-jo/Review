package project6.comment;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Controller ctl = new Controller();
		Comment c = new Comment();
		

//		System.out.println("로그인");
//		System.out.print("아이디: ");
//		String id = sc.nextLine();
//		System.out.print("비밀번호: ");
//		String pass = sc.nextLine();
//		
//		// 전체 게시글 불러오기
//		ctl.boardList(new Model());
//		System.out.println("댓글을 작성할 게시물 선택");
//		String bcode = sc.nextLine();
//		// 댓글 달기
//		System.out.println("댓글 작성하기");
//		String content = sc.nextLine();
//		ctl.writeComment(new Model(), new Comment(bcode, id, content));

		// 게시글별 댓글 보기
		ctl.boardList(new Model());
		System.out.println("댓글 볼 게시물");
		String code = sc.nextLine();
		ctl.commentList(new Model(), code);
		

	}
}
