package javareview.a05_2week;

public class A05_12 {
	public static void wearing(Wear w1) {
		w1.dress();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread
		String[] weather = {"흐림","맑음","비","안개"};
		for(int i=0;i<=weather.length-1;i++) {
			Weather w1 = new Weather(weather[i]);
			w1.start();
		}
		for(int i=1;i<=10;i++) {
			Weapon w2 = new Weapon("칼");
			Thread t1 = new Thread(w2);
			t1.start();
		}
		//lambda
		Wear w1 = new How();
		w1.dress();
		Wear w2 = new Wear() {

			@Override
			public void dress() {
				// TODO Auto-generated method stub
				System.out.println("스위터를 입다");
			}
			
		};
		w2.dress();
		wearing(new Wear() {

			@Override
			public void dress() {
				// TODO Auto-generated method stub
				System.out.println("옷을 입다(함수)");
			}
			
		});
		wearing(() -> {
			System.out.println("옷을 입다(람다식1)");
		});
		wearing(() -> System.out.println("옷을 입다(람다식2)"));
	}

}
class Weather extends Thread{
	private String weather;
	public Weather(String weather) {
		super();
		this.weather = weather;
	}
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(i+")날씨가" + weather);
		}
	}
}
class Weapon implements Runnable{
	private String kind;
	
	public Weapon(String kind) {
		super();
		this.kind = kind;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(kind + "을 장착하다");
	}
	
}
interface Wear{
	void dress();
}
class How implements Wear{

	@Override
	public void dress() {
		// TODO Auto-generated method stub
		System.out.println("어떤옷을 입어볼까");
	}
	
}