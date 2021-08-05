package project6.page;

import java.util.ArrayList;

public class Controller {
	Service sv = new Service();
	ArrayList<Board> blist = null;
	ArrayList<Collections> clist = null;
	String bcode = null;
	// 게시물 작성
	public String writeBoard(Model d,Board b) {
		d.addAttribute("게시글 작성", sv.writeBoard(b));
		return "mypage.jsp";
	}
	// 게시물 수정
	public String updateBoard(Model d, Board b) {
		b.setBcode(bcode);
		d.addAttribute("게시글 수정", sv.updateBoard(b));
		return "mypage.jsp";
	}
	// 게시물 리스트
	public String boardList(Model d,String email) {
		d.addAttribute("게시글 리스트",blist=  sv.boardList(email));
		return "mypage.jsp";
	}
	// 게시물 삭제
	public String deleteBoard(Model d,String id,String bcode) {
		d.addAttribute("게시글 삭제", sv.deleteBoard(id, bcode));
		return "mypage.jsp";
	}
	// 선택 게시물 보기
	public String setBoard(Model d,int choice,String id) {
		d.addAttribute("게시글 수정", sv.setBoard(bcode = blist.get(choice-1).getBcode(), id));
		return "mypage.jsp";
	}
	// 태그된 게시물 리스트
	public String tagBoard(Model d,String tag) {
		d.addAttribute("태그된 게시물 리스트", sv.tagBoard(tag));
		return "mypage.jsp";
	}
	// 컬랙션 생성
	public String createCollection(Model d,String id,String colname) {
		d.addAttribute("컬랙션 생성", sv.createCollection(id, colname));
		return "mypage.jsp";
	}
	// 나의 컬랙션 리스트
	public String colList(Model d,String id) {
		d.addAttribute("컬랙션 리스트", clist = sv.colList(id));
		return "mypage.jsp";
	}
	// 컬랙션 내용
	public String colBoard(Model d,int num) {
		d.addAttribute("컬랙션 내용", sv.colBoard(clist.get(num-1).getColcode()));
		return "mypage.jsp";
	}
	// 게시물 저장
	public String saveBoard(Model d,int num) {
		d.addAttribute("게시물 저장", sv.saveBoard(clist.get(num-1).getColcode(), bcode));
		return "mypage.jsp";
	}
}
