package project6.like;


import java.util.ArrayList;


public class LikeService {
	LikeDao dao = new LikeDao();
	
	// 게시물 리스트
	public ArrayList<Board> boardListall() {
		ArrayList<Board> blist = dao.boardListall();
		int num = 1;
		for(Board b:blist) {
			System.out.print(num++ + " ");
			System.out.println(b.getImg());
			System.out.println("---------------------------------------");
		}
		return blist;
	}
	
	// 게시물 불러오기
	public String setBoard(String bcode) {
		Board brd = dao.setBoard(bcode);
		System.out.println("아이디: "+brd.getID());
		System.out.println("공개범위: "+brd.getPubRange());
		System.out.println("게시글 내용: "+brd.getContents());
		System.out.println(brd.getImg());
		System.out.println(brd.getLoc());
		return "출력완료";
	}
	
	//좋아요 클릭
	public String clicklike(String id,String bcode) {
		dao.clicklike(id, bcode);
		System.out.println("-----------------------------------------------");
		System.out.println("아이디: "+id);
		System.out.println("-----------------------------------------------");
		System.out.println("");
		
		return "출력완료";
	}	
}
