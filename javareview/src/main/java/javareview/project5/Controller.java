package javareview.project5;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	Service s = new Service();
	Scanner sc = new Scanner(System.in);
	Product pro = new Product();
	// 로그인
	public String login(Model d) {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String pass = sc.nextLine();
		d.addAttribute("로그인", s.login(id, Integer.parseInt(pass)));
		return "main.jsp";
	}
	
	// 회원정보 통계 - 최근회원가입자 정보
	public String thisWeekMemberInfo(Model d) {
		d.addAttribute("최근회원가입자 정보", s.thisWeekMemberInfo());
		return "member.jsp";
	}

	// 회원정보 통계
	public String total(Model d) {
		d.addAttribute("회원정보 통계", s.total());
		return "member.jsp";
	}
	// 회원정보 나열/정렬
	public String memberInfo(Model d) {
		System.out.print("정렬방식: ");
		String choice = sc.nextLine();
		d.addAttribute("회원정보", s.memberInfo(choice));
		return "member.jsp";
	}
	// 상품 통계
	public String pTotal(Model d) {
		d.addAttribute("상품 통계", s.pTotal());
		return "ptotal.html";
	}
	// 상품 통계 - 최근 등록한 상품
	public String latelyProduct(Model d) {
		d.addAttribute("최근 등록한 상품", s.latelyProduct());
		return "ptotal.html";
	}
	// 상품 등록
	public String insertProduct(Model d,Product p) {
		d.addAttribute("상품등록", s.insertPoduct(p.getPcode(), p.getPname(), p.getPbrand(), p.getColor(), p.getPrice(), p.getPdate(),p.getSize(),p.getCnt()));
		return "insertProduct.html";
	}
	// 상품 리스트
	public String proList(Model d) {
		d.addAttribute("상품 리스트", s.proList());
		return "showProduct.html";
	}
	// 상품 불러오기
	public String showProduct(Model d,String p) {
		pro = s.showProduct(p);
		d.addAttribute("상품 불러오기", pro);
		return "showProduct.html";
	}
	// 상품 수정
	public String updateProduct(Model d,ArrayList list1,ArrayList list2) {
		d.addAttribute("상품수정", s.updateProduct(list1, list2, pro.getPcode()));
		return "showProduct.html";
	}
	// 상품 삭제
	public String deleteProduct(Model d) {
		d.addAttribute("상품삭제", s.deleteProduct(pro.getPcode()));
		return "showProduct.html";
	}
}
