package javareview.project3;

import java.util.ArrayList;
import java.util.Scanner;

public class Travel_Service {
	Scanner sc = new Scanner(System.in);
	Travel_Dao d = new Travel_Dao();

	// 내용입력1
	public ArrayList<Travel> insert(Travel t) {
		return d.insertTravel(t);
	}

	// 내용입력2
	public ArrayList<Travel> insert2(Travel t) {
		return d.insertTravel2(t);
	}

	// 리스트 출력
	public String showList() {
		// TODO Auto-generated method stub

		ArrayList<Travel> list = d.showList();
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 이름\t\t주소\t클립수\t내용\t카테고리");
		for (int i = 0; i < list.size(); i++) {
			if ((i + 1) % 10 == 0) {
				System.out.print(" " + (i + 1) + " ");
				System.out.print(list.get(i).getKorName() + "\t");
				System.out.print(list.get(i).getLoc() + "\t");
				System.out.print(list.get(i).getClip() + "\t");
				System.out.print(list.get(i).getContent() + "\t");
				System.out.println(list.get(i).getCategory());
				System.out.println("다음페이지로 넘기겠습니까?(Y/N)");
				String cho = sc.nextLine();
				if (cho.equals("Y")) {
					System.out.println("페이지 전환");
				} else if (cho.equals("N")) {
					break;
				}
			} else {
				System.out.print(" " + (i + 1) + " ");
				System.out.print(list.get(i).getKorName() + "\t");
				System.out.print(list.get(i).getLoc() + "\t");
				System.out.print(list.get(i).getClip() + "\t");
				System.out.print(list.get(i).getContent() + "\t");
				System.out.println(list.get(i).getCategory());
			}
		}
		return "출력완료";
	}

	// 검색
	public String search(String s) {
		ArrayList<Travel> list = d.search(s);
		System.out.println("번호 이름\t\t주소\t클립수\t내용\t카테고리");
		if (list.size() == 0) {
			System.out.println("검색 결과가 없습니다");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(" " + (i + 1) + " ");
				System.out.print(list.get(i).getKorName() + "\t");
				System.out.print(list.get(i).getLoc() + "\t");
				System.out.print(list.get(i).getClip() + "\t");
				System.out.print(list.get(i).getContent() + "\t");
				System.out.println(list.get(i).getCategory());
			}
		}
		return "출력완료";
	}

	// 목록 삭제
	public String delete(String s) {
		ArrayList<Travel> list = d.delete(s);
		System.out.println("삭제 완료되었습니다");
		System.out.println("남은 관광명소의 수는 " + list.size() + "개 입니다");
		return showList();
	}

	// 목록 수정
	public String modify(String s) {
		ArrayList<Travel> list = d.modify(s);
		for (Travel t : list) {
			System.out.print(t.getNation() + " ");
			System.out.print(t.getKorName() + " ");
			System.out.print(t.getEngName() + " ");
			System.out.print(t.getLoc() + " ");
			System.out.print(t.getClip() + " ");
			System.out.print(t.getContent() + " ");
			System.out.print(t.getCategory() + " ");
			System.out.print(t.getPnum() + " ");
			System.out.println(t.getWeb());
		}
		System.out.println("수정할 정보를 골라주세요");
		System.out.println("리스트 : 국가/지역\t이름\t영문이름\t주소\t내용\t카테고리\t전화번호\t웹주소");
		System.out.print("선택: ");
		String modifyInfo = sc.nextLine();
		switch (modifyInfo) {
		case "국가/지역":
			System.out.println("국가/지역 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setNation(sc.nextLine());
			break;
		case "이름":
			System.out.println("이름 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setKorName(sc.nextLine());
			break;
		case "영문이름":
			System.out.println("영문이름 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setEngName(sc.nextLine());
			break;
		case "주소":
			System.out.println("주소 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setLoc(sc.nextLine());
			break;
		case "내용":
			System.out.println("내용 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setContent(sc.nextLine());
			break;
		case "카테고리":
			System.out.println("카테고리 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setCategory(sc.nextLine());
			break;
		case "전화번호":
			System.out.println("전화번호 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setPnum(sc.nextLine());
			break;
		case "웹주소":
			System.out.println("웹주소 선택");
			System.out.println("변경할 내용: ");
			list.get(0).setWeb(sc.nextLine());
			break;
		}
		d.list.set(Integer.parseInt(s) - 1, list.get(0));
		return "수정완료";
	}

	// 상세보기
	public ArrayList<Travel> detail(String s) {
		ArrayList<Travel> list = d.detail(s);
		System.out.println("  이름\t\t주소\t클립수\t내용\t\t카테고리\t폰번호\t\t웹사이트");
		System.out.print(list.get(0).getKorName());
		System.out.print("(" + list.get(0).getEngName() + ")\t");
		System.out.print(list.get(0).getLoc() + "\t");
		System.out.print(list.get(0).getClip() + "\t");
		System.out.print(list.get(0).getContent() + "\t");
		System.out.print(list.get(0).getCategory() + "\t");
		System.out.print(list.get(0).getPnum() + "\t");
		System.out.println(list.get(0).getWeb());
		return list;
	}

	// 클립수 증가
	public String clip(String s,String n){
		Travel list = d.clip(n);
		if(s.equals("Y")) {
			int a = list.getClip();
			a++;
			list.setClip(a);
		}
		System.out.println("클립수 증가");
		d.list.set(Integer.parseInt(n)-1, list);
		return "클립추가";
	}
	
	// 정보수정요청
	public String changingInfo(String r, String s, String m) {
		d.changingInfo(r, s, m);
		return "요청완료";
	}
	
	// 질문하기
	public String question(Question_Travel q,String s,String n) {
		d.question(q, s, n);
		return "질문완료";
	}
	
	// 질문 리스트
	public String questionList(){
		ArrayList<Question_Travel> qlist = d.questionList();
		System.out.println("작성자\t날짜\t\t\t이름\t제목\t내용\t태그 ");
		for(int i=0;i<qlist.size();i++) {
			if ((i + 1) % 10 == 0) {
				System.out.print(qlist.get(i).getWriter()+"\t");
				System.out.print(qlist.get(i).getDate() + "\t");
				System.out.print(qlist.get(i).getName() + "\t");
				System.out.print(qlist.get(i).getTitle()+"\t");
				System.out.print(qlist.get(i).getContent() + "\t");
				System.out.println(qlist.get(i).getTag());
				System.out.println("다음페이지로 넘기겠습니까?(Y/N)");
				String cho = sc.nextLine();
				if (cho.equals("Y")) {
					System.out.println("페이지 전환");
				} else if (cho.equals("N")) {
					break;
				}
			} else {
				System.out.print(qlist.get(i).getWriter()+"\t");
				System.out.print(qlist.get(i).getDate() + "\t");
				System.out.print(qlist.get(i).getName() + "\t");
				System.out.print(qlist.get(i).getTitle()+"\t");
				System.out.print(qlist.get(i).getContent() + "\t");
				System.out.println(qlist.get(i).getTag());
			}
		}
		return "출력완료";
	}
	
	// 리뷰 작성
	public ArrayList<Ratings> rinsert(Ratings r) {
		   return d.insertRatings(r);
	}
	
	// 리뷰 리스트
	public String rshowList() {
		// TODO Auto-generated method stub
		ArrayList<Ratings> list = d.rshowList();
		Scanner sc = new Scanner(System.in);
		System.out.println("작성자\t날짜\t\t\t기분\t장소\t내용");
		for(int i=0;i<list.size();i++) {
			if((i+1)%10==0) {
			    System.out.print(list.get(i).getName()+"\t");
			    System.out.print(list.get(i).getDate()+"\t");
			    System.out.print(list.get(i).getFeeling()+"\t");
			    System.out.print(list.get(i).getPlace()+"\t");
			    System.out.println(list.get(i).getReview()+"\t");
			    System.out.println("다음페이지로 넘기겠습니까?(Y/N)");
			    String cho = sc.nextLine();
			    if(cho.equals("Y")) {
			    	System.out.println("페이지 전환");
			    }else if(cho.equals("N")) {
			    	break;
			    }
			}else {
			    System.out.print(list.get(i).getName()+"\t");
			    System.out.print(list.get(i).getDate()+"\t");
			    System.out.print(list.get(i).getFeeling()+"\t");
			    System.out.print(list.get(i).getPlace()+"\t");
			    System.out.println(list.get(i).getReview());
			}
		}
		return "출력완료";
	}
	
	// 로그인
	public boolean login(String e, String p) {
		if(d.login(e, p)) {
			System.out.println("로그인 성공");
			return true;
		}else {
			System.out.println("로그인 실패");
			return false;
		}
	}
	
	// 회원정보 불러오기
	public TravelUser member(String e){
		return d.member(e);
	}
	//삭제
    public String delete1(String s) {
         ArrayList<Ratings> list = d.delete1(s);
         System.out.println("삭제 완료되었습니다");
         System.out.println("남은 리뷰는 " + list.size() + "개 입니다");
         return showList();
      }
     // 목록 수정
      public String modify1(String s) {
         ArrayList<Ratings> list = d.modify1(s);
         for (Ratings t : list) {
            System.out.print(t.getPlace() + " ");
         }
         System.out.println("수정할 정보를 골라주세요");
         System.out.println("리스트 : 리뷰\t만족도");
         System.out.print("선택: ");
         String modifyInfo = sc.nextLine();
         switch (modifyInfo) {
         case "리뷰":
            System.out.println("리뷰 번호 선택");
            System.out.println("변경할 내용: ");
            list.get(0).setReview(sc.nextLine());
            break;
         case "만족도":
             System.out.println("리뷰 번호 선택!");
             System.out.println("만족도 선택\n좋아요! 괜찮아요! 별로에요!");
             list.get(0).setFeeling(sc.nextLine());
             break;
         }
         d.listt.set(Integer.parseInt(s) - 1, list.get(0));
         return "수정완료";
      }
}


