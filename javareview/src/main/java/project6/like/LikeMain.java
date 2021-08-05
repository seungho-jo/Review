package project6.like;


import java.util.Scanner;


public class LikeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LikeController ctrl = new LikeController();
		Board board = new Board();
		Scanner sc = new Scanner(System.in);
		String id ="";
		String pass = "";
		String bcode = "";
		boolean x = true;
		
		while(x) {
			System.out.println("## scrollBook 피드 ##");
			System.out.println("[1] 좋아요 클릭");
			System.out.println("한번 더 누를 시 취소됩니다.");
			System.out.println("");
			int cho = Integer.parseInt(sc.nextLine());
			switch(cho) {
				case 1:
					System.out.print("아이디: ");
					id = sc.nextLine();
					System.out.print("비밀번호: ");
					pass = sc.nextLine();
					System.out.println("게시물 리스트");
					ctrl.boardListall(new Model());
					System.out.println("-게시물 선택-");
					System.out.println("게시물 선택");
					int choice = Integer.parseInt(sc.nextLine());
					ctrl.setBoard(new Model(), choice);
					System.out.println("# 좋아요클릭 #");		
					ctrl.like(new Model(),id);
					break;
			}
		}
		
		
		
	}

}
