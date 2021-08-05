package project6.page;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Service {
	Dao dao = new Dao();

	// 게시물 작성
	public String writeBoard(Board b) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat smd = new SimpleDateFormat("YYMMdd");
		String wdate = smd.format(cal.getTime());
		String[] ids = b.getID().split("@");
		b.setBcode(ids[0] + wdate);
		dao.writeBoard(b);
		return "작성완료";
	}

	// 게시물 수정
	public String updateBoard(Board b) {
		dao.updateBoard(b);
		return "작성완료";
	}

	// 게시물 리스트
	public ArrayList<Board> boardList(String ID) {
		ArrayList<Board> blist = dao.boardList(ID);
		int num = 1;
		for (Board b : blist) {
			System.out.print(num++ + " ");
			System.out.println(b.getImg());
			System.out.println("---------------------------------------");
		}
		return blist;
	}

	// 게시물 삭제
	public String deleteBoard(String id, String bcode) {
		dao.deleteBoard(id, bcode);
		return "출력완료";
	}

	// 게시물 불러오기
	public String setBoard(String bcode, String id) {
		Board brd = dao.setBoard(bcode, id);
		System.out.println(brd.getPubRange());
		System.out.println(brd.getContents());
		System.out.println(brd.getImg());
		System.out.println(brd.getTag());
		System.out.println(brd.getLoc());
		return "출력완료";
	}

	// 태그된 게시물 리스트
	public String tagBoard(String tag) {
		ArrayList<Board> blist = dao.tagBoard(tag);
		int num = 1;
		for (Board b : blist) {
			System.out.print(num++ + " ");
			System.out.println(b.getImg());
			System.out.println("---------------------------------------");
		}
		return "출력완료";
	}

	// 컬랙션 생성
	public String createCollection(String id, String colname) {
		dao.createCollection(id, colname);
		return "생성완료";
	}

	// 나의 컬랙션 리스트
	public ArrayList<Collections> colList(String id) {
		ArrayList<Collections> clist = dao.colList(id);
		int num = 1;
		for (Collections c : clist) {
			System.out.print(num++ + " ");
			System.out.println(c.getColname());
			System.out.println("---------------------------------------");
		}
		return clist;
	}

	// 컬랙션 내부 내용
	public String colBoard(String colcode) {
		ArrayList<Board> blist = dao.colBoard(colcode);
		int num = 1;
		for (Board b : blist) {
			System.out.print(num++ + " ");
			System.out.println(b.getImg());
			System.out.println("---------------------------------------");
		}
		return "출력";
	}

	// 게시물 저장
	public String saveBoard(String colcode, String bcode) {
		dao.saveBoard(colcode, bcode);
		return "저장완료";
	}
}
