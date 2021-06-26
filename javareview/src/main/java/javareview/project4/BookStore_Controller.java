package javareview.project4;

import java.util.Scanner;

public class BookStore_Controller {
	BookStore_Service bss = new BookStore_Service();
	MemberService service = new MemberService();
	Scanner sc = new Scanner(System.in);
	String Loginmail = "";
	boolean result;

	// 책방 리스트
	public String bookStoreList(Model d) {
		d.addAttribute("리스트 출력", bss.bookStoreList());
		return "호출될 화면";
	}

	// 책방 검색
	public String searchList(Model d) {
		System.out.print("책방구분:");
		String kind = sc.nextLine();
		System.out.print("자치구:");
		String loc = sc.nextLine();
		System.out.print("책방이름:");
		String name = sc.nextLine();
		d.addAttribute("검색", bss.searchList(kind, loc, name));
		return "호출될 화면";
	}

	// 연도별 행사자료 리스트, 상세보기,조회수증가,필터링검색
	public String programList(Model d) {
		System.out.print("볼 자료를 선택해 주세요(프로그램/축제사진/보도자료):");
		String choice = sc.nextLine();
		System.out.print("연도를 선택해주세요:");
		String year = sc.nextLine();
		d.addAttribute("리스트 출력", bss.eventList(choice, Integer.parseInt(year)));
		searchEvent(d, year, choice);
		detailEvent(d);
		return "호출될 화면";
	}

	// 연도별 행사자료 상세보기, 조회수 증가
	public String detailEvent(Model d) {
		System.out.println("상세히 볼 게시물의 제목을 입력해주세요");
		String title = sc.nextLine();
		bss.upCount(title);
		d.addAttribute("상세보기", bss.detailEvent(title));
		return "호출될 화면";
	}

	// 연도별 행사자료 필터링 검색
	public String searchEvent(Model d, String y, String k) {
		System.out.print("연도:");
		String year = sc.nextLine();
		System.out.print("제목:");
		String title = sc.nextLine();
		System.out.print("내용:");
		String content = sc.nextLine();
		System.out.print("작성일(ㅁ~ㅁ):");
		String d1 = sc.nextLine();
		String d2 = sc.nextLine();
		if (year.equals("")) {
			year = y;
		}
		d.addAttribute("검색", bss.searchEvent(Integer.parseInt(year), title, content, d1, d2, k));
		return "호출될 화면";
	}

	// 도서관 리스트
	public String libraryList(Model d) {
		d.addAttribute("리스트 출력", bss.libraryList());
		return "호출될 화면";
	}

	// 책방 검색
	public String searchLib(Model d) {
		System.out.print("도서관구분:");
		String kind = sc.nextLine();
		System.out.print("자치구:");
		String loc = sc.nextLine();
		System.out.print("도서관명:");
		String name = sc.nextLine();
		d.addAttribute("검색", bss.searchLib(kind, loc, name));
		return "호출될 화면";
	}

	// 도서 자료 상세 검색
	public String searchBooks(Model d) {
		System.out.print("종류1 ");
		String k1 = sc.nextLine();
		System.out.print("검색어1 ");
		String sw1 = sc.nextLine();
		System.out.print("논리선택 ");
		String logic = sc.nextLine();
		System.out.print("종류2 ");
		String k2 = sc.nextLine();
		System.out.print("검색어2 ");
		String sw2 = sc.nextLine();
		System.out.print("연도1 ");
		String year1 = sc.nextLine();
		if (year1.equals("")) {
			year1 = "1984";
		}
		System.out.print("연도2 ");
		String year2 = sc.nextLine();
		if (year2.equals("")) {
			year2 = "2021";
		}
		d.addAttribute("상세검색",
				bss.searchBooks(k1, sw1, logic, k2, sw2, Integer.parseInt(year1), Integer.parseInt(year2)));
		return "호출될 화면";
	}

	// 나의 검색 리스트 만들기
	public String searchset(Model d) {
		System.out.println("로그인이 필요합니다");
		login(d);
		System.out.print("리스트 이름을 지어주세요 : ");
		String name = sc.nextLine();
		System.out.print("넣을 도서관을 적어주세요 : ");
		String lib = sc.nextLine();
		d.addAttribute("설정 만들기", bss.searchset(Loginmail, name, lib));
		return "호출될 화면";
	}
	// 나의 검색 리스트 도서관추가
	public String addLibrary(Model d) {
		showSearchSet(d);
		System.out.print("검색 리스트를 선택해주세요 :");
		String name = sc.nextLine();
		System.out.print("넣을 도서관을 적어주세요 : ");
		String lib = sc.nextLine();
		d.addAttribute("도서관 추가", bss.addLibrary(lib, Loginmail, name));
		return "호출될 화면";
	}
	// 나의 검색 설정 보기
	public String showSearchSet(Model d) {
		System.out.println("로그인이 필요합니다");
		login(d);
		d.addAttribute("리스트 출력", bss.showSearchSet(Loginmail));
		return "호출될 화면";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 회원가입
	public String joinMember(Model d) {
		Member me = new Member();
		System.out.print("도서관 아이디:");
		me.setLoginmail(sc.nextLine());
		System.out.print("비밀번호:");
		me.setLoginpass(sc.nextLine());
		System.out.print("이름:");
		me.setName(sc.nextLine());
		System.out.print("휴대폰번호:");
		me.setPhonenum(sc.nextLine());
		System.out.print("주소:");
		me.setAddress(sc.nextLine());
		System.out.println("모바일회원번호: -");
		me.setMobilememnum(null);

		d.addAttribute("회원가입결과", service.joinmember(me));
		return "호출될 화면";
	}

	// 로그인
	public String login(Model d) {
		System.out.println("# 로그인 #");
		System.out.print("이메일: ");
		Loginmail = sc.nextLine();
		System.out.print("비밀번호: ");
		String pass = sc.nextLine();
		result = service.login(Loginmail, pass);
		d.addAttribute("로그인결과", result);
		return "화면호출";
	}

}
