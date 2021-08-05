package project6.page;

public class Collections {
	private String colcode;
	private String id;
	private String colname;
	public Collections() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collections(String colcode, String id, String colname) {
		super();
		this.colcode = colcode;
		this.id = id;
		this.colname = colname;
	}
	public String getColcode() {
		return colcode;
	}
	public void setColcode(String colcode) {
		this.colcode = colcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
}
