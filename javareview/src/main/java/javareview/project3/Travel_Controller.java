package javareview.project3;

import java.util.Scanner;

public class Travel_Controller {
	Scanner sc = new Scanner(System.in);
	String email = "";
	boolean result; 
	private Travel_Service ser_t = new Travel_Service();

	//관리자 영역
	public String insertTravel(Travel t,Model d) {
		d.addAttribute("정보등록", ser_t.insert(t));
		return "호출될 화면";
	}

	public String insertTravel2(Travel t, Model d) {
		d.addAttribute("정보등록", ser_t.insert2(t));
		return "호출될 화면";
	}

	public String deleteTravel(Model d) {
		System.out.print("* 삭제할 관광명소 번호를 입력해 주세요 : ");
		String msg = sc.nextLine();
		d.addAttribute("삭제결과", ser_t.delete(msg));
		return "호출될 화면";
	}

	public String modifyTravel(Model d) {
		System.out.print("* 수정할 관광명소 번호를 입력해 주세요 : ");
		String num = sc.nextLine();
		d.addAttribute("수정결과", ser_t.modify(num));
		return "호출될 화면";
	}
	
	// 사용자 영역
	public String listTravel2(Model d) {
		d.addAttribute("정보출력", ser_t.showList());
		return "호출될 화면";
	}

	public String searchTravel(Model d) {
		System.out.print("* 검색어를 입력하세요 : ");
		String msg = sc.nextLine();
		d.addAttribute("검색결과", ser_t.search(msg));
		return "호출될 화면";
	}

	public String detail(Model d) {
		System.out.println("상세히 볼 관광명소를 선택해주세요");
		String cho = sc.nextLine();
		d.addAttribute("상세보기", ser_t.detail(cho));
		questionList(d);
		listRatings(d);
		System.out.println("추가행동을 입력해 주세요");
		System.out.println("정보수정업데이트\t리뷰남기기\t질문하기\t클립");
		switch(sc.nextLine()) {
		case "정보수정업데이트" :
			changingInfoTravel(ser_t.detail(cho).get(0).getKorName(),d);
			break;
		case "리뷰남기기" :
			login(d);
			if(result==false) {
				System.out.println("다시 로그인 하세요");
				break;
			}else{
				insertRatings(ser_t.member(email).getName(),ser_t.detail(cho).get(0).getKorName(),d);
				break;
			}
		case "질문하기" :
			login(d);
			if(result==false) {
				System.out.println("다시 로그인 하세요");
				break;
			}else{
				question(ser_t.member(email).getName(),ser_t.detail(cho).get(0).getKorName(),d);
				break;
			}
		case "클립" :
			login(d);
			if(result==false) {
				System.out.println("다시 로그인 하세요");
				break;
			}else{
				clip(cho,d);
				break;
			}
		}
		return "호출될 화면";
	}
	
	public String clip(String n,Model d) {
		System.out.println("클립을 추가하시겠습니까?(Y/N)");
		String cho = sc.nextLine();
		d.addAttribute("클립따기", ser_t.clip(cho,n));
		return "호출될 화면";
	}
	public String changingInfoTravel(String s,Model d) {
		System.out.println("요청할 카테고리를 선택해 주세요");
		String cate = sc.nextLine();
		System.out.println("수정할 내용을 적어주세요");
		String content = sc.nextLine();
		d.addAttribute("정보수정 요청", ser_t.changingInfo(s,cate,content));
		return "호출될 화면";
	}
	
	public String question(String s,String n,Model d) {
		System.out.println("제목: ");
		String title = sc.nextLine();
		System.out.println("내용: ");
		String content = sc.nextLine();
		System.out.println("태그: ");
		String tag = sc.nextLine();
		d.addAttribute("질문하기", ser_t.question(new Question_Travel(title,content,tag), s, n));
		return "호출될 화면";
	}
	
	public String questionList(Model d) {
		d.addAttribute("질문리스트", ser_t.questionList());
		return "호출될 화면";
	}
	
	public String login(Model d) {
		System.out.println("로그인");
		System.out.print("이메일: ");
		email = sc.nextLine();
		System.out.print("비밀번호: ");
		String pass = sc.nextLine();
		result = ser_t.login(email, pass);
		d.addAttribute("로그인",result );
		return "호출될 화면";
	}

	public String insertRatings(String s,String n,Model d) {
		System.out.println("만족도 선택");
		System.out.println("좋아요! 괜찮아요! 별로에요!");
		String feeling = sc.nextLine();
		System.out.println("리뷰입력");
		String review = sc.nextLine();
		d.addAttribute("정보등록", ser_t.rinsert(new Ratings(s,feeling,n,review)));
	    return "호출될 화면";
	}
	   
	public String listRatings(Model d) {
		d.addAttribute("정보출력", ser_t.rshowList());
	    return "호출될 화면";
	}
	 public String deleteRatings(Model d) {
         System.out.print("* 삭제할 리뷰번호를 입력해 주세요 : ");
         String msg = sc.nextLine();
         d.addAttribute("삭제결과", ser_t.delete1(msg));
         return "호출될 화면";
      }

      public String modifyRatings(Model d) {
         System.out.print("* 수정할 리뷰번호를 입력해 주세요 : ");     
         String num = sc.nextLine();
         d.addAttribute("수정결과", ser_t.modify1(num));
         return "호출될 화면";
      }
}
