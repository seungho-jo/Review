package project6.follow;

import java.util.ArrayList;

import project6.page.Board;

public class Controller {
	Dao dao = new Dao();
	Service sv = new Service();
	ArrayList<Board> blist = null;
	// 팔로우 진행
	public String follow(Model d,Follow f) {
		d.addAttribute("팔로우 진행", dao.follow(f));
		return "mypage.jsp";
	}
	// 팔로워 리스트
	public String followerList(Model d,String id) {
		d.addAttribute("팔로워 보기", sv.followerList(id));
		return "mypage.jsp";
	}
	// 팔로잉 리스트
	public String followingList(Model d, String id) {
		d.addAttribute("팔로잉 보기", sv.followingList(id));
		return "mypage.jsp";
	}
}
