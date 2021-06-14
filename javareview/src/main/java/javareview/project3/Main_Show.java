package javareview.project3;

import java.util.Scanner;

public class Main_Show {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String[] type1 = {"","불만","",""}; String[] type2 = {"","","문의",""}; String[]
		 * type3 = {"","","","제언"}; Question_Controller q = new Question_Controller();
		 * q.question(new
		 * Question("조승호","01041208807","jsh95320@naver.com",type1,"테스트1","테스트글입니다"),
		 * new Model()); q.question(new
		 * Question("홍길동","01012345678","hgd95320@naver.com",type2,"테스트2","테스트글입니다"),
		 * new Model()); q.question(new
		 * Question("고길동","01022657894","ggd95320@naver.com",type3,"테스트3","테스트글입니다"),
		 * new Model()); q.questionList(null, new Model()); q.detailQuestion(null, new
		 * Model());
		 */

		Travel_Controller t = new Travel_Controller();
		Scanner sc = new Scanner(System.in);
		// 정보 입력
		/*
		 * System.out.println("정보입력"); while(true) { String nation = sc.nextLine();
		 * String korName = sc.nextLine(); String engName = sc.nextLine(); String loc =
		 * sc.nextLine(); String content = sc.nextLine(); String category =
		 * sc.nextLine(); String pnum = sc.nextLine(); String web = sc.nextLine();
		 * t.insertTravel(new
		 * Travel(nation,korName,engName,loc,0,content,category,pnum,web),new Model());
		 * System.out.println("더 입력하시겠습니까?"); if(sc.nextLine().equals("N")) { break;
		 * }else { continue; } }
		 */
		// t.modifyTravel(new Model());
		// t.listTravel2(new Model());
		// t.searchTravel(new Model());
		// t.deleteTravel(new Model());

		// Travel_Controller t = new Travel_Controller();
		
		t.insertTravel2(
				new Travel("하와이", "와이키키1", "whycici", "@@시", 1, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키2", "whycici", "@@시", 2, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키3", "whycici", "@@시", 3, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키4", "whycici", "@@시", 4, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키5", "whycici", "@@시", 5, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키6", "whycici", "@@시", 6, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키7", "whycici", "@@시", 7, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키8", "whycici", "@@시", 8, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키9", "whycici", "@@시", 9, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키10", "whycici", "@@시", 10, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키11", "whycici", "@@시", 11, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키12", "whycici", "@@시", 12, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키13", "whycici", "@@시", 13, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키14", "whycici", "@@시", 14, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키15", "whycici", "@@시", 15, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키16", "whycici", "@@시", 16, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키17", "whycici", "@@시", 17, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키18", "whycici", "@@시", 18, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키19", "whycici", "@@시", 19, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키20", "whycici", "@@시", 20, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키21", "whycici", "@@시", 21, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키22", "whycici", "@@시", 22, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키23", "whycici", "@@시", 23, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키24", "whycici", "@@시", 24, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키25", "whycici", "@@시", 25, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키26", "whycici", "@@시", 26, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키27", "whycici", "@@시", 27, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.insertTravel2(
				new Travel("하와이", "와이키키28", "whycici", "@@시", 28, "소개합니다!!!", "명소", "345-2341-6234", "www.naver.com"),
				new Model());
		t.detail(new Model());
		//t.deleteRatings(new Model());
		t.modifyRatings(new Model());
		t.detail(new Model());
		//t.listTravel2(new Model());
		// t.modifyTravel(new Model());
		// t.searchTravel(new Model());
		//t.deleteTravel(new Model());
		//t.detail(new Model());
		//t.detail(new Model());
		//t.login(new Model());
		//t.clip(new Model());
	}

}
