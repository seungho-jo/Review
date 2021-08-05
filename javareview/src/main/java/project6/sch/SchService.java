package project6.sch;

import java.util.ArrayList;

public class SchService {
	
	SchDao dao = new SchDao();
	
	//아이디검색
	public String schmem(String name) {
		ArrayList<Member> list = dao.schmem(name);
		for(Member sl: list) {
			System.out.println("-----------------------------------------------");
			System.out.println("검색결과: "+ sl.getName());
			System.out.println("-----------------------------------------------");
			System.out.println("");
		}
		return "출력완료";
	}
	
	//태그검색
	public String schtag(String contents) {
		ArrayList<Board> list = dao.schtag(contents);
		for(Board sl: list) {
			System.out.println("-----------------------------------------------");
			System.out.println("검색결과: "+ sl.getImg());
			System.out.println("-----------------------------------------------");
			System.out.println("");
		}
		return "출력완료";
	}
}
