package javareview.a05_4week;

public class A05_27 {
	public static void main(String[] args) {
		// 예외처리
		try {
			System.out.println(1/0); 
		}catch(Exception e) {
			System.out.println("예외발셍");
			System.out.println(e.getMessage());
		}
		try {
			String[] str = {"java","python","C++"};
			System.out.println(str[5]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage());
		}
		try {
			err1();
			err2();
			err3();
		}catch(NullPointerException e) {
			System.out.println("에러발생");
			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("에러3");
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println("에러2");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("무조건 실행 코드");
		}
		
	}
	static void err1() throws NullPointerException{
		int[] arry = null;
		System.out.println(arry);
	}
	static void err2() throws NullPointerException{
		int[] arry = null;
		System.out.println(arry);
	}
	static void err3() throws NullPointerException{
		int[] arry = null;
		System.out.println(arry);
	}
}
