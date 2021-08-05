package project6.comment;

import java.util.ArrayList;

import project6.page.Board;

public class Controller {
	Dao dao = new Dao();
	Service sv = new Service();
	ArrayList<Board> blist = null;
	// 댓글 작성
	public String writeComment(Model d,Comment c) {
		d.addAttribute("댓글 작성", dao.writeComment(c));
		return "post.jsp";
	}
	// 작성된 댓글 보기(게시글 단위)
	public String commentList(Model d,String code) {
		d.addAttribute("댓글 보기", sv.commentList(code));
		return "post.jsp";
	}
	// 게시글 리스트
	public String boardList(Model d) {
		d.addAttribute("게시글 리스트", blist=  sv.boardList());
		return "mypage.jsp";
	}
}
