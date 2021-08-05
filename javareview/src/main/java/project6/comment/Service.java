package project6.comment;

import java.util.ArrayList;

import project6.page.Board;
public class Service {
	Dao dao = new Dao();
	
	// 댓글 리스트 불러오기(게시글 단위)
	public ArrayList<Comment> commentList(String code) {
		ArrayList<Comment> clist = dao.commentList(code);
		for(Comment c:clist) {
			System.out.println("작성자:"+c.getId());
			System.out.println("작성내용:"+c.getContent());
			System.out.println("작성날짜:"+c.getCdate());
			System.out.println("---------------------------------------");
		}
		return clist;
	}
	
	// 게시글 전체 불러오기
	public ArrayList<Board> boardList() {
		ArrayList<Board> blist = dao.boardList();
		int num = 1;
		for(Board b:blist) {
			System.out.println(b.getBcode());
			System.out.println(b.getImg());
			System.out.println("---------------------------------------");
		}
		return blist;
	}
}
