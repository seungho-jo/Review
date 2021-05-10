package javareview.a05_2week;

import java.util.Calendar;

import javareview.a05_2week.array.Example;

public class A05_10 {
	public enum WEEK{SUN,MON,THU,WEN,THR,FRI,SAT};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//캘린더
		Calendar cal = Calendar.getInstance();
		System.out.println(Calendar.YEAR + " = " + cal.get(Calendar.YEAR) + "년");
		System.out.println(Calendar.MONTH + " = " + (cal.get(Calendar.MONTH)+1) + "월");
		System.out.println(Calendar.DAY_OF_MONTH + " = " + cal.get(Calendar.DAY_OF_MONTH) + "일");
		String[] weekend = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		System.out.println(Calendar.DAY_OF_WEEK + " = " + weekend[(cal.get(Calendar.DAY_OF_WEEK)-1)]);
		//enum
		WEEK week = WEEK.MON;
		System.out.println(week);
		WEEK[] weekAry = week.values();
		System.out.println(weekAry[0]);
		System.out.println(weekAry[1]);
		System.out.println(weekAry[2]);
		for(WEEK w:weekAry) {
			System.out.println(w.name() + "," +w.ordinal());
		}
		//배열과 forEach
		String[] hobby1 = new String[5];
		String[] hobby2 = {"축구","사진","여행","노래"};
		System.out.println(hobby1.length);
		System.out.println(hobby2.length);
		Example[] e1 = {new Example("철수",17,2),
					  new Example("영희",19,8),
					  new Example("민수",18,40)
					};
		for(Example ee:e1) {
			System.out.print(ee.getName()+"\t");
			System.out.print(ee.getAge()+"\t");
			System.out.println(ee.getRank());
		}
	}

}
