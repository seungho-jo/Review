package project6.follow;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Controller ctl = new Controller();
		Follow f = new Follow();
		
		
		System.out.println("로그인");
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String pass = sc.nextLine();
		
		// 팔로잉 진행
		System.out.println("#팔로잉 진행#");
		System.out.print("팔로우할 id: ");
		String follow = sc.nextLine();
		ctl.follow(new Model(), new Follow(id, follow));

		// 특정 id의 팔로워 보기
		System.out.println("팔로워/팔로잉 볼 계정: ");
		String fid = sc.nextLine();
		ctl.followerList(new Model(), fid);
		ctl.followingList(new Model(), fid);
		

	}
}
