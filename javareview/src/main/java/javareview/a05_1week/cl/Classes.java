package javareview.a05_1week.cl;

public class Classes {
	public String name = "조승호";
	public int age = 27;
	public String address = "경기도 수원시";
	
	public Classes() {
		
	}
	public Classes(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
		System.out.println(name);
		System.out.println(age);
		System.out.println(address);
	}
	
	private String test1 = "java";
	String test2 = "java";
	protected String test3 = "java";
	public String test4 = "java";
	
}

