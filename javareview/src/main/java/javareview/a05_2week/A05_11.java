package javareview.a05_2week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class A05_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체 배열
		Fruits[] f1 = {
				new Banana(),
				new Apple(),
				new Strawberry()
		};
		for(Fruits f: f1) {
			f.eatting();
		}
		//Set,List,Map
		Set set = new HashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		System.out.println(set);
		List<Colors> color = new ArrayList<Colors>();
		color.add(new Colors("빨강", "파랑", "노랑"));
		color.add(new Colors("남색", "녹색", "흰색"));
		color.add(new Colors("연두", "주황", "검정"));
		for(Colors c: color) {
			System.out.println(c.getCol1());
			System.out.println(c.getCol2());
			System.out.println(c.getCol3());
		}
		Map<String, String> map = new Hashtable<String, String>();
		map.put("사과", "200");
		map.put("바나나", "2200");
		map.put("얼음", "700");
		System.out.println(map.get("사과"));
		System.out.println(map.get("바나나"));
		System.out.println(map.get("얼음"));
		//InputStream_char
		InputStream is = System.in;
		try {
			int num = is.read();
			System.out.println(num);
			System.out.println((char)num);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//InputStream_String
		BufferedReader buffer = 
				new BufferedReader(
						new InputStreamReader(System.in));
		String id;
		try {
			id = buffer.readLine();
			System.out.println(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Scanner
		Scanner sc = new Scanner(System.in);
		String pass;
		pass = sc.nextLine();
	}

}
//객체 배열
abstract class Fruits{
	abstract void eatting();
}
class Apple extends Fruits{

	@Override
	void eatting() {
		// TODO Auto-generated method stub
		System.out.println("사과를 먹다");
	}
	
}
class Banana extends Fruits{

	@Override
	void eatting() {
		// TODO Auto-generated method stub
		System.out.println("바나나를 먹다");
	}
	
}
class Strawberry extends Fruits{

	@Override
	void eatting() {
		// TODO Auto-generated method stub
		System.out.println("딸기를 먹다");
	}
	
}
//Set,List,Map
class Colors{
	String col1;
	String col2;
	String col3;
	public Colors(String col1, String col2, String col3) {
		super();
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	public String getCol2() {
		return col2;
	}
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	public String getCol3() {
		return col3;
	}
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	
}