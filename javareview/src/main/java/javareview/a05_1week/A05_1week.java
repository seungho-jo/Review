package javareview.a05_1week;

import javareview.a05_1week.cl.Classes;

public class A05_1week {
	public static void main(String[] args) {
		// 변수와 데이터 유형
		int num = 27;
		String name = "조승호";
		System.out.println(num);
		System.out.println(name);
		// 연산자의 종류 : 사칙연산자,나머지 연산자
		int num1 = 20;
		int num2 = 4;
		System.out.println("num1 + num2 = " + (num1+num2));
		System.out.println("num1 - num2 = " + (num1-num2));
		System.out.println("num1 * num2 = " + (num1*num2));
		System.out.println("num1 / num2 = " + (num1/num2));
		System.out.println("num1 % num2 = " + (num1%num2));
		//비교연산자
		System.out.println(num1 + " == " + num2 + " ==> " + (num1==num2));
		System.out.println(num1 + " != " + num2 + " ==> " + (num1!=num2));
		System.out.println(num1 + " >= " + num2 + " ==> " + (num1>=num2));
		System.out.println(num1 + " <= " + num2 + " ==> " + (num1<=num2));
		System.out.println(num1 + "  > " + num2 + " ==> " + (num1>num2));
		System.out.println(num1 + "  < " + num2 + " ==> " + (num1<num2));
		//조건문과 반복문
		int age = 27;
		if(age <= 19) {
			System.out.println("미성년자입니다");
		}else {
			System.out.println("성인입니다.");
		}
		int rcp = 2;
		switch(rcp) {
		case 0:
			System.out.println("추먹");
			break;
		case 1 :
			System.out.println("가위");
			break;
		case 2 : 
			System.out.println("보");
			break;
		default : break;
		}
		for(int i = 1; i <= 10; i++ ) {
			System.out.println(1);
		}
		//메서드와 배열
		test();
		minus(15, 5);
		int [] array1 = new int [3];
		int [] array2 = {3,6,9};
		System.out.println(array1);
		System.out.println(array2);
		System.out.println(array2[0]);
		System.out.println(array2[1]);
		System.out.println(array2[2]);
		//클래스
		A05_1week method1 = new A05_1week();
		Person p1 = new Person();
		System.out.println(p1.name);
		System.out.println(p1.age);
		System.out.println(p1.address);
		Classes c1 = new Classes();
		System.out.println(c1.name);
		System.out.println(c1.age);
		System.out.println(c1.address);
		Classes c2 = new Classes("조승호",27,"경기도 수원시");
		Classes c3 = new Classes();
		//System.out.println(c3.test1);
		//System.out.println(c3.test2);
		//System.out.println(c3.test3);
		System.out.println(c3.test4);
		//상속
		Piano piano = new Piano();
		piano.play();
		System.out.println(piano.sound);
		//추상클래스
		Ridding car1 = new Car();
		car1.ride();
		//인터페이스
		PublicTransport p2 = new PublicTransport();
		p2.setRide(new Bus());
		p2.Public();
		//예외처리
		try {
			System.out.println("예외처리 시작");
			System.out.println(10/0);
		}catch(Exception e) {
			System.out.println("오류발생");
		} finally {
			System.out.println("프로그램 종료");
		}
	}
	//메서드와 배열
	public static void test() {
		System.out.println("리턴없는 메서드");
	}
	public static int minus(int num01, int num02) {
		int tot = num01+num02;
		return tot;
	}
}
class Person{
	String name = "조승호";
	int age = 27;
	String address = "경기도 수원시";
}
class Sound{
	String sound = "소리가 들린다";
	void soundding() {
		System.out.print("소리가 난다");
	}
}
class Piano extends Sound{
	void play() {
		System.out.println("피아노에서");
		soundding();
	}
}
abstract class Ridding{
	abstract void ride();
}
class Car extends Ridding{

	@Override
	void ride() {
		// TODO Auto-generated method stub
		System.out.println("자동차에 타다");
	}
	
}
interface RideWay{
	void ridding();
}
class Bus implements RideWay{

	@Override
	public void ridding() {
		// TODO Auto-generated method stub
		System.out.println("버스를 타다");
	}
	
}
class PublicTransport{
	private RideWay ridding;
	public void setRide(RideWay ridding) {
		this.ridding = ridding;
	}
	public void Public(){
		if(ridding != null) {
			ridding.ridding();
		}
		else {
			System.out.println("대중교통이 없습니다");
		}
	}
}