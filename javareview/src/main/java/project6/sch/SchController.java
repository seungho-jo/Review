package project6.sch;

import java.util.Scanner;

public class SchController {

	SchService service = new SchService();
	Scanner sc = new Scanner(System.in);
	
	//아이디 검색
	public String schid(Model d) {
		System.out.println("# 유저 검색 #");
		System.out.print("검색 : ");
		String name = sc.nextLine();
		d.addAttribute("검색결과 출력", service.schmem(name));
		return "호출될 화면";
	}
	
	//태그 검색
	public String schtag(Model d) {
		System.out.println("# 태그 검색 #");
		System.out.print("검색 : ");
		String contents = sc.nextLine();
		d.addAttribute("검색결과 출력", service.schtag(contents));
		return "호출될 화면";
	}
}
