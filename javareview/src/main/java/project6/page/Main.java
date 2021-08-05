package project6.page;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Controller ctl = new Controller();
		Board board = new Board();
		System.out.println("로그인");
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String pass = sc.nextLine();
		
		// 게시물 조회
		ctl.boardList(new Model(), id);
		
		// 게시물 선택 후 보기
		System.out.println("게시물 선택");
		int choice = Integer.parseInt(sc.nextLine());
		ctl.setBoard(new Model(), choice, id);
		
		
		// 게시물 수정
		System.out.println("#게시글 작성#");
		System.out.println("내용");
		String contents = sc.nextLine();
		board.setContents(contents);
		System.out.println("사진 등록");
		String img = sc.nextLine();
		board.setImg(img);
		System.out.println("태그 등록");
		String tag = sc.nextLine();
		board.setTag(tag);
		System.out.println("위치 등록");
		String loc = sc.nextLine();
		board.setLoc(loc);
		System.out.println("공개 범위");
		String pubRange = sc.nextLine();
		board.setPubRange(pubRange);
		board.setID(id);
		ctl.updateBoard(new Model(), board);
		
		/*
		// 로그인 이후 게시물 작성
		System.out.println("#게시글 작성#");
		System.out.println("내용");
		String contents = sc.nextLine();
		board.setContents(contents);
		System.out.println("사진 등록");
		String img = sc.nextLine();
		board.setImg(img);
		System.out.println("태그 등록");
		String tag = sc.nextLine();
		board.setTag(tag);
		System.out.println("위치 등록");
		String loc = sc.nextLine();
		board.setLoc(loc);
		System.out.println("공개 범위");
		String pubRange = sc.nextLine();
		board.setPubRange(pubRange);
		board.setID(id);
		ctl.writeBoard(new Model(),board);
		*/
		/*
		// 태그된 게시글 리스트
		System.out.print("태그입력: ");
		String tag = sc.nextLine();
		ctl.tagBoard(new Model(), tag);
		*/
		/*
		// 컬랙션 생성
		System.out.print("컬랙션 이름을 지어주세요: ");
		String colname = sc.nextLine();
		ctl.createCollection(new Model(), id, colname);
		*/
		
		// 게시물 저장
		System.out.println("게시물을 저장하시겠습니까?");
		String sel = sc.nextLine();
		if(sel.equals("Y")) {
			ctl.colList(new Model(), id);
			System.out.println("컬랙션 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			ctl.saveBoard(new Model(), num);
		}
		
		ctl.colList(new Model(), id);
		System.out.println("컬랙션 선택 : ");
		int num = Integer.parseInt(sc.nextLine());
		ctl.colBoard(new Model(), num);
	}

}
