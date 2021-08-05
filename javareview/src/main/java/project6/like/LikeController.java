package project6.like;


import java.util.ArrayList;


	public class LikeController {

	LikeService service = new LikeService();
	ArrayList<Board> blist = null;
	String bcode = null;
	
	// 게시물리스트
	public String boardListall(Model d) {
		d.addAttribute("게시글 리스트",blist=  service.boardListall());
		return "mypage.jsp";
	}
	
	// 선택 게시물 보기
	public String setBoard(Model d,int choice) {
		d.addAttribute("게시글 선택", service.setBoard(bcode = blist.get(choice-1).getBcode()));
		return "mypage.jsp";
	}
	
	//좋아요 클릭
	public String like(Model d,String id) {
		System.out.println("# 좋아요 #");
		d.addAttribute("좋아요 출력", service.clicklike(id,bcode));
		return "호출될 화면";
	}
}
