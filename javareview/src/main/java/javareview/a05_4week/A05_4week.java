package javareview.a05_4week;

public class A05_4week {
	static void err1(String[] args) throws ArrayIndexOutOfBoundsException{
		System.out.println(args[0]);
	}
	static void err2(String[] args) throws ArrayIndexOutOfBoundsException{
		System.out.println(args[0]);
	}
	static void err3(String[] args) throws ArrayIndexOutOfBoundsException{
		System.out.println(args[0]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flower f1 = new Flower("장미");
//		f1.color = "노랑";    final 을 붙이면 변경 불가능
		f1.view();
		f1.view();
		f1.view();
		f1.view();
		f1.buy();
		f1.buy();
		f1.show();
		int[] arry = new int[2];
		try {
			System.out.println(arry[3]);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			err1(args);
			err2(args);
			err3(args);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

}
class Flower{
	String name;
	static int tot;
	int water;
	final String color="빨강";
	static final int date = 0;
	public Flower(String name) {
		this.name = name;
	} 
	public void view() {
		water++;
		tot ++;
//		date++;  --> date는 static final 이기에 변할수가 없다
	}
	public void buy() {
		water--;
		tot --;
//		date++;  --> date는 static final 이기에 변할수가 없다
	}
	public void show() {
		System.out.println("색깔: " + color);
		System.out.println("이름: " + name);
		System.out.println("물 공급량: " + water);
		System.out.println("총 물 사용량: " + tot);
	}
	
}
/*
database
select문
구조
select 컬럼명 from 테이블명
컬럼명 as 별칭명 or 컬럼명 별칭명 : 컬럼명을 별칭으로 바꿈, 문자열 ""안에 넣고 띄어쓰기,특수문자,공백 가능
|| : 문자열 결합
컬럼에 산술연산자 사용가능
where 조건문
비교연산자,and,or,관계대수 등이 조건문에 들어감
is not null : null 데이터 검색
is not null : null이 아닌 데이터 검색

ex)
select * from emp;
select sal as "연봉" from emp;
select sal*20 from emp;
select * from emp where sal >=2000 or ename = 'jack';
select * from emp where comm is null;
*/