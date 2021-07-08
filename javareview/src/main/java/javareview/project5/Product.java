package javareview.project5;

public class Product {
	private String pcode; // 상품코드
	private String pname; // 상품명
	private String pbrand; // 브랜드명
	private String color; // 컬러
	private int price; // 가격
	// private int price2 // 가격순
	private String pdate; // 입고날짜
	private int tolcnt; // 판매량
	private int cnt; // 재고량
	private String size; // 사이즈
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	/*
	public int getTolcnt() {
		return tolcnt;
	}
	public void setTolcnt(int tolcnt) {
		this.tolcnt = tolcnt;
	}
	*/
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
