package javareview.project4;

import java.util.ArrayList;

public class BookStore_Service {
	BookStore_Dao bsd = new BookStore_Dao();
	// 책방 리스트
	public String bookStoreList() {
		ArrayList<BookStore> list = bsd.bookStoreList();
		for(BookStore b: list) {
			System.out.print(b.getName());
			System.out.println("("+b.getKind()+")");
			System.out.println("전화번호 "+b.getPnum());
			System.out.println("주소 "+b.getLoc());
			System.out.println("홈페이지 "+b.getWeb());
			System.out.println("SNS "+b.getSns());
			System.out.println("--------------------------------");
		}
		return "출력완료";
	}
	// 책방 검색
	public String searchList(String k,String l,String n) {
		ArrayList<BookStore> list = bsd.searchList(k,l,n);
		for(BookStore b: list) {
			System.out.print(b.getName());
			System.out.println("("+b.getKind()+")");
			System.out.println("전화번호 "+b.getPnum());
			System.out.println("주소 "+b.getLoc());
			System.out.println("홈페이지 "+b.getWeb());
			System.out.println("SNS "+b.getSns());
			System.out.println("--------------------------------");
		}
		return "출력완료";
	}
	// 연도별 행사자료 프로그램 리스트
	public String eventList(String s,int y) {
		ArrayList<EventDataByYear> list = bsd.eventList(s,y);
		int num = list.size();
		System.out.println("No.\t연도\t제목\t작성자\t작성일\t조회수");
		for(EventDataByYear d: list) {
			System.out.print(num+"\t");
			System.out.print(d.getEvtyear()+"\t");
			System.out.print(d.getTitle()+"\t");
			System.out.print(d.getWriter()+"\t");
			System.out.print(d.getWdate()+"\t");
			System.out.println(d.getVisit()+"\t");
			num--;
		}
		return "출력완료";
	}
	// 연도별 행사자료 상세보기
	public String detailEvent(String s) {
		EventDataByYear data = bsd.detailEvent(s);
		System.out.print(data.getTitle()+"\t");
		System.out.println(data.getWdate());
		System.out.print(data.getWriter()+"\t");
		System.out.println("조회 "+data.getVisit());
		System.out.println(data.getContent());
		System.out.println(data.getImg());
		return "출력완료";
	}
	// 상세보기 진입시 조회수 증가
	public void upCount(String s) {
		bsd.upCount(s);
	}
	// 연도별 행사자료 필터링 검색
	public String searchEvent(int y,String t, String c, String d1, String d2, String k) {
		ArrayList<EventDataByYear> list = bsd.searchEvent(y,t,c,d1,d2,k);
		int num = list.size();
		System.out.println("No.\t연도\t제목\t작성자\t작성일\t조회수");
		for(EventDataByYear d: list) {
			System.out.print(num+"\t");
			System.out.print(d.getEvtyear()+"\t");
			System.out.print(d.getTitle()+"\t");
			System.out.print(d.getWriter()+"\t");
			System.out.print(d.getWdate()+"\t");
			System.out.println(d.getVisit()+"\t");
			num--;
		}
		return "출력완료";
	}
	// 도서관 리스트
	public String libraryList() {
		ArrayList<Library> list = bsd.libraryList();
		int cnt = list.size();
		int num = 1;
		for(Library l: list) {
			System.out.println(num+". "+l.getName());
			System.out.println("이용시간 "+l.getUsetime());
			System.out.println("휴관일 "+l.getClosedDay());
			System.out.println("전화번호 "+l.getPnum());
			System.out.println("홈페이지 "+l.getWeb());
			System.out.println("주소 "+l.getLoc());
			System.out.println("책이음 "+l.getBookjoin());
			System.out.println("--------------------------------");
			if(num != cnt) {
				num++;
			}
		}
		return "출력완료";
	}
	// 도서관 검색
	public String searchLib(String k,String l,String n) {
		ArrayList<Library> list = bsd.searchLib(k,l,n);
		int cnt = list.size();
		int num = 1;
		for(Library lib: list) {
			System.out.println(num+". "+lib.getName());
			System.out.println("이용시간 "+lib.getUsetime());
			System.out.println("휴관일 "+lib.getClosedDay());
			System.out.println("전화번호 "+lib.getPnum());
			System.out.println("홈페이지 "+lib.getWeb());
			System.out.println("주소 "+lib.getLoc());
			System.out.println("책이음 "+lib.getBookjoin());
			System.out.println("--------------------------------");
			if(num != cnt) {
				num++;
			}
		}
		return "출력완료";
	}
	// 도서 자료 상세 검색
	public String searchBooks(String k1,String sw1,String logic,String k2,String sw2,int year1,int year2) {
		ArrayList<Books> list = bsd.searchBooks(k1,sw1,logic,k2,sw2,year1,year2);
		System.out.println("총계 "+list.size());
		for(Books b: list) {
			System.out.println(b.getName());
			System.out.println("저자 "+b.getWriter());
			System.out.println("출판일 "+b.getPdate());
			System.out.println(b.getLib());
			System.out.println("--------------------------------");
		}
		return "출력완료";
	}
	// 나의 검색 설정 만들기
	public String searchset(String e,String n,String l) {
		bsd.searchset(e, n, l);
		return "저장완료";
	}
	// 나의 검색 설정 도서관 추가
	public String addLibrary(String l,String e,String n) {
		bsd.addLibrary(l, e, n);
		return "추가완료";
	}
	// 나의 검색 설정 보기
	public String showSearchSet(String e) {
		ArrayList<SearchSet> list = bsd.showSearchSet(e);
		for(SearchSet s: list) {
			System.out.print(s.getSearchname()+"\t");
			String[] lib = s.getLibrary().split(",");
			for(int i=0;i<lib.length;i++) {
				if(i >= 1) {
					System.out.print("\t");
				}
				System.out.println(lib[i]);
			}
			System.out.println("-----------------------------");
		}
		return "추가완료";
	}
}
