package javareview.project5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller c = new Controller();
		Scanner sc = new Scanner(System.in);
		Product pro = new Product();
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		//c.login(new Model());
		//c.totalMember(new Model());
		//c.total(new Model());
		//c.thisWeekMemberInfo(new Model());
		//c.memberInfo(new Model());
		/*
		System.out.println("상품을 등록합니다");
		System.out.print("상품종류: ");
		pro.setPcode(sc.nextLine());
		System.out.print("상품이름: ");
		pro.setPname(sc.nextLine());
		System.out.print("상품브랜드: ");
		pro.setPbrand(sc.nextLine());
		System.out.print("상품색깔: ");
		pro.setColor(sc.nextLine());
		System.out.print("상품가격: ");
		pro.setPrice(Integer.parseInt(sc.nextLine()));
		System.out.print("입고일: ");
		pro.setPdate(sc.nextLine());
		System.out.print("사이즈: ");
		pro.setSize(sc.nextLine());
		System.out.print("재고량: ");
		pro.setCnt(Integer.parseInt(sc.nextLine()));
		c.insertProduct(new Model(), pro);
		*/
		//c.pTotal(new Model());
		//c.latelyProduct(new Model());
		
		c.proList(new Model());
		/*
		System.out.println("상품을 선택해주세요: ");
		String name = sc.nextLine();
		c.showProduct(new Model(), name);
		System.out.println("선택헤주세요[수정] [삭제]");
		String choice = sc.nextLine();
		switch(choice) {
		case "수정" :
			while(true) {
				System.out.print("수정하고싶은 항목을 적어주세요: ");
				list1.add(sc.nextLine());
				System.out.print("변경 사항을 적어주세요: ");
				list2.add(sc.nextLine());
				System.out.print("종료하시겠습니까?(Y/N) : ");
				if(sc.nextLine().equals("Y")) {
					break;
				}
			}
			c.updateProduct(new Model(), list1,list2);
			break;	
		case "삭제" :
			c.deleteProduct(new Model());
			break;
		}
		*/
	}

}
