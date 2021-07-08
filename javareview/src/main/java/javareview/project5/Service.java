package javareview.project5;

import java.util.ArrayList;

public class Service {
	Dao dao = new Dao();
	// 로그인
	public boolean login(String i, int p) {
		boolean result = dao.login(i, p);
		if (result) {
			System.out.println("로그인 성공");
			return true;
		} else {
			System.out.println("로그인 실패");
			return false;
		}
	}
	// 회원정보 통계 - 최근회원가입자 정보
	public String thisWeekMemberInfo() {
		ArrayList<Member> mlist = dao.thisWeekMemberInfo();
		String result = "";
		System.out.println("가입날자\t아이디\t이메일\t동의여부");
		for(Member list:mlist) {
			if(list.getMrkAgree() == 1) {
				result = "동의";
			}else {
				result = "비동의";
			}
			System.out.print(list.getMdate()+"\t");
			System.out.print(list.getMemId()+"\t");
			System.out.print(list.getMemEmail()+"\t");
			System.out.println(result);
			System.out.println("-------------------------");
		}
		return "출력완료";
	}
	// 회원정보 통계
	public String total() {
		int[] list = dao.total();
		System.out.println("신규회원\t주간회원\t탈퇴회원\t총 회원수");
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+"\t");
		}
		return "출력완료";
	}
	// 회원정보 나열/정렬
	public String memberInfo(String s) {
		if(s.equals("내림차순")) {
			s = "desc";
		}else if(s.equals("오름차순")) {
			s = "asc";
		}
		ArrayList<Member> mlist = dao.memberInfo(s);
		String result = "";
		int i = 1;
		System.out.println("번호\t아이디\t이메일\t휴대폰번호\t동의여부\t가입날자");
		for(Member list:mlist) {
			if(list.getMrkAgree() == 1) {
				result = "동의";
			}else {
				result = "비동의";
			}
			StringBuffer phone = new StringBuffer(list.getPhoneNum());
			phone.insert(4, "-");
			System.out.print(i+"\t");
			System.out.print(list.getMemId()+"\t");
			System.out.print(list.getMemEmail()+"\t");
			System.out.print("010-"+phone+"\t");
			System.out.print(result+"\t");
			System.out.println(list.getMdate().substring(0,10));
			System.out.println("-------------------------");
			i++;
		}
		return "출력완료";
	}
	// 상품 통계
	public String pTotal() {
		int[] list = dao.pTotal();
		System.out.println("총상품\t판매중\t품절\t삭제상품");
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+"\t");
		}
		return "출력완료";
	}
	// 상품정보 통계 - 최근등록한 상품정보
		public String latelyProduct() {
			ArrayList<Product> plist = dao.latelyProduct();
			System.out.println("등록날자\t상품코드\t상품명\t가격");
			for(Product list: plist) {
				System.out.print(list.getPdate()+"\t");
				System.out.print(list.getPcode()+"\t");
				System.out.print(list.getPname()+"\t");
				System.out.println(list.getPrice());
				System.out.println("-------------------------");
			}
			return "출력완료";
		}
	// 상품 등록
	public String insertPoduct(String s,String n,String b,String c,int p,String d,String size,int cnt) {
		if(s.equals("아우터")) {
			s = "OT";
		}else if(s.equals("상의")) {
			s = "TP";
		}
		String[] sizes = size.split(",");
		dao.insertProduct(s, n, b, c, p, d,sizes,cnt);
		return "입력완료";
	}
	// 상품 리스트
	public String proList() {
		ArrayList<Product> list = dao.proList();
		System.out.println("상품번호\t상품명\t가격\t재고");
		for(Product pro: list) {
			System.out.print(pro.getPcode()+"\t");
			System.out.print(pro.getPname()+"\t");
			System.out.print(pro.getPrice()+"\t");
			System.out.println(pro.getCnt());
		}
		return "출력완료";
	}
	// 상품 불러오기
	public Product showProduct(String n) {
		Product pro = dao.showProduct(n);
		System.out.println("상품코드: "+pro.getPcode());
		System.out.println("상품명: "+pro.getPname());
		System.out.println("상품 브랜드: "+pro.getPbrand());
		System.out.println("색상: "+pro.getColor());
		System.out.println("가격: "+pro.getPrice());
		System.out.println("사이즈: "+pro.getSize());
		System.out.println("재고량: "+pro.getCnt());
		return pro;
	}
	// 상품 수정
	public String updateProduct(ArrayList a,ArrayList b,String c) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).equals("상품명")) {
				a.set(i, "pname");
			}else if(a.get(i).equals("브랜드")) {
				a.set(i, "pbrand");
			}else if(a.get(i).equals("색상")) {
				a.set(i, "color");
			}else if(a.get(i).equals("가격")) {
				a.set(i, "price");
			}
		}
		dao.updateProduct(a,b,c);
		return "출력완료";
	}
	// 상품 삭제
	public String deleteProduct(String c) {
		dao.deleteProduct(c);
		return "출력완료";
	}
}
