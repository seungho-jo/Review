package javareview.a05_4week;

import javareview.a05_4week.vo.A05_25_Vo;

public class A05_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// static,final,static final
		Dog.tot = 100;
		Dog d1 = new Dog("이름1");
		Dog d2 = new Dog("이름2");
		Dog d3 = new Dog("이름3");
		d1.eat();
		d1.buy();
		d1.buy();
		d1.buy();
		d1.buy();
		d2.eat();
		d2.eat();
		d2.eat();
		d2.buy();
		d2.eat();
		d3.eat();
		d3.eat();
		d3.buy();
		d3.buy();
		d1.show();
		d2.show();
		d3.show();
		//접근제어자
		Vo v1 = new Vo();
		v1.name1 = "홍길동";
		v1.name2 = "가길동";
		v1.name3 = "나길동";
//		v1.name4 = "다길동";
		A05_25_Vo v2 = new A05_25_Vo();
		System.out.println(v2.name1);
//		System.out.println(v2.name2);
//		System.out.println(v2.name3);
//		v1.name4 = "다길동";
	}

}
class Dog{
	String name;
	static int tot;
	int foods;
	final String kind="치와와";
	static final int date = 0;
	public Dog(String name) {
		this.name = name;
	} 
	public void eat() {
		foods--;
		tot--;
//		date++;  --> date는 static final 이기에 변할수가 없다
	}
	public void buy() {
		foods++;
		tot++;
//		date++;  --> date는 static final 이기에 변할수가 없다
	}
	public void show() {
		System.out.println("견종: " + kind);
		System.out.println("이름: " + name);
		System.out.println("사료량: " + foods);
		System.out.println("총 남은 사료량: " + tot);
	}
	
}