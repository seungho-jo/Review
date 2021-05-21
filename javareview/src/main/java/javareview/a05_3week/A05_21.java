package javareview.a05_3week;

public class A05_21 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체,클래스,생성자
		JavaClass jc1 = new JavaClass();
		JavaClass jc2 = new JavaClass(1);
		JavaClass jc3 = new JavaClass(1,"홍길동");
		JavaClass jc4 = new JavaClass("홍길동",1);
		//this
		ThisExp th1 = new ThisExp("조승호");
		th1.show();
		ThisExp th2 = new ThisExp("조승호",27);
		th2.show();
		ThisExp th3 = new ThisExp("조승호",27,"수원");
		th3.show();
		//메서드
		MethodExp me = new MethodExp();
		System.out.println(me.meExp1());
		System.out.println(me.payment(0, 0));
		System.out.println(me.payment(1000, 1000));
		System.out.println(me.payment(10000, 1000));
		System.out.println(me.payment(1000, 10000));
		me.login(new Member("himan","77"));
	}

}
//객체,클래스,생성자
class JavaClass{
	public JavaClass() {
		System.out.println("매개변수없는 생성자");
	}
	public JavaClass(int a) {
		System.out.println("오버라이딩1");
	}
	public JavaClass(int a, String str) {
		System.out.println("오버라이딩2");
	}
	public JavaClass(String str,int a) {
		System.out.println("오버라이딩3");
	}
}
//this
class ThisExp{
	private String name;
	private int age;
	private String loc;
	public ThisExp(String name) {
		this.name = name;
	}
	public ThisExp(String name,int age) {
		this(name);
		this.age = age;
	}
	public ThisExp(String name,int age,String loc) {
		this(name,age);
		this.loc = loc;
	}
	void show() {
		System.out.println("입력받은 값:" +name+" "+age+" "+loc);
	}
}
class Member{
	String id;
	String pass;
	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
}
class MethodExp{
	String meExp1(){
		return "기본적인 메서드";
	}
	String payment(int a,int b) {
		if(b<=0) {
			return "결제 금액을 입력해 주세요";
		}else if(b>=a){
			return "잔액: "+(b-a);
		}else {
			return "금액이 부족합니다";
		}
	}
	void login(Member m) {
		if(m.id.equals("himan") && m.pass.equals("777")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
}